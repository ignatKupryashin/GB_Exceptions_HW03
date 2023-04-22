import java.io.*;

public class Writer {
    private File file;

    public Writer(String path) throws IOException {
        file = new File(path);
        file.createNewFile();
    }

    public void write(String data) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))){
            printWriter.println(data);
        }
    }

    public File getFile() {
        return file;
    }
}
