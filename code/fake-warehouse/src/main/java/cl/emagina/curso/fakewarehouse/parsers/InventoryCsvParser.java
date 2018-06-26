package cl.emagina.curso.fakewarehouse.parsers;

import cl.emagina.curso.fakewarehouse.core.InventoryHandler;
import java.io.Reader;


/**
 * Parses a inventory CSV into a
 * {@link cl.justcodeit.warehouse.core.InventoryHandler InventoryHandler}
 * <p></p>
 * <b>Format</b>
 * <pre>{@code
#
# Header
#
Inventory, Date      , 2018-03-18
Inventory, Supervisor, John Smith
#
# Kind, Location, SKU, Unit, Qty
#
Item, A-3-4-1, 11-222-33, Each         ,  4
Item, A-3-4-2, 42-222-33, Each         , 30
Item, C-4-2-1, 42-222-33, Box (4 ct)   ,  5
Item, D-2-1-1, 75-323-44, Wrap (15 ct) ,  1
Item, D-2-3-1, 75-323-44, Each         , 45
 * }</pre>
 */
public class InventoryCsvParser {

    //--------------------------------------------------------------------------
    // constructors
    //--------------------------------------------------------------------------

    public InventoryCsvParser( Reader rdr ) {
        // si prefieres puedes cambiar el tipo de parametros
        throw new UnsupportedOperationException( "PENDING: implement me!" );
    }


    //--------------------------------------------------------------------------
    // methods
    //--------------------------------------------------------------------------

    /**
     * Parses the CSV associated to this parser into the specified <tt>dest</tt>.
     */
    public void exportTo( InventoryHandler dest ) {
        throw new UnsupportedOperationException( "PENDING: implement me!" );
    }
}
