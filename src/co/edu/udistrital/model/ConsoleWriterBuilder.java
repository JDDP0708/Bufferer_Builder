package co.edu.udistrital.model;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * @author Juan David Diaz Perez
 */
public class ConsoleWriterBuilder implements WriterBuilder {

    private final CustomWriterProduct product = new CustomWriterProduct();
    private OutputStreamWriter osw;

    @Override
    public void buildBaseStream() {
        product.setOutputStream(System.out);
    }

    @Override
    public void buildWriter() {
        osw = new OutputStreamWriter(System.out);
        product.setWriter(osw);
    }

    @Override
    public void buildBuffer() {
        product.setBufferedWriter(new BufferedWriter(osw));
    }

    @Override
    public CustomWriterProduct getResult() {
        return product;
    }
}
