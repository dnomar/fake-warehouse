package com.everis.soa.catalog.app;

import com.everis.soa.catalog.model.ServiceInfoKind;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java8.util.function.Supplier;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CatalogLoaderOptions  {


    //--------------------------------------------------------------------------
    // class variables
    //--------------------------------------------------------------------------

    private static final Logger logger = LogManager.getLogger( CatalogLoaderOptions.class );

    private static final String CLASSPATH_SCHEME = "classpath:";

    private static final String HELP_HEADER = "";
    private static final String HELP_FOOTER =
        "Imports <input_path> into the services catalogue.";


    //--------------------------------------------------------------------------
    // class methods
    //--------------------------------------------------------------------------

    /**
     * Returns a new connection to an Oracle database.
     * The caller must close the connection.
     */
    public static Supplier<Connection> ojdbc6ConnectionSupplier(
            String db_hostname,
            String db_port,
            String db_sid,
            final String db_username,
            final String db_password
            )
    {
        // connection ... CAUTION: works only **without** '//' after '@'
        final String url = "jdbc:oracle:thin:@"+db_hostname+":"+db_port+":"+db_sid;
        return new Supplier<Connection>() {
            @Override
            public Connection get() {
                try {
                    logger.debug( "connection url: {}", url );
                    return DriverManager.getConnection( url, db_username, db_password );
                } 
                catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
        };
    }


    /**
     * Returns the URL specified by the path.
     * If path starts with 'classpath:' then a resource URL is returned.
     */
    public static URL inputPath( String path ) {
        try {
            Class clazz = CatalogLoaderOptions.class;
            return path.startsWith( CLASSPATH_SCHEME )
                ?  clazz.getResource( path.substring( CLASSPATH_SCHEME.length() ) )
                :  new URL( path );
        }
        catch ( MalformedURLException e ) {
            throw new RuntimeException( e );
        }
    }


    //--------------------------------------------------------------------------
    // instance variables
    //--------------------------------------------------------------------------

    private Option info_src_opt = Option
        .builder( "k" ).longOpt( "info-kind" )
        .argName( "kind" ).hasArg()
        .desc( "defines the kind of information to be imported (and the expected structure):"
                + "'osb-proxy-services': <input_path> is"
                + " a CSV containing proxy services URL path and the OSB project names"
                + " the service belongs to. The data is parsed from the line after"
                + " following line 'Proxy_URI,Proxy_Name'."
                + " Note that the 'Proxy_Name is the OSB project name."
                + " 'services-taxonomy': PENDING."
                + " 'access-logs': PENDING."
                )
        .required()
        .build();

    private Option input_opt = Option
        .builder( "i" ).longOpt( "input" )
        .argName( "input_path" ).hasArg()
        .desc( "Path or URL to CSV file containing the services information."
                + " When the URL scheme is 'classpath:' then the CSV file is retrieved"
                + " from the application's resources path (the classpath)."
                + " The CSV file content starts a the line containg 'Proxy_URI,Proxy_Name'"
                + " (previous lines are just skipped)."
                + " Then each line must contain a proxy service URI, a comma,"
                + " an OSB project name."
                )
        .required()
        .build();

    private Option domain_opt = Option
        .builder( "d" ).longOpt( "osb-domain" )
        .argName( "domain_name" ).hasArg()
        .desc( "name of the OSB domain the URL paths belong to" )
        .required()
        .build();

    private Option db_user_opt = Option
        .builder( "U" ).longOpt( "db-username" )
        .argName( "username" ).hasArg()
        .desc( "database connection username" )
        .required()
        .build();

    private Option db_pass_opt = Option
        .builder( "P" ).longOpt( "db-password" )
        .argName( "password" ).hasArg()
        .desc( "database connection password" )
        .required()
        .build();

    private Option db_host_opt = Option
        .builder( "h" ).longOpt( "db-host" )
        .argName( "hostname" ).hasArg()
        .desc( "database connection host or IP address" )
        .required()
        .build();

    private Option db_port_opt = Option
        .builder( "p" ).longOpt( "db-port" )
        .argName( "port_number" ).hasArg()
        .desc( "database connection port" )
        .required()
        .build();

    private Option db_sid_opt = Option
        .builder( "s" ).longOpt( "db-sid" )
        .argName( "sid" ).hasArg()
        .desc( "database connection SID" )
        .required()
        .build();

    private Option db_schema_opt = Option
        .builder( "q" ).longOpt( "db-schema" )
        .argName( "schema" ).hasArg()
        .desc( "catalog db schema" )
        .required()
        .build();

    private Option help_opt = Option
        .builder( "?" ).longOpt( "help" )
        .hasArg( false )
        .desc( "display this help text and exit" )
        .build();


    private Options options;
    private boolean parsed;


    //--------------------------------------------------------------------------
    // constructor
    //--------------------------------------------------------------------------
   
    public CatalogLoaderOptions() {
        this.options = new Options();
        this.options
            .addOption( info_src_opt )
            .addOption( input_opt     )
            .addOption( domain_opt    )
            .addOption( db_user_opt   )
            .addOption( db_pass_opt   )
            .addOption( db_host_opt   )
            .addOption( db_port_opt   )
            .addOption( db_sid_opt    )
            .addOption( db_schema_opt )
            .addOption( help_opt      );
    }


    //--------------------------------------------------------------------------
    // methods
    //--------------------------------------------------------------------------


    public CommandLine parse( String[] args ) throws ParseException {

        CommandLineParser parser = new DefaultParser();
        CommandLine       cmd    = parser.parse( this.options, args );
        return cmd;
    }

    
    private String getValue( CommandLine cmd, Option opt ) {

        String opt_name = opt.getOpt();
        if ( ! cmd.hasOption( opt_name ) ) {
            throw new IllegalStateException(
                    "cmd does not contain the option '"+opt_name+'\''
                    );
        }

        return cmd.getOptionValue( opt_name ).trim();
    }


    /**
     * Returns the ServiceInfoKind specified by <tt>-k/-info-kind</tt> option.
     * The option values are obtained from {@link ServiceInfoKind} names 
     * by lower casing them and replacing each underscore by an hyphen.
     * @throws IllegalArgumentException if {@link #parse} has not been invoked
     */
    public ServiceInfoKind infoKind( CommandLine cmd ) {
        String str_info_kind = getValue( cmd, this.info_src_opt )
                .toUpperCase()
                .replaceAll( "-", "_" );

        return Enum.valueOf( ServiceInfoKind.class, str_info_kind );
    }


    /**
     * Returns a new connection to an Oracle database.
     * The caller must close the connection.
     * @throws IllegalArgumentException if {@link #parse} has not been invoked
     */
    public Supplier<Connection> ojdbc6ConnectionSupplier( CommandLine cmd ) {
        return ojdbc6ConnectionSupplier( getValue( cmd, this.db_host_opt ),
                                         getValue( cmd, this.db_port_opt ),
                                         getValue( cmd, this.db_sid_opt  ),
                                         getValue( cmd, this.db_user_opt ),
                                         getValue( cmd, this.db_pass_opt ) 
                                         );
    }


    /**
     * Returns the URL specified by the <tt>-i/-input</tt> option.
     * @throws IllegalArgumentException if {@link #parse} has not been invoked
     */
    public URL inputPath( CommandLine cmd ) {
        return inputPath( getValue( cmd, this.input_opt ) );
    }


    /**
     * Returns the database schema the catalog belongs to.
     * @throws IllegalArgumentException if {@link #parse} has not been invoked
     */
    public String catalogSchema( CommandLine cmd ) {
        return getValue( cmd, this.db_schema_opt );
    }


    /**
     * Prints a help message.
     * There is no need to parse first.
     */
    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "java "+CatalogLoader.class.getName(),
                             HELP_HEADER,
                             this.options,
                             HELP_FOOTER
                             );
    }
}
