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
 * @depend - - - csv_file
 */
class URL {}


/**
 * OSB Proxy Svc list
 * @opt commentname
 * @opt nodefillcolor lightyellow
 * @stereotype CSV
 */
class csv_file {}


/**
 * @stereotype enum
 */
class ServiceInfoKind {}


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
 * @has - - inputPath URL
 * @has - <feeds> - CatalogConsumer
 * @depend - <parse> - csv_file
 */
class OsbProxyServicesCsvParser implements Runnable {}


/**
 * @opt nodefillcolor wheat
 * @composed - - - ServiceConsumer
 */
interface CatalogConsumer {}

/**
 * @opt nodefillcolor wheat
 */
interface ServiceConsumer {}

/**
 * @opt nodefillcolor wheat
 */
interface OsbProxyServiceConsumer extends ServiceConsumer {}


/**
 * @has - - - GmdNegImportaTable
 * @has - - - ProcLoadGmdNegSvcDetalleSP
 * @depend - <feeds> - imp_row_cons 
 */
class BasicServiceInfoImporter implements CatalogConsumer, OsbProxyServiceConsumer {}


//------------------------------------------------------------------------------


/**
 * @opt nodefillcolor lightgray
 * @depend - <instantiates> - PreparedStatement
 * @depend - <instantiates> - CallableStatement
 */
class Connection {}

/**
 * @has - - - Connection
 * @has - - - ServiceInfoKind
 * @depend - <instantiates> - anon_imp_row_cons
 */
class GmdNegImportaTable {} 


/**
 * GmdNegImportaTable
 *   LotConsumer<RowConsumer>
 * @opt commentname
 * @opt nodefillcolor wheat
 */
interface imp_row_cons {}

/**
 * 
 * @opt commentname
 * @stereotype anon
 * @composed - - - PreparedStatement
 */
class anon_imp_row_cons implements imp_row_cons {}

/**
 * @note Also fills GMD_NEG_SVCOSB
 * when GMD_NEG_IMPORTA contains
 * OSB-specific data in
 * DESC_EXTRAPROYECTOOSB
 * @has - - - Connection
 * @depend - - sp CallableStatement
 */
class ProcLoadGmdNegSvcDetalleSP {} 


/**
 * @opt nodefillcolor lightgray
 * @depend - - - CatalogDB
 */
class PreparedStatement {}


/**
 * @opt nodefillcolor lightgray
 * @depend - - - CatalogDB
 */
class CallableStatement {}


/**
 * @stereotype DB
 * @opt attributes
 * @opt nodefillcolor lightblue
 */
class CatalogDB {
    Object GMD_NEG_IMPORTA;
    Object GMD_NEG_SVCDETALLE;
    Object GMD_NEG_SVCOSB;
    Object GMD_NEG_LISTADOSERVICIOS;
    Object GMD_NEG_GRUPONODOS;
    Object GMD_NEG_URLPATH;
    Object GMD_NEG_CLASEINFO;
    Object PRO_NEG_DEIMPORTAHACIADETALLE;
}
