/**
 * CatalogLoader 
 *   main(String[] args)
 * @opt commentname
 * @opt nodefillcolor yellow
 * @composed - - "user args" user_args
 * @depend - "<instantiates,\nfeeds options>" deps PicoContainer
 * @depend - "<instantiates>" - AppComposer
 * @depend - "<instantiates>" - CatalogLoaderOptions
 * @depend - "<run>" - Runnable
 */
class CatalogLoader {
    public static void main (String[] args) {}
}


/**
 * --info-kind   <string>
 * --input       <path>
 * --db-host     <ip>
 * --db-port     <int>
 * --db-sid      <string>
 * --db-username <string>
 * --db-password <string>
 * @opt commentname
 * @opt nodefillcolor bisque
 */
class user_args {}


/**
 * @depend - <parse> - user_args
 * @depend - <instantiates> inputPath URL
 * @depend - <instantiates> infoKind  ServiceInfoKind
 * @depend - <instantiates> connSupplier Connection_Supplier
 */
class CatalogLoaderOptions {}


/**
 * @opt nodefillcolor lightgray
 */
class URL {}


/**
 * @stereotype enum
 */
class ServiceInfoKind {}


/**
 * Map<ServiceInfoKind,
 *      Runnable>
 * @opt commentname
 * @stereotype ComponentAdapter
 * @depend - <resolves> - Runnable
 */
class anon_adapter{}


/**
 * Supplier<Connection>
 * @opt commentname
 * @opt nodefillcolor lightgray
 */
class Connection_Supplier {}


/**
 * @opt nodefillcolor lightgray
 * @has - - - CatalogLoaderOptions
 * @has - - - anon_adapter
 */
class PicoContainer {}


/**
 * @depend - "<feed>" - PicoContainer
 * @depend - "<instantiates>" - anon_adapter
 */
class AppComposer {}

/**
 * @opt nodefillcolor lightgray
 */
interface Runnable {}
