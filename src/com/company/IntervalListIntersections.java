package com.company;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A[0]==null || B[0]==null) return new int[0][0] ;
        int aCount = 0;
        int bCount = 0;
        int[] aGap = A[aCount];
        int[] bGap = B[bCount];
        ArrayList<int[]> hold = new ArrayList<>(); // a list hold int[2]

        while(aGap!=null&&bGap!=null){
            int a = aGap[0]; int b = aGap[1];
            int c = bGap[0]; int d = bGap[1];

            while(b<c||d<a){
                if(b<c){
                    aCount++;
                    if(aCount<A.length) aGap = A[aCount]; else return make2DArray(hold); //no need to compare
                    a = aGap[0]; b = aGap[1];
                }else if(d<a){
                    bCount++;
                    if(bCount<B.length)bGap = B[bCount]; else return make2DArray(hold);
                    c = bGap[0]; d = bGap[1];
                }
            }

            int st = 0;
            int end = 0;
            if(a>c) st=a; else st=c;
            if(b>d) {
                end=d;
                bCount++;
                if(bCount<B.length) bGap = B[bCount]; else { //add last element
                    int[] resGap = {st,end};
                    hold.add(resGap);
                    return make2DArray(hold );
                }
            } else {
                end=b;
                aCount++;
                if(aCount<A.length) aGap = A[aCount]; else {
                    int[] resGap = {st,end};
                    hold.add(resGap);
                    return make2DArray(hold);
                }
            }
            int[] resGap = {st,end};
            hold.add(resGap);
        }
        return make2DArray(hold);
    }

    private static int[][] make2DArray(ArrayList<int[]> ls){
        int[][] res = new int[ls.size()][2];
        int count = 0;
        for(int[] gap: ls){
            res[count] = gap;
            count++;
        }
        return res;
    }

    // compare to sample solution, the thought process is basically correct
    // but the code must be refined even more
    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
