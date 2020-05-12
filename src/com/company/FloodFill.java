package com.company;
/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
 */

/*
quite similar to the previous number of islands
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(image[sr][sc]!=newColor){
            paint(image,sr,sc,newColor,oldColor);
        }
        return image;
    }

    private void paint(int[][] image, int sr, int sc, int newColor,int oldColor){
        int m = image.length;
        int n = image[0].length;

        if(sr<0 || sr > m-1 || sc<0 || sc>n-1 || (image[sr][sc]!=oldColor)) return;

        image[sr][sc]=newColor;

        paint(image,sr-1,sc,newColor,oldColor); //up
        paint(image,sr+1,sc,newColor,oldColor);//down
        paint(image,sr,sc-1,newColor,oldColor);//left
        paint(image,sr,sc+1,newColor,oldColor);//right
    }
}
