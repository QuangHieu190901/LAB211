package matrixcalculator;

public class Calculator {
    
    public int[][] additionMatrix (int[][] matrix1, int[][]matrix2){
        int[][] result  = null;
        int row1 = matrix1.length;
        int row2 = matrix2.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        //can be added
        if(row1 == row2 && col1 == col2){
            result = new int[row1][col1];
            //iterate over rows of result matrix
            for (int i = 0; i < row1; i++) {
                //iterate over columns of result matrix
                for (int j = 0; j < col1; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        }        
        return result;
    }
    
    public int[][] subtractionMatrix (int[][] matrix1, int[][]matrix2){
        int row1 = matrix1.length;
        int row2 = matrix2.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int [][] result  = null;
        //can be subtract
        if(row1 == row2 && col1 == col2){
            result = new int[row1][col1];
            //iterate over rows of result matrix
            for (int i = 0; i < row1; i++) {
                //iterate over columns of result matrix
                for (int j = 0; j < col1; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }        
        return result;        
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][]matrix2){       
        int[][] result = null;
        int row1 = matrix1.length;
        int row2 = matrix2.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        //can be multiply
        if(col1 == row2){
            result = new int[row1][col2];
            //iterate over rows of the result matrix
            for (int i = 0; i < row1; i++) {
                //iterate over columns of the result matrix
                for (int j = 0; j < col2; j++) {
                    //assign each entry the product between row i of first matrix and column j of second matrix
                    for (int k = 0; k < col1; k++) {
                        result[i][j] += matrix1[i][k]*matrix2[k][j];
                    }
                }
            }
        }
        return result; 
    }
    
}
