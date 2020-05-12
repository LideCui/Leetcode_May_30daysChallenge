package com.company;

public class Main {

    public static void main(String[] args) {
        //int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates = {{1, 1, 1}, {1,1,0},{1,0,0}};
        System.out.println(new FloodFill().floodFill(coordinates,1,1,2));
    }
}