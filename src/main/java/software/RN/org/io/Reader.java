package software.RN.org.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Reader {
    public static List<String> readAsGrid(Path path) throws IOException {
        // Abrimos el recurso dentro de un try-with-resources para asegurar el cierre del archivo
        try (Stream<String> lines = Files.lines(path)) {
            return lines.toList(); // En Java 16+ se usa .toList(), antes era .collect(Collectors.toList())
        }
    }
}