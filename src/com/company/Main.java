package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] A = {{0,12},{15,26}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] res = IntervalListIntersections.intervalIntersection(A,B);
        print2DArray(res);
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