/**
 * java.io.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class java_io_ {}
/**
 * java.sql.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class java_sql_ {}
/**
 * javax.naming.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class javax_naming_ {}
/**
 * javax.persistence.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class javax_persistence_ {}
/**
 * javax.sql.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class javax_sql_ {}
/**
 * org.apache.poi.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class org_apache_poi_ {}
/**
 * org.codehaus.jackson.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class org_codehaus_jackson_ {}
/**
 * org.hibernate.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class org_hibernate_ {}
/**
 * org.springframework.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class org_springframework_ {}
/**
 * commonj.work.*
 * @opt commentname
 * @opt nodefillcolor lightgray
 * @opt shape package
 */
class commonj_work_ {}


/**
 * com.everis.soa.entity
 * @opt commentname
 * @opt shape package
 * @depend - - - com_everis_soa_service
 * @depend - - - commonj_work_
 * @depend - - - java_sql_
 * @depend - - - javax_naming_
 * @depend - - - org_springframework_
 */
class com_everis_soa_entity {}
// * @depend - - - java_io_

/**
 * com.everis.soa.controller
 * @opt commentname
 * @opt shape package
 * @depend - - - java_sql_
 * @depend - - - javax_persistence_
 * @depend - - - org_apache_poi_
 * @depend - - - org_codehaus_jackson_
 * @depend - - - org_hibernate_
 */
class com_everis_soa_controller {}
// * @depend - - - java_io_

/**
 * com.everis.soa.service
 * @opt commentname
 * @opt shape package
 * @depend - - - com_everis_soa_entity
 * @depend - - - com_everis_soa_util
 * @depend - - - commonj_work_
 * @depend - - - java_io_
 * @depend - - - java_sql_
 * @depend - - - javax_naming_
 * @depend - - - javax_sql_
 * @depend - - - org_apache_poi_
 * @depend - - - org_codehaus_jackson_
 * @depend - - - org_hibernate_
 * @depend - - - org_springframework_
 */
class com_everis_soa_service {}
/**
 * com.everis.soa.util
 * @opt commentname
 * @opt shape package
 * @depend - - - com_everis_soa_entity
 * @depend - - - javax_persistence_
 */
class com_everis_soa_util {}
