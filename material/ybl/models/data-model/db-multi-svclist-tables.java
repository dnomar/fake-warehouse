package catalogo;

/*
 * File  : tables.java
 * Author: Yves Bossel - Everis
 * Source: 12-create-tables.sql
 * Source: 14-create-views.sql
 */


/**
 * VWS_GMD_SVCGRUPOSPORCLASEINFO
 *   Catalog list/search base view
 *   Joins URL paths by all info classes
 *
 * GMD_NEG_SVCDETALLE
 *   Main table that
 *   contains all URL paths
 *
 * VWS_GMD_SERVICIOSVLOPS
 *   Holds columns to be displayed in Catalog
 *   (most of for Taxonomia)
 * @opt commentname
 * @opt nodefillcolor yellow
 */
class comment {}


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
 * @depend CODI_TIPO "<FK>" CORR_ID GMD_NEG_TIPOVALORES
 */
class GMD_NEG_LISTAVALORES {
    /** @stereotype PK */
    NUMBER_10_0   CORR_ID;
    VARCHAR2_4    CODI_TIPO;
    VARCHAR2_1000 NOMB_LISTAVALORES;
}


/**
 * @stereotype table
 * @depend CORR_ID "<PENDING FK>" CORR_ID GMD_NEG_SERVICIO
 */
class GMD_NEG_OPERACION {
    /** @stereotype PK */
    NUMBER_10_0   CORR_ID;
    VARCHAR2_1000 NOMB_OPERACION;
    NUMBER_10_0_NOT_NULL   CODI_SERVICIOID;    // NOT NULL ENABLE;
    VARCHAR2_4000 VLOR_ENTRADAS;
    VARCHAR2_4000 VLOR_SALIDAS;
    VARCHAR2_1000 DESC_OPERACION;
}


/**
 * @stereotype table
 */
class GMD_NEG_SERVICIO {
    /** @stereotype PK */
    NUMBER_10_0   CORR_ID;
    VARCHAR2_1000 DESC_OBJETIVO;
    VARCHAR2_1000 DESC_CAPACIDADRESP;            // TPS, consumo diario
    VARCHAR2_1000 DESC_OBSERVACIONES;
    VARCHAR2_1000 NOMB_TECNICO;                  // parece ser ult. segmento de ULR path
    VARCHAR2_1000 NOMB_DESCRIPTIVO;
    DATE          FECH_SOLICITUDCATEGORIZACION;
    DATE          FECH_CATEGORIZACION;
    VARCHAR2_1000 DESC_OBSINTEGRACION;
    VARCHAR2_1000 DESC_TARGETNAMESPACE;          // XML namespace
    VARCHAR2_1000 DESC_CONTEXTROOT;              // parecido a DESC_URIPROXYSERVICE, no igual
    VARCHAR2_1000 DESC_CARPETAOSB;
    NUMBER_10_0   VLOR_TIEMPORESPUESTA;
    VARCHAR2_1000 ESTD_CICLO;
    VARCHAR2_1000 DESC_URIPROXYSERVICE;
    VARCHAR2_1000 DESC_DOCUMENTACIONDISENO;
    VARCHAR2_1000 DESC_PLANILLAREQUERIMIENTO;
}


/**
 * @stereotype table
 */
class GMD_NEG_TIPOVALORES {
    /** @stereotype PK */
    VARCHAR2_4 CORR_ID;
    VARCHAR2_255 DESC_DESCRIPCION;
}


/**
 * @stereotype table
 * @depend CODI_LISTAVID   "<FK>" CORR_ID  GMD_NEG_LISTAVALORES
 * @depend CODI_SERVICIOID "<FK>" CORR_ID  GMD_NEG_SERVICIO
 */
class GMD_REL_SERVICIOLISTAVALORES {
    NUMBER_10_0_NOT_NULL CODI_LISTAVID;      // NOT NULL ENABLE;
    NUMBER_10_0_NOT_NULL CODI_SERVICIOID;    // NOT NULL ENABLE;
    VARCHAR2_4_NOT_NULL  DESC_ROL;           // NOT NULL ENABLE 
}


