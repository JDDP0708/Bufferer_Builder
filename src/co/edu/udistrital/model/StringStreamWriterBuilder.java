package co.edu.udistrital.model;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * @author Juan David Diaz Perez
 */
public class StringStreamWriterBuilder implements WriterBuilder {

    private final CustomWriterProduct product = new CustomWriterProduct();
    private ByteArrayOutputStream baos;
    private OutputStreamWriter osw;

    @Override
    public void buildBaseStream() {
        baos = new ByteArrayOutputStream();
        product.setOutputStream(baos);
    }

    @Override
    public void buildWriter() {
        osw = new OutputStreamWriter(baos);
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

    /**
     * Método exclusivo de este Builder para extraer los datos de la memoria
     * RAM.
     *
     * @return El texto escrito en el flujo.
     */
    public String getBuiltString() {
        if (baos != null) {
            return baos.toString();
        }
        return "";
    }
}
