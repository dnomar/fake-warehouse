//  /**
//   * @composed - - - user_args
//   * @depend - "<instantiates,\nfeedss options>" deps PicoContainer
//   * @depend - "<instantiates>" - AppComposer
//   * @depend - "<instantiates>" - CatalogLoaderOptions
//   * @depend - "<run>" - Runnable
//   */
//  class main {}
//  
//  
//  /**
//   * user args
//   * @opt commentname
//   */
//  class user_args {}
//  
//  
//  /**
//   * @depend - <parse> - user_args
//   * @depend - <instantiates> inputPath URL
//   * @depend - <instantiates> infoKind  ServiceInfoKind
//   * @depend - <instantiates> connSupplier Connection_Supplier
//   */
//  class CatalogLoaderOptions {}


/**
 * @opt nodefillcolor lightgray
 * @depend - - - json_file
 */
class URL {}


/**
 * url_virtual-by-domain_rs.json
 * "...metadata": { ... }
 * "aggregations" : {
 *    "url_virtual_agg" : {
 *       "buckets" : [
 *         { "key": ...,
 *           "domain_agg": {
 *             "buckets": [
 *               {..}, .. , {..}
 *             ]
 *           }},
 *         ...
 *       ]}}
 *
 *
 * @opt commentname
 * @opt nodefillcolor lightyellow
 * @stereotype JSON
 */
class json_file {}


//  /**
//   * @depend - <instantiates> - OsbProxyServicesCsvParser
//   * @depend - <instantiates> - OsbProxyServiceInfoImporter
//   * @has - - - CatalogLoaderOptions
//   */
//  class PicoContainer {}


//  /**
//   * @depend - "<feeds>" - PicoContainer
//   */
//  class AppComposer {}

/**
 * @opt nodefillcolor lightgray
 */
interface Runnable {}


//------------------------------------------------------------------------------

/**
 * @depend - - - JsonReader
 * @has - - inputPath URL
 * @has - <feeds> - CatalogConsumer
 */
class ESUrlVirtualByDomainJsonParser implements Runnable {}


/**
 * @opt nodefillcolor wheat
 * @depend - - - ServiceConsumer
 */
interface CatalogConsumer {}

/**
 * @opt nodefillcolor wheat
 */
interface ServiceConsumer {}



/**
 */
class BasicServiceInfoImporter implements CatalogConsumer, ServiceConsumer {}
// ServiceConsumer is implemented by extension:
//class BasicServiceInfoImporter implements CatalogConsumer, OsbProxyServiceConsumer {}


/**
 * @opt nodefillcolor lightgray
 * @depend - <parse> - json_file
 */
class JsonReader {}
