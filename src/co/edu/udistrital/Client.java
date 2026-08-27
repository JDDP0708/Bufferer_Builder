package co.edu.udistrital;

import co.edu.udistrital.model.CustomReaderProduct;
import co.edu.udistrital.model.CustomWriterProduct;
import co.edu.udistrital.model.IODirector;
import co.edu.udistrital.model.ReaderBuilder;
import co.edu.udistrital.model.WriterBuilder;
import co.edu.udistrital.view.ShowConsole;

/**
 * @author Juan David Diaz Perez
 */
public class Client {

    private final IODirector director;
    private final ShowConsole showConsole;

    public Client() {
        this.director = new IODirector();
        this.showConsole = new ShowConsole();
    }

    public void send(String message) {
        showConsole.showInfo(message);
    }

    public void executeCrossTest(ReaderBuilder readerBuilder, WriterBuilder writerBuilder) {
        try {
            CustomReaderProduct reader = director.constructReader(readerBuilder);
            CustomWriterProduct writer = director.constructWriter(writerBuilder);

            send("--- INICIANDO PRUEBA CRUZADA ---");
            send("Bytes disponibles en Stream original: " + reader.checkAvailableBytes());
            send("Codificación detectada por Reader: " + reader.getEncodingType());

            String line = reader.readLine();
            send("\nEscribiendo un caracter individual (Writer):");
            writer.writeSingleCharacter('>');
            writer.flushHardware();

            send("\n\nTransfiriendo línea completa a través de Buffer:");
            writer.writeLine(" [Transferido] " + line);

            reader.closeStream();
            send("\n--- PRUEBA FINALIZADA CON ÉXITO ---");

        } catch (Exception e) {
            send("Error durante la ejecución: " + e.getMessage());
        }
    }
}
