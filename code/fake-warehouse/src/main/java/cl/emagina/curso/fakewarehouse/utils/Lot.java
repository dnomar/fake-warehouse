package cl.emagina.curso.fakewarehouse.utils;

/**
 * Implement this interface to handle a collection (a lot) of items.
 * This is a push style handler, i.e. the items producer invokes this interface
 * and the <tt>H</tt> (handler) instances in order to let the handler
 * (which implements this interface) handle the produced items.
 * H is a item handler, responsible to handle a single item.
 * <br><b>Example</b><br>
 * <pre>{@code
 * public interface RowHandler {
 *     void rowStart();
 *     void takeColumn1( String value );
 *     void takeColumn2( int value );
 *     // ...
 *     void rowEnd();
 * }
 *
 * public class SomeTable {
 *     // the row is inserted when rowEnd() is invoked.
 *     RowHandler insertOneRow() { ... }
 *
 *     // Here the invoker is a rows producer and the handler is SomeTable
 *     // When batch is true, the rows are inserted when lotEnd() is invoked,
 *     // otherwise rows are inserted one by one each time rowEnd() is invoked.
 *     Lot<RowHandler> insertMultipleRows( boolean batch ) { ... }
 *
 *     // Here the invoker is a rows handler and the producer is SomeTable
 *     void findByCol1( String col1_value, Lot<RowHandler> handler ) { ... }
 * }
 * }</pre>
 *
 * @author Yves Bossel
 */
public interface Lot<H> {
    /**
     * Notifies the handler to prepare itself to start consuming a lot of items;
     * this handler in turn supplies a handler of type H 
     * which will handle H type items one by one.
     * The producer invokes lotStart and the H instances to pass the produced
     * information.
     */
    H lotStart();

    /**
     * Notifies the end of the lot.
     */
    void lotEnd();
}
