package co.edu.udistrital.model;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * @author Juan David Diaz Perez
 */
public class StringStreamReaderBuilder implements ReaderBuilder {

    private final CustomReaderProduct product = new CustomReaderProduct();
    private final String data;
    private ByteArrayInputStream bais;
    private InputStreamReader isr;

    public StringStreamReaderBuilder(String data) {
        this.data = data;
    }

    @Override
    public void buildBaseStream() {
        bais = new ByteArrayInputStream(data.getBytes());
        product.setInputStream(bais);
    }

    @Override
    public void buildReader() {
        isr = new InputStreamReader(bais);
        product.setReader(isr);
    }

    @Override
    public void buildBuffer() {
        product.setBufferedReader(new BufferedReader(isr));
    }

    @Override
    public CustomReaderProduct getResult() {
        return product;
    }
}
