package software.RN.org.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {
    public static List<String> readAsGrid(Path path) throws IOException {
        // Lee todas las líneas y se las pasa al Grid crudo
        return Files.readAllLines(path);
    }
}