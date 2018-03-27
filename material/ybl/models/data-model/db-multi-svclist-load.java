package catalogo;

/*
 * File  : tables.java
 * Author: Yves Bossel - Everis
 * Source: 12-create-tables.sql
 * Source: 13-create-types.sql
 */


//------------------------------------------------------------------------------
// Dummy types to avoid errors
//------------------------------------------------------------------------------

/** @hidden */ interface DATE {}
/** @hidden */ interface INTEGER {}
/** @hidden */ interface TIMESTAMP {}
/** @hidden */ interface BOOL {}
/** @hidden */ interface NUMBER {}
/** @hidden */ interface NUMBER_10_0 {}
/** @hidden */ interface NUMBER_10_0_NOT_NULL {}
/** @hidden */ interface TIMESTAMP     {}
/** @hidden */ interface VARCHAR2_1023 {}
/** @hidden */ interface VARCHAR2_1000 {}
/** @hidden */ interface VARCHAR2_255  {}
/** @hidden */ interface VARCHAR2_63   {}
/** @hidden */ interface VARCHAR2_31   {}
/** @hidden */ interface VARCHAR2_4    {}
/** @hidden */ interface VARCHAR2_4000 {}
/** @hidden */ interface VARCHAR2_4_NOT_NULL {}
/** @hidden */ interface VARCHAR2_255_NOT_NULL  {}
/** @hidden */ interface Sequence {}
/** @hidden */ interface _columnas_ {}


//------------------------------------------------------------------------------
// Other sources
//------------------------------------------------------------------------------

/**
 * carga-catalogo.bas
 *
 *   - reads  TAXONOMIA_CONSOLIDADA.xslm
 *   - insert GMD_NEG_LISTAVALORES
 *   - insert GMD_REL_SERVICIOLISTAVALORES
 *   - insert GMD_NEG_TIPOVALORES
 * @opt commentname
 * @stereotype "Excel VBA Macro"
 * @opt nodefillcolor lightblue
 * @depend - <insert> - GMD_NEG_SERVICIO
 */
class taxonomy_loader_bas {}


/**
 * gobmw-cat-batches-1.1-SNAPSHOT.jar
 *
 *   - reads  osb_svclist.csv  (0..N)
 *   - reads  esearch_result.json
 * @opt commentname
 * @stereotype "Executable JAR"
 * @opt nodefillcolor lightblue
 * @depend - <insert> - GMD_TMP_IMPORTA
 */
class catalog_loader_jar {}


//------------------------------------------------------------------------------
// SP
//------------------------------------------------------------------------------

/**
 * PRO_NEG_TAXONOMIATOIMPORTA
 *
 *   IN: LSTFECHA   dflt CURRENT_TIMESTAMP
 *   IN: LSTURLPATH dflt'TAXONOMIA_CONSOLIDADA.xlsm'
 *   set VLOR_LSTCLASEINFO  'Taxonomina Arquitectura'
 *   set NOMB_LSTGRUPONODOS 'N/D'
 *   set NOMB_SVCGRUPONODOS 'N/D'
 * @opt commentname
 * @opt nodefillcolor lightsteelblue3
 * @stereotype "Stored Procedure"
 * @depend - <select> - GMD_NEG_SERVICIO
 * @depend - <insert> - GMD_TMP_IMPORTA
 */
class PRO_NEG_TAXONOMIATOIMPORTA {}


/**
 * @opt nodefillcolor lightsteelblue3
 * @stereotype "Stored Procedure"
 * @depend - <select> - GMD_TMP_IMPORTA
 * @depend - "<insert>" - GMD_NEG_SVCDETALLE
 * @depend - "<insert>" - GMD_LOG_MSG
 */
class PRO_NEG_IMPORTATOSVCDETALLE {}


//------------------------------------------------------------------------------
// Tables
//------------------------------------------------------------------------------

/**
 * @stereotype table
 * @opt attributes
 * @opt types
 * @hidden
 */
class UMLOptions {}


/**
 * @stereotype table
 */
