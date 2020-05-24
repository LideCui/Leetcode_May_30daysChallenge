package com.company;

public class CountSquaresSubmatricesWithAllOnes {
    /*
    a copy of solution, sample solution, run in O(n^2)
     */
    public int countSquares(int[][] matrix) {

        int squares = 0;
        for(int i = 0; i < matrix.length; ++i)
            for(int j = 0; j < matrix[0].length; j++) {
                if(i != 0 && j != 0 && matrix[i][j] == 1)
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j])) + 1;
                squares += matrix[i][j];
            }

        return squares;
    }
}
