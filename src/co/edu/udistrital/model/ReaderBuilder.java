package co.edu.udistrital.model;

/**
 * @author Juan David Diaz Perez
 */
public interface ReaderBuilder {

    void buildBaseStream() throws Exception;

    void buildReader() throws Exception;

    void buildBuffer() throws Exception;

    CustomReaderProduct getResult();
}
