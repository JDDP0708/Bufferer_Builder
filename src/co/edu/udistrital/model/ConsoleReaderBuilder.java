package co.edu.udistrital.model;

import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * @author Juan David Diaz Perez
 */
public class ConsoleReaderBuilder implements ReaderBuilder {

    private final CustomReaderProduct product = new CustomReaderProduct();
    private InputStreamReader isr;

    @Override
    public void buildBaseStream() {
        product.setInputStream(System.in);
    }

    @Override
    public void buildReader() {
        isr = new InputStreamReader(System.in);
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
