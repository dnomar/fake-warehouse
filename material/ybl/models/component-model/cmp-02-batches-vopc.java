/**
 * extract-and-load.sh
 * @opt commentname
 * @stereotype Bash
 * @depend - <source> - params_sh
 * @depend - - - extract_esearch_sh
 * @depend - - - extract_osb_sh
 * @depend - - - load_catalog_sh
 */
class main_sh {}


/**
 * sample-params.sh
 *  - Elasticsearch cred
 *  - OSB clusters creds
 *  - local OSB path
 *  - data dir
 *  - logs dir
 * @opt commentname
 */
class params_sh {}


/**
 * extract-svclist-from
 *   -access-logs-in-elasticsearch.sh
 * @opt commentname
 * @stereotype Bash
 * @depend - - - esearch_server
 * @depend - <enrich> - esearch_result_json
 */
class extract_esearch_sh {}


/**
 * url_virtual-by-domain_rq.json
 * @opt commentname
 * @stereotype "Elasticsearch query"
 */
class esearch_query {}


/**
 * URL Path x Domain
 * @opt commentname
 * @stereotype "JSON"
 * @opt nodefillcolor lightyellow
 */
class esearch_result_json {}


/**
 * Elasticsearch Server
 * @opt commentname
 * @stereotype Server
 * @opt nodefillcolor lightblue
 * @depend - <write> - esearch_result_json
 * @depend - - - esearch_query
 */
class esearch_server {}


/**
 * extract-svclist-from
 *   -osb-proxy-services-in-osb-domain.sh
 * @opt commentname
 * @stereotype Bash
 * @depend - - - wlst_list_osb
 */
class extract_osb_sh {}


/**
 * osb-list-proxy-svc-uris.py
 * @opt commentname
 * @stereotype "WLST Python script"
 * @depend - - - osb_server_local
 * @depend - <query> "0..N" osb_server
 * @depend - <write> "0..N" svclist_osb
 */
class wlst_list_osb {}

/**
 * OSB proxy service list
 * @opt commentname
 * @opt nodefillcolor lightyellow
 * @stereotype CSV
 */
class svclist_osb {}


/**
 * OSB Server
 * @opt commentname
 * @stereotype Server
 * @opt nodefillcolor lightblue
 */
class osb_server {}


/**
 * Local OSB Server
 *   - libraries
 *   - setWLSenv
 *   - harvester/setenv.sh
 * @opt commentname
 * @opt nodefillcolor lightgray
 */
class osb_server_local {}

/**
 * load-catalog-from-extracted-files.sh
 * @opt commentname
 * @stereotype Bash
 * @depend - - - catalog_loader_jar
 */
class load_catalog_sh {}


/**
 * gobmw-cat-batches-1.0-SNAPSHOT.jar
 * @opt commentname
 * @stereotype "JAR"
 * @depend - <insert> - catalog_db
 * @depend - <read> - svclist_osb
 * @depend - <read> - esearch_result_json
 */
class catalog_loader_jar {}


/**
 * Catalog Tables
 * @opt commentname
 * @opt nodefillcolor lightblue
 * @stereotype "RDBMS Server"
 */
class catalog_db {}
