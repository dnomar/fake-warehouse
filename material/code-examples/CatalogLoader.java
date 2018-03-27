package com.everis.soa.catalog.app;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.cli.CommandLine;
import org.apache.logging.log4j.Logger;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import static com.everis.soa.catalog.app.AppComposer.*;


/**
 * CatalogLoader provides the application's main.
 * Options are defined in {@link CatalogLoaderOptions}.
 */
public class CatalogLoader {

    //--------------------------------------------------------------------------
    // class variables
    //--------------------------------------------------------------------------

    private static final Logger logger = LogManager.getLogger( CatalogLoader.class );


    //--------------------------------------------------------------------------
    // main
    //--------------------------------------------------------------------------

    public static void main (String[] args) throws ParseException {

        Connection           conn     = null;
        CatalogLoader        loader   = null;
        CommandLine          cmd_line = null;
        CatalogLoaderOptions opts     = new CatalogLoaderOptions();
        try {
            cmd_line = opts.parse( args );

            conn = opts.ojdbc6ConnectionSupplier( cmd_line ).get();

            MutablePicoContainer deps = new DefaultPicoContainer();
            deps.addComponent( KEY_USER_OPTION_CONNECTION, conn                 );
            deps.addComponent( KEY_USER_OPTION_SCHEMA    , opts.catalogSchema( cmd_line ) );
            deps.addComponent( KEY_USER_OPTION_INPUTPATH , opts.inputPath( cmd_line )     );
            deps.addComponent( opts.infoKind( cmd_line ) );

            (new AppComposer()).composeApplication( deps );
                               
            Runnable command = deps.getComponent( Runnable.class );
            command.run();
        }
        catch ( ParseException exp ) {
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
            opts.printHelp();
            logger.error( "main caught", exp );
            throw exp;
        }
        catch ( RuntimeException e ) {
            System.err.println( e.getMessage() );
            logger.error( "main caught", e );
            throw e;
        }
        finally {
            if ( conn != null ) {
                try { conn.close(); }
                catch ( SQLException e ) { /* ok ignored */ }
            }
        }
    }
}
