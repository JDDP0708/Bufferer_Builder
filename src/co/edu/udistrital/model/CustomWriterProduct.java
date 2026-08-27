package co.edu.udistrital.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author Juan David Diaz Perez
 */
public class CustomWriterProduct {

    private OutputStream outputStream;
    private OutputStreamWriter writer;
    private BufferedWriter bufferedWriter;

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setWriter(OutputStreamWriter writer) {
        this.writer = writer;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public void flushHardware() throws IOException {
        outputStream.flush();
    }

    public void writeSingleCharacter(int c) throws IOException {
        writer.write(c);
    }

    public void writeLine(String line) throws IOException {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void closeStream() throws IOException {
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
