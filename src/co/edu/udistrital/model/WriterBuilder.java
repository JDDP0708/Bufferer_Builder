package co.edu.udistrital.model;

/**
 * @author Juan David Diaz Perez
 */
public interface WriterBuilder {

    void buildBaseStream() throws Exception;

    void buildWriter() throws Exception;

    void buildBuffer() throws Exception;

    CustomWriterProduct getResult();
}
