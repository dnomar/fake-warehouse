package cl.emagina.curso.fakewarehouse.parsers;

import cl.emagina.curso.fakewarehouse.core.ShipmentHandler;
import java.io.Reader;


/**
 * Parses a shipment CSV into a
 * {@link cl.justcodeit.warehouse.core.ShipmentHandler ShipmentHandler}
 * <p></p>
 * <b>Format</b>
 * <pre>{@code
#
# Header
#
Shipment, Dock Door, 5
Shipment, Dock Time, 2018-03-25 18:34
Shipment, In/Out   , Inbound
#
# Kind, SKU, Unit, Qty
#
Item, 11-222-33, Each         ,  4
Item, 42-222-33, Each         , 30
Item, 42-222-33, Box (4 ct)   ,  5
Item, 75-323-44, Wrap (15 ct) ,  1
Item, 75-323-44, Each         , 45
 * }</pre>
 */
public class ShipmentCsvParser {

    //--------------------------------------------------------------------------
    // constructors
    //--------------------------------------------------------------------------

    public ShipmentCsvParser( Reader rdr ) {
        // si prefieres puedes cambiar el tipo de parametros
        throw new UnsupportedOperationException( "PENDING: implement me!" );
    }


    //--------------------------------------------------------------------------
    // methods
    //--------------------------------------------------------------------------

    /**
     * Parses the CSV associated to this parser into the specified <tt>dest</tt>.
     */
    public void exportTo( ShipmentHandler dest ) {
        throw new UnsupportedOperationException( "PENDING: implement me!" );
    }
}
