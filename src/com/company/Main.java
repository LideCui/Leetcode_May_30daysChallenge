package com.company;

public class Main {

    public static void main(String[] args) {
        int[] A = {1,3,7,1,7,5};
        int[] B = {1,9,2,5,1};

        int[] C = {2,5,1,2,5};
        int[] D = {10,5,2,1,5,2};
        System.out.println(new UncrossedLines().maxUncrossedLines(C,D));
    }

    private static void print2DArray(int[][] res) {
        System.out.println();
        for(int[] gap: res){
            if(gap[0]==0&&gap[1]==0) break;
            System.out.print("["+gap[0]+"-"+gap[1]+"]");
        }
        System.out.println();
    }
}