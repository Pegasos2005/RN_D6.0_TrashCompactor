package software.RN.org.service;

import software.RN.org.model.Grid;

import java.util.List;

public class Calculator {
    public static long solve(Grid grid) {
        long sum = 0;
        for (int i = 0; i < grid.getWidth(); i++) {
            sum += solveCol(grid.getCol(i), grid.getOperator(i));
        }
        return sum;
    }

    public static long solveCol(List<Integer> col, char oper) {
        long result = col.getFirst();
        for (int i = 1; i < col.size(); i++) {
            if (oper == '*') result *= col.get(i);
            else if (oper == '+') result += col.get(i);
            // else if (oper == '/' || oper == '-')...
        }
        return result;
    }
}