package com.company;
/*
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.
(Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j],
there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 */

/*
two cases:
1. if the max sub is in the middle use old Kadane's algorithm
2. if the max sub is circular,  <- len | 0 ->, then combine
 */
public class MaximumSumCircularSubarray {
//    public int maxSubarraySumCircular(int[] A) {
//
//        // Kadane's Algorithm
//        int max_in_middle = A[0];
//        int curr_max = A[0];
//        for (int i = 1; i < A.length; i++) {
//            curr_max = Math.max(A[i], curr_max+A[i]);
//            max_in_middle = Math.max(max_in_middle, curr_max);
//        }
//        System.out.println("max_in_middle:"+max_in_middle);
//
//        // find max sub in split across
//
//        int back = A[A.length-1];
//        int forth = A[0];
//
//        int max = back;
//        for(int j=A.length-2; j>A.length/2;j--){
//            max = Math.max(max, back+A[j]);
//            back += A[j];
//        }
//        back= max;
//
//        max = forth;
//        for(int i=1; i <= A.length/2;i++){
//            max = Math.max(max, forth+A[i]);
//            forth += A[i];
//        }
//        forth= max;
//
//
//        int max_in_cross = back+forth;
//        System.out.println("max_in_cross:"+max_in_cross+" back:"+back + " forth:"+forth);
//
//        return max_in_cross>max_in_middle?max_in_cross:max_in_middle;
//    }
//

    /*
    slow version of Kadane
     */
    public int maxSubarraySumCircular(int[] A) {
        int BiggestNeg = A[0];
        boolean allNeg = true;
        for(Integer i: A){
            if(i>=0) {
                allNeg=false;
                break;
            }
            if(i>BiggestNeg) BiggestNeg =i;
        }
        if(allNeg==true) return BiggestNeg;

        int max_in_middle = kadane(A);
        System.out.println("max_in_middle:"+max_in_middle);

        int wrap_sum = 0;
        for(int i=0;i<A.length;i++){
            wrap_sum+=A[i];
            A[i] = -A[i];
        }
        wrap_sum = wrap_sum + kadane(A);
        System.out.println("max_in_cross:"+wrap_sum);
        return wrap_sum>max_in_middle?wrap_sum:max_in_middle;
    }

    private int kadane(int[] A){
        int cur_max = A[0];
        int max_sub = A[0];
        for(int i=1;i<A.length;i++){
            cur_max= Math.max(A[i],cur_max+A[i]);
            max_sub= Math.max(max_sub,cur_max);
        }
        return max_sub;
    }

    /*
    fastest version of this problem
     */
    public int maxSubarraySumCircular2(int[] array) {
        int acc = 0;
        int max1 = kadane(array);
        for(int i = 0; i < array.length; i++) {
            acc += array[i];
            array[i] = -array[i];
        }
        int min = kadane(array);
        int max2 = acc + min;
        if(max2 == 0) {
            return max1;
        }
        return Math.max(max1, max2);
    }
    public int kadane2(int[] array) {
        int maxTillI = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            maxTillI = Math.max(maxTillI+array[i], array[i]);
            max = Math.max(max, maxTillI);
        }
        return max;
    }
}
