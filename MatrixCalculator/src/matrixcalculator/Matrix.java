package matrixcalculator;

public class Matrix {
    
    GetInput g = new GetInput();
    
    //input matrix
    public int[][] getMatrix(int matrix_n) {
        int[][] inputMatrix = null;
        //user input matrix's row
        System.out.print("Enter Row Matrix " + matrix_n + ":");
        int row = g.getMatrixSize();
        //user input matrix's column
        System.out.print("Enter Column Matrix " + matrix_n + ":");
        int column = g.getMatrixSize();
        inputMatrix = new int[row][column];
        //iterate over rows of input matrix
        for (int i = 0; i < row; i++) {
            //iterate over columns of input matrix
            for (int j = 0; j < column; j++) {
                inputMatrix[i][j] = g.getMatrixElement(i + 1, j + 1, matrix_n);
            }
        }
        return inputMatrix;
    }

    //print matrix
    public void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        //iterate over rows of input matrix
        for (int i = 0; i < row; i++) {
            //iterate over columns of input matrix
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }

    }
}
