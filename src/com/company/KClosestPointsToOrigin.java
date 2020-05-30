package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        double[] count = new double[points.length];
        HashMap<Double, ArrayList<int[]>> mp = new HashMap<>();

        for(int i=0; i<points.length;i++){
            count[i] = Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            if(mp.containsKey(count[i])){
                mp.get(count[i]).add(points[i]);
            }else{
                ArrayList<int[]> ls = new ArrayList<>();
                ls.add(points[i]);
                mp.put(count[i],ls);
            }
        }

        Arrays.sort(count);

        int[][] res = new int[K][];

        int i = 0;
        for(int k=0;k<K;k++){
            Iterator<int[]> iterator = mp.get(count[i]).listIterator();
            while(iterator.hasNext()){
                res[k] = iterator.next();
                k++;
                if(k==K) return res;
            }
            i++;
            k--;
        }

        return res;
    }

    public int[][] kClosest2(int[][] points, int K) {

        int len = points.length;
        int left = 0;
        int right = len - 1;

        while(left <= right){
            int partitionIndex = partition(points,left,right);
            if(partitionIndex == K){
                break;
            }
            if(partitionIndex < K){
                left = partitionIndex + 1;
            }else{
                right = partitionIndex - 1;
            }
        }

        return Arrays.copyOfRange(points,0,K);
    }

    public int partition(int[][] points,int left,int right){
        int[] pivot = points[left];

        while(left < right){
            while(left < right && compare(points[right],pivot) <= 0) right--;
            points[left] = points[right];
            while(left < right && compare(points[left],pivot) >= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;

        return left;
    }

    public int compare(int[] point1,int[] point2){
        return (point2[1] * point2[1] + point2[0] * point2[0]) - point1[1] * point1[1] - point1[0] * point1[0];
    }
}