class GMD_NEG_GRUPONODOS {
    VARCHAR2_63           NOMB_GRUPONODOS;      // PK
    VARCHAR2_255          DESC_DESCRIPTION;
}

/**
 * @stereotype table
 */
class GMD_NEG_URLPATH {
    VARCHAR2_1000         NOMB_URLPATH;      // PK
    VARCHAR2_255          DESC_DESCRIPTION;
}

/**
 * @stereotype table
 * @depend - "<FK>" - GMD_NEG_GRUPONODOS
 * @depend - "<FK>" - GMD_NEG_URLPATH
 */
class GMD_REL_SVCINFO {
    VARCHAR2_63           NOMB_GRUPONODOS;      // FK
    VARCHAR2_1000         NOMB_URLPATH;         // FK
}

/**
 * @stereotype table
 */
class GMD_NEG_CLASEINFO {
    VARCHAR2_31           VLOR_CLASEINFO;       // PK
    VARCHAR2_255          DESC_DESCRIPTION;
}

/**
 * @stereotype table
 * @depend - "<FK>" "1   " GMD_REL_SVCINFO
 * @depend - "<FK>" - GMD_NEG_CLASEINFO
 */
class GMD_NEG_LSTINFO {
    NUMBER_10_0_NOT_NULL  CORR_ID;              // PK
    TIMESTAMP             FECH_LISTA;         // 
    VARCHAR2_31           VLOR_LSTCLASEINFO;    // FK
    VARCHAR2_63           NOMB_LSTGRUPONODOS;   // FK
    VARCHAR2_1000         NOMB_LSTURLPATH;      // FK
}


/**
 * @depend - "<FK>" "1   "    GMD_NEG_LSTINFO
 * @depend - "<FK>" "0..N   " GMD_REL_SVCINFO
 */
class GMD_NEG_SVCDETALLE {
    NUMBER_10_0_NOT_NULL  CODI_LSTINFOID;       // FK
    VARCHAR2_63           NOMB_SVCGRUPONODOS;   // FK
    VARCHAR2_1000         NOMB_SVCURLPATH;      // FK
}


/**
 * @stereotype table
 * @tagvalue FECH_LSTLISTADO "Taxonomia Arquitectura"
 */
class GMD_NEG_SERVICIO {
    VARCHAR2_1000 NOMB_EXTRAPROYECTOOSB;
    VARCHAR2_1000 DESC_URIPROXYSERVICE;
    _columnas_    _otras_;
}


//------------------------------------------------------------------------------
// Import tables
//------------------------------------------------------------------------------


/**
 * @stereotype "temporary table"
 * @opt nodefillcolor lightsteelblue3
 * @tagvalue VLOR_LSTCLASEINFO "OSB Proxy Services or Access Logs"
 */
class GMD_TMP_IMPORTA {
    TIMESTAMP       FECH_LSTLISTADO;
    VARCHAR2_31     VLOR_LSTCLASEINFO;

    VARCHAR2_63     NOMB_LSTGRUPONODOS;
    VARCHAR2_1000   NOMB_LSTURLPATH;
    VARCHAR2_63     NOMB_SVCGRUPONODOS;
    VARCHAR2_1000   NOMB_SVCURLPATH;
       
    VARCHAR2_1000   DESC_EXTRAPROYECTOOSB;
    INTEGER         ESTD_IMPORTA;
}


/**
 * @opt attributes
 */
class GMD_LOG_MSG {
  TIMESTAMP       DESC_WHEN;       // DEFAULT CURRENT_TIMESTAMP
  VARCHAR2_255    DESC_MSG;        // not null
  VARCHAR2_31     VLOR_S31;        // default null
  VARCHAR2_255    VLOR_S255;       // default null
  VARCHAR2_1023   VLOR_S1023;      // default null
  INTEGER         VLOR_I;          // default null
  NUMBER_10_0     VLOR_N10;        // default null
  TIMESTAMP       VLOR_TSTMP;      // default null
  DATE            VLOR_DATE;       // default null
}
