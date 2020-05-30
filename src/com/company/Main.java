package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        print2DArray(new KClosestPointsToOrigin().kClosest(points,3));
    }

    private static void print2DArray(int[][] res) {
        System.out.println();
        for(int[] gap: res){
            System.out.print("["+gap[0]+","+gap[1]+"]");
        }
        System.out.println();
    }

    private static void printArray(int[] z){
        for(Integer i: z){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}