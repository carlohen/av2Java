package q4_CarlosLuz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class multiplica {
    public static void main(String[] args) {
        int[][] matriz1 = readMatrix("D:\\code\\AV2_CarlosLuz\\src\\q4_CarlosLuz\\matriz1.txt");
        int[][] matriz2 = readMatrix("D:\\code\\AV2_CarlosLuz\\src\\q4_CarlosLuz\\matriz2.txt");

        if (matriz1 == null || matriz2 == null) {
            System.out.println("Erro na leitura das matrizes.");
            return;
        }

		int[][] result = multiplicaa(matriz1, matriz2);

        if (result == null) {
            System.out.println("As matrizes não podem ser multiplicadas.");
        } else {
            System.out.println("Resultado da multiplicação das matrizes:");
            printMatriz(result);
        }
    }

    // Ler a matriz a partir de um arquivo de texto
    @SuppressWarnings("resource")
	public static int[][] readMatrix(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int rows = 0;
            int cols = 0;
            while ((line = reader.readLine()) != null) {
                rows++;
                String[] values = line.split(" ");
                if (cols == 0) {
                    cols = values.length;
                }
            }
            reader.close();

            int[][] matriz = new int[rows][cols];
            reader = new BufferedReader(new FileReader(fileName));
            for (int i = 0; i < rows; i++) {
                line = reader.readLine();
                String[] values = line.split(" ");
                if (values.length != cols) {
                    System.out.println("O número de colunas não é consistente na matriz.");
                    return null;
                }
                for (int j = 0; j < cols; j++) {
                    matriz[i][j] = Integer.parseInt(values[j]);
                }
            }
            reader.close();
            return matriz;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Multiplica duas matrizes
    public static int[][] multiplicaa(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        if (colsA != matrixB.length) {
            return null; // Não podem ser multiplicadas
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // Imprime uma matriz
    public static void printMatriz(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

