package com.company;

/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */

import java.util.HashMap;

/*
This is the typical find chip problem, solved by dived and conquer
D&C may not be a good solution, since you can not determine if left pairs are the same
This can also be solved by a Map.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                int count = mp.get(nums[i]) +1;
                if(count > n/2) return nums[i];
                else mp.put(nums[i],count);
            }else{
                mp.put(nums[i],1);
            }
        }
        return -1;
    }

    /*
    sample solution: use candidate
    let numbers compensate with each other 2 by 2, the left number is the majority
     */
    public int majorityElement2(int[] nums) {
        int leader=nums[0],leader_count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==leader) leader_count++;
            else{
                leader_count--;
                if(leader_count==0){
                    if(i<nums.length-1){
                        leader=nums[i+1];
                        leader_count=1;
                        i++;
                    }
                }
            }
        }
        return leader;

    }

}
