package co.edu.udistrital.model;

/**
 * @author Juan David Diaz Perez
 */
public class IODirector {

    public CustomReaderProduct constructReader(ReaderBuilder builder) throws Exception {
        builder.buildBaseStream();
        builder.buildReader();
        builder.buildBuffer();
        return builder.getResult();
    }

    public CustomWriterProduct constructWriter(WriterBuilder builder) throws Exception {
        builder.buildBaseStream();
        builder.buildWriter();
        builder.buildBuffer();
        return builder.getResult();
    }
}
