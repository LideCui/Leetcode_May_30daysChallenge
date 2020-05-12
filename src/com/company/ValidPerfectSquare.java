package com.company;
/*
Day 9
Given a positive integer num, write a function which returns True if num is a perfect square else False.
 */

/*
Use prime factorization
Or use binary search to find if the root exists
 */
public class ValidPerfectSquare {
//    public boolean isPerfectSquare(int num) {
//        if(num==0||num==1) return true;
//        if(num==2||num==3) return false;
//        //int half = num/2; //divisor can not exceed half of the original number
//        int p = 2; //prime divisor
//        int counter=0;
//        while(num>=p*p){
//            if(num%p!=0){
//                if(counter%2==1) return false;
//                counter=0;
//                p += 1;
//            }else{
//                counter++;
//                num = num/p;
//            }
//        }
//        //if(counter==0) return false;
//        return true;
//    }

    //this binary search doesn't work well actually
//    public boolean isPerfectSquare(int num) {
//        if(num==0||num==1) return true;
//        return binarySearch(num,0,num);
//    }
//
//    private boolean binarySearch(int num, int L, int R){
//        int mid = (L+R)/2;
//        boolean result;
//
//        int c = mid*mid;
//        if(c==num) return true;
//        if(mid==L||mid==R) return false;
//        if(c>num){
//            result = binarySearch(num,L,mid-1);
//        }else{
//            result = binarySearch(num,mid+1,R);
//        }
//        return result;
//    }

    public boolean isPerfectSquare2(int num){
        if(num < 2) return true;
        int L = 2;
        int R = num;
        while(L<=R){
            int mid = (L+R)/2;
            if(Math.pow(mid,2)==num) return true;
            else if( Math.pow(mid,2) > num) R=mid-1;
            else L = mid+1;
        }
        return  false;
    }

}
