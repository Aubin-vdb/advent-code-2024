import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {

    public static final int matrixSize = 150;

    public static void main(String[] args) {

        char[][] matrix = getMatrix();

        long count1 = getCountPart1(matrix);
        System.out.println("XMAS part 1: " + count1);

        long count2 = getCountPart2(matrix);
        System.out.println("X-MAS part 2: " + count2);

    }

    public static char[][] getMatrix() {
        char[][] matrix = new char[matrixSize][matrixSize];
        String filePath = "/Users/aubin/Downloads/word_matrix.txt";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for(int j = 0; j < line.length(); j++) {
                    matrix[i][j] = line.charAt(j);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public static long getCountPart1(char[][] matrix) {
        long count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'X') {
                    if(testVerticallyUp(matrix, i, j)) count++;
                    if(testVerticallyDown(matrix, i, j)) count++;
                    if(testHorizontallyLeft(matrix, i, j)) count++;
                    if(testHorizontallyRight(matrix, i, j)) count++;
                    if(testDiagonallyDownLeft(matrix, i, j)) count++;
                    if(testDiagonallyDownRight(matrix, i, j)) count++;
                    if(testDiagonallyUpLeft(matrix, i, j)) count++;
                    if(testDiagonallyUpRight(matrix, i, j)) count++;
                }
            }
        }
        return count;
    }

    public static long getCountPart2(char[][] matrix) {
        long count = 0;
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (j >= 1 && i < matrix.length - 1 && matrix[i][j] == 'A') {
                    // M.M
                    // .A.
                    // S.S
                    if(matrix[i-1][j+1] == 'M' && matrix[i-1][j-1] == 'M' && matrix[i+1][j-1] == 'S' && matrix[i+1][j+1] == 'S') {
                        count++;
                    }

                    // S.S
                    // .A.
                    // M.M
                    if(matrix[i-1][j+1] == 'S' && matrix[i-1][j-1] == 'S' && matrix[i+1][j-1] == 'M' && matrix[i+1][j+1] == 'M') {
                        count++;
                    }

                    // M.S
                    // .A.
                    // M.S
                    if(matrix[i-1][j+1] == 'S' && matrix[i-1][j-1] == 'M' && matrix[i+1][j-1] == 'M' && matrix[i+1][j+1] == 'S') {
                        count++;
                    }

                    // S.M
                    // .A.
                    // S.M
                    if(matrix[i-1][j+1] == 'M' && matrix[i-1][j-1] == 'S' && matrix[i+1][j-1] == 'S' && matrix[i+1][j+1] == 'M') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean testVerticallyUp(char[][] matrix, int i, int j) {
        return (i-3 >= 0) && matrix[i-1][j] == 'M' && matrix[i-2][j] == 'A' && matrix[i-3][j] == 'S';
    }

    public static boolean testVerticallyDown(char[][] matrix, int i, int j) {
        return (i+3 < matrix.length) && matrix[i+1][j] == 'M' && matrix[i+2][j] == 'A' && matrix[i+3][j] == 'S';
    }

    public static boolean testHorizontallyLeft(char[][] matrix, int i, int j) {
        return (j-3 >= 0) && matrix[i][j-1] == 'M' && matrix[i][j-2] == 'A' && matrix[i][j-3] == 'S';
    }

    public static boolean testHorizontallyRight(char[][] matrix, int i, int j) {
        return (j+3 < matrix.length) && matrix[i][j+1] == 'M' && matrix[i][j+2] == 'A' && matrix[i][j+3] == 'S';
    }

    public static boolean testDiagonallyUpRight(char[][] matrix, int i, int j) {
        return (i-3 >= 0) && (j+3 < matrix.length) && matrix[i-1][j+1] == 'M' && matrix[i-2][j+2] == 'A' && matrix[i-3][j+3] == 'S';
    }

    public static boolean testDiagonallyUpLeft(char[][] matrix, int i, int j) {
        return (i-3 >= 0) && (j-3 >= 0) && matrix[i-1][j-1] == 'M' && matrix[i-2][j-2] == 'A' && matrix[i-3][j-3] == 'S';
    }

    public static boolean testDiagonallyDownRight(char[][] matrix, int i, int j) {
        return (i+3 < matrix.length) && (j+3 < matrix.length) && matrix[i+1][j+1] == 'M' && matrix[i+2][j+2] == 'A' && matrix[i+3][j+3] == 'S';
    }

    public static boolean testDiagonallyDownLeft(char[][] matrix, int i, int j) {
        return (i+3 < matrix.length) && (j-3 >= 0) && matrix[i+1][j-1] == 'M' && matrix[i+2][j-2] == 'A' && matrix[i+3][j-3] == 'S';
    }
}