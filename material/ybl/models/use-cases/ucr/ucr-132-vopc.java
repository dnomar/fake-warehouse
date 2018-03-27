/** @hidden */ class Param {}


/**
 * @stereotype "Server"
 * @opt nodefillcolor lightgray
 * @tagvalue "v." "11g+"
 */
class OSB {}


/**
 * @opt nodefillcolor khaki
 * @stereotype "Table"
 * @opt attributes
 */
class osb_proxy_svc_raw {
    String load_tstmp;
    String osb_adminurl;
    String osb_proxy_svc_uri;
}


/**
 * @opt nodefillcolor khaki
 * @stereotype "Stored Procedure"
 * @opt attributes
 * @depend - - - osb_proxy_svc_raw
 * @depend - "<update>" - osb_proxy_services
 */
class sp_update_osb_proxy_list {}


/**
 * @opt nodefillcolor khaki
 * @stereotype "Table"
 * @opt attributes
 */
class osb_proxy_services {}


/**
 * @opt nodefillcolor khaki
 * @stereotype "Table"
 * @opt attributes
 */
class osb_clusters {
    String osb_adminurl;
    String stats_automatic_update;
}


/**
 * osb-wlst
 * @opt commentname
 * @stereotype "Bash script"
 * @depend - - "local  " OSB
 * @depend - "<run>" - osb_list_services_uris_py
 */
class osb_wlst_sh {}


/**
 * osb-list-services-uris.py
 * @opt commentname
 * @opt attributes
 * @stereotype "WLST script"
 * @depend - - "N" OSB
 * @depend - "<append>" "1..N   " osb_proxy_svc_uris
 */
class osb_list_services_uris_py {
    Param osb_adminurl;
    Param osb_user;
    Param osb_pswd;
    Param service_type;
}


/**
 * catalog-list-osb-clusters
 * @opt commentname
 * @opt attributes
 * @stereotype "PL/SQL"
 * @depend - "<write>" - osb_list
 * @depend - "<read>" - osb_clusters
 */
class catalog_list_osb_clusters_sql {
    Param orcl_url;
    Param orcl_user;
    Param orcl_pswd;
}


/**
 * catalog-update-proxy-uris
 * @opt commentname
 * @opt attributes
 * @stereotype "PL/SQL"
 * @depend - "<read>" - osb_proxy_svc_uris
 * @depend - "<call>" - sp_update_osb_proxy_list
 * @depend - "<write>" - osb_proxy_svc_raw
 */
class catalog_upd_proxy_uris_sql {
    Param orcl_url;
    Param orcl_user;
    Param orcl_pswd;
    Param dir;
    Param file;
}


/**
 * batch-refresh-catalog-proxy-uris
 * @opt commentname
 * @opt attributes
 * @stereotype "Bash script"
 * @composed - - - prepare
 * @depend - "<update>" - catalog_upd_proxy_uris_sql
 * @depend - "<extract>" - osb_wlst_sh
 * @depend - "<read>" - osb_list
 */
class batch_refresh_catalog_proxy_uris_sh {
    String cred_file_name;
    String cred_file_pswd;
    String cred_key_orcl;
    String cred_key_osb;
    String dest_dir;
}


/**
 * @depend - - -  Credentials
 * @depend - - -  catalog_list_osb_clusters_sql
 */
class prepare {}



//-----------------------------------------------------------------------------


/**
 * @opt nodefillcolor lightyellow
 * @opt attributes
 * @stereotype "Encrypted CSV"
 */
class Credentials {
    String cred_key;
    String osb_adminurl;
    String user;
    String password;
}


/**
 * @opt nodefillcolor lightyellow
 * @opt attributes
 * @stereotype CSV
 */
class osb_list {
    String osb_adminurl;
}


/**
 * @opt nodefillcolor lightyellow
 * @opt attributes
 * @stereotype "CSV"
 */
class osb_proxy_svc_uris {
    Param osb_adminurl;
    Param proxy_svc_name;
    Param proxy_svc_uri;
}
