package co.edu.udistrital.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Juan David Diaz Perez
 */
public class CustomReaderProduct {

    private InputStream inputStream;
    private InputStreamReader reader;
    private BufferedReader bufferedReader;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setReader(InputStreamReader reader) {
        this.reader = reader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int checkAvailableBytes() throws IOException {
        return inputStream.available();
    }

    public String getEncodingType() {
        return reader.getEncoding();
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void closeStream() throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }
}
