package co.edu.udistrital;

import co.edu.udistrital.model.FileReaderBuilder;
import co.edu.udistrital.model.StringStreamWriterBuilder;

/**
 * @author Juan David Diaz Perez
 */
public class AppMain {

    public static void main(String[] args) {
        Client client = new Client();

        client.send("=== PRUEBA 3: Archivo a StringStream ===");

        FileReaderBuilder readerBuilder = new FileReaderBuilder("entrada_prueba.txt");
        StringStreamWriterBuilder writerBuilder = new StringStreamWriterBuilder();

        client.executeCrossTest(readerBuilder, writerBuilder);

        String resultadoMemoria = writerBuilder.getBuiltString();

        client.send("\n--- LECTURA FINAL DESDE LA MEMORIA ---");
        client.send("Texto recuperado del builder: \n" + resultadoMemoria);
    }
}
