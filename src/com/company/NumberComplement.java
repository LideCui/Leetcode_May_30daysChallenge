package com.company;

/*
Day 4:
Given a positive integer, output its complement number.
The complement strategy is to flip the bits of its binary representation.
 */

/**
 * convert a num to binary form, and do bitwise not, then transfer back and forth
 */
public class NumberComplement {
    //2*n time complexity
    public int findComplement(int num) {
        String b = Integer.toBinaryString(num);
        int cp =0;
        int j=0;
        for(int i=b.length()-1;i>=0;i--){
            if(b.charAt(i)=='0'){
                cp += Math.pow(2,j);
            }
            j++;
        }
        return cp;
    }

    /*
    Sample solution: use shift
    n time complexity
     */
    public int findComplement2(int num) {
        int cp = num;
        int sum = 0;
        while(num > 0){
            sum = (sum << 1) + 1; //make a number that every bit was 1
            num >>= 1;//shift one bit for num
        }
        return sum - cp; //subtract it to get the number

    }
}
