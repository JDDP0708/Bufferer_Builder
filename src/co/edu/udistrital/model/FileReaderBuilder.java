package co.edu.udistrital.model;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * @author Juan David Diaz Perez
 */
public class FileReaderBuilder implements ReaderBuilder {

    private final CustomReaderProduct product = new CustomReaderProduct();
    private final String filePath;
    private FileInputStream fis;
    private InputStreamReader isr;

    public FileReaderBuilder(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void buildBaseStream() throws Exception {
        fis = new FileInputStream(filePath);
        product.setInputStream(fis);
    }

    @Override
    public void buildReader() {
        isr = new InputStreamReader(fis);
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
