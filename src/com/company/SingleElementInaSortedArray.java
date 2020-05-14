package com.company;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice,
except for one element which appears exactly once. Find this single element that appears only once.
 */

/*
Should run in O(log n) times and O(1) space
I think use binary search, keep track of the subarray with odd number of elements
trick is determine if the number in middle is in pair
 */
public class SingleElementInaSortedArray {
    int result;

    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int L = 0;
        int R = nums.length-1;
        bfs(nums,L,R);
        return result;
    }

    private int bfs(int[] nums, int low, int high){
        if(low>high) return -1;
        if(low==high) {
            result = nums[high];
            return nums[high];
        }

        int mid = (low+high)/2;

        if(mid%2==0) {
            if(nums[mid]==nums[mid+1]){
                bfs(nums,mid+2,high);
            }else{
                bfs(nums,low,mid);
            }
        }else if(mid%2==1){
            if(nums[mid]==nums[mid-1]){
                bfs(nums,mid+1,high);
            }else{
                bfs(nums,low,mid-1);
            }
        }
        return -1;
    }

    //much better solution
    public int singleNonDuplicate2(int[] nums) {
        int L =0, len=nums.length, R = nums.length/2;

        while(L<R){
            int mid = L + ((R-L)>>1);//equal to divided by 2
            if(nums[2*mid]==nums[2*mid+1]){
                L=mid+1;
            }else{
                R=mid;
            }
        }

        return nums[2*L];
    }
}
