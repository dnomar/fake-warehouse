package cl.emagina.curso.fakewarehouse;

/*
* Permite exportar el Dictionary
*/
public interface DictionaryHandler {
    void dictionaryStart();
    void takeSku(String sku);
    void takeSkuDesc(String desc);
    void dictionaryEnd();
}

