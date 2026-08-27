package co.edu.udistrital.model;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * @author Juan David Diaz Perez
 */
public class FileWriterBuilder implements WriterBuilder {

    private final CustomWriterProduct product = new CustomWriterProduct();
    private final String filePath;
    private FileOutputStream fos;
    private OutputStreamWriter osw;

    public FileWriterBuilder(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void buildBaseStream() throws Exception {
        fos = new FileOutputStream(filePath);
        product.setOutputStream(fos);
    }

    @Override
    public void buildWriter() {
        osw = new OutputStreamWriter(fos);
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