//------------------------------------------------------------------------------
// Views
//------------------------------------------------------------------------------

/**
 * @stereotype "view"
 * @opt !types
 * @opt nodefillcolor lightyellow
 * @composed - - - GMD_NEG_OPERACION
 */
class VWS_GMD_OPERACIONES {
    Object CODI_SERVICIOID;
    Object OPERACIONES;
}


/**
 * @stereotype "view"
 * @opt !types
 * @opt nodefillcolor lightyellow
 * @composed - - - GMD_NEG_OPERACION
 */
class VWS_GMD_OPERACIONESSERVICIOSCL {
    Object CODI_SERVICIOID;
    Object OPERACIONES;
}


/**
 * @stereotype "view"
 * @opt !types
 * @opt nodefillcolor lightyellow
 * @composed - "<join>" - GMD_NEG_SERVICIO
 * @composed - "<join>" - VWS_GMD_VALORESSERVICIOSCL
 * @composed - "<join>" - VWS_GMD_OPERACIONESSERVICIOSCL
 * @composed - "<join>" - VWS_GMD_SVCGRUPOSPORCLASEINFO
 */
class VWS_GMD_SERVICIOSVLOPS {
    Object CORR_ID;
    Object DESC_OBJETIVO;
    Object DESC_CAPACIDADRESP;
    Object DESC_OBSERVACIONES;
    Object NOMB_TECNICO;
    Object NOMB_DESCRIPTIVO;
    Object FECH_SOLICITUDCATEGORIZACION;
    Object FECH_CATEGORIZACION;
    Object DESC_OBSINTEGRACION;
    Object DESC_TARGETNAMESPACE;
    Object DESC_CONTEXTROOT;
    Object DESC_CARPETAOSB;
    Object VLOR_TIEMPORESPUESTA;
    Object ESTD_CICLO;
    Object DESC_URIPROXYSERVICE;
    Object DESC_DOCUMENTACIONDISENO;
    Object DESC_PLANILLAREQUERIMIENTO;
    Object VALORES;
    Object OPERACIONES;

    Object NOMB_SVCURLPATH;
    Object DESC_SVCGRUPONODOSOSBS;
    Object DESC_SVCGRUPONODOSHITS;
    Object DESC_SVCGRUPONODOSTAXON;
}


/**
 * @stereotype "view"
 * @opt !types
 * @opt nodefillcolor lightyellow
 * @composed - "<join>" - GMD_REL_SERVICIOLISTAVALORES
 * @composed - "<join>" - GMD_NEG_LISTAVALORES
 */
class VWS_GMD_VALORESSERVICIOS {
  Object CODI_SERVICIOID;
  Object VALORES;
}
    

/**
 * @stereotype "view"
 * @opt !types
 * @opt nodefillcolor lightyellow
 * @composed - "<join>" - GMD_REL_SERVICIOLISTAVALORES
 * @composed - "<join>" - GMD_NEG_LISTAVALORES
 */
class VWS_GMD_VALORESSERVICIOSCL {
  Object CODI_SERVICIOID;
  Object VALORES;
}
    

/**
 * @stereotype "view"
 * @opt !types
 * @opt nodefillcolor lightyellow
 * @composed - "<join>" - GMD_NEG_LSTINFO
 * @composed - "<join>" - GMD_NEG_SVCDETALLE
 */
class VWS_GMD_SVCGRUPOSPORCLASEINFO {
	Object NOMB_SVCURLPATH;
  	Object DESC_SVCGRUPONODOSOSBS; 
  	Object DESC_SVCGRUPONODOSHITS;
	Object DESC_SVCGRUPONODOSTAXON;
}


//------------------------------------------------------------------------------
// Tables (multi service list/source)
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
