package cl.emagina.curso.fakewarehouse.core;

/*
* Permite exportar el Dictionary
*/
public interface DictionaryHandler {
    void dictionaryStart();
    void takeSku(String sku);
    void takeSkuDesc(String desc);
    void dictionaryEnd();
}

