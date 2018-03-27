package cl.ybl.sandbox;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LogManager.getLogger( App.class );

    public static void main( String[] args )
    {
        logger.debug( "main: my first log message: Hello World!" );
        logger.trace( "main: args count : " + args.length );

        System.out.println( "Hello World!" );
    }
}
