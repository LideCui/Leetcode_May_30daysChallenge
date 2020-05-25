package com.company;

/*
This is the same as find the max sub sequence
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] tb = new int[B.length+1][A.length+1]; //extra row to initialize 0

        for(int i=0;i<B.length+1;i++){
            for(int j=0;j<A.length+1;j++){
                if(i==0||j==0) tb[i][j] = 0;
                else if(B[i-1]==A[j-1]){
                    tb[i][j] = tb[i-1][j-1]+1;
                }else{
                    tb[i][j] = Math.max(tb[i-1][j],tb[i][j-1]);
                }

            }
        }
        return tb[B.length][A.length];
    }

    private static void print2DArray(int[][] res) {
        System.out.println();
        for(int[] gap: res){
            for(int i: gap){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
