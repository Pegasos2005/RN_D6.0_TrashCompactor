package software.RN.org;

import software.RN.org.model.Grid;
import software.RN.org.service.Calculator;
import software.RN.org.service.GridParser;

import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "input.txt");

    public static void main(String[] args) {
        try {
            // 1. IO: Leer el archivo y obtener el Grid crudo
            Grid grid = GridParser.createGrid(INPUT_PATH);

            System.out.println("--- RESULTADO CEFALÓPODO ---");
            System.out.println("Gran Total: " + Calculator.solve(grid));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}