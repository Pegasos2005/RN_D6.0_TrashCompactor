package software.RN.org.service;

import software.RN.org.io.Reader;
import software.RN.org.model.Grid;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GridParser {

    public static Grid createGrid(Path path) throws IOException {
        List<String> linesFile = Reader.readAsGrid(path);

        // Se crea la lista con los operadores ['*', '*', '+', ...]
        String lastLine = linesFile.get(linesFile.size() - 1);
        List<Character> operators = filterOperations(lastLine);

        // Se crea la lista con números vacía [[], [], [], [], ...]
        int numCols = operators.size();
        List<List<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < numCols; i++) columns.add(new ArrayList<>());

        // Se rellenan en forma de columna [[49, 83, 16, 83], [x, x, x, x], [x, x, x, x], [...], ...]
        for (int i = 0; i < linesFile.size() - 1; i++) {
            String[] parts = linesFile.get(i).trim().split("\\s+");
            for (int col = 0; col < parts.length; col++) {
                columns.get(col).add(Integer.valueOf(parts[col]));
            }
        }

        return new Grid(columns, operators);
    }

    // Elimina los espacios extras en blanco y convierta la última línea en un array de Characs
    private static List<Character> filterOperations(String lastLine) {
        return Arrays.stream(lastLine.trim().split("\\s+"))
                .map(s -> s.charAt(0))     // Tomamos el primer carácter del String "L"
                .toList();
    }
}