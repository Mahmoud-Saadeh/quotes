package quotes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileToString implements FilesToString{
    private String stringFile;

    @Override
    public void readFile(String path) throws IOException {
        Path fileName = FileSystems.getDefault().getPath(path);

        stringFile = Files.readString(fileName);
    }

    public String getStringFile() {
        return stringFile;
    }
}
