package com.company;

/*
Day 8
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.
 */

/*
check if all other lines are on the line defined by the first line
Use cross product to check collinearity (always zero)

cross product=
[[ i,j,k ],
 [ a,b,c ],
 [ d,e,f ]]
 */
public class CheckIfItIsaStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int n= coordinates.length;
        if(n==2) return true;

        //first vector
        int[] a = coordinates[0];
        int[] b = coordinates[1];
        int[] v1 = {b[0]-a[0], b[1]-a[1]};

        //calculate all other vectors
        for(int i=2; i<n; i++){
            int[] c = coordinates[i];
            int[] v2 = {c[0]-b[0], c[1]-b[1]};
            int crossProduct = v1[0]*v2[1]-v1[1]*v2[0];
            if(crossProduct!=0) return false;
        }

        return true;
    }
}

