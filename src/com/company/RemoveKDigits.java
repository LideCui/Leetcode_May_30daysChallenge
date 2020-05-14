package com.company;

/*
Given a non-negative integer num represented as a string,
remove k digits from the number so that the new number is the smallest possible.
 */

/*
Maybe use DP to store current smallest number
not possible since too many cases to consider
Maybe try greedy try the smallest one possible every iteration (This is the way !)
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        int newLength = num.length()-k;

        char[] stack = new char[num.length()];
        int top=-1;
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(top >=0 && stack[top] > c && k > 0){
                top--;
                k--; // every time it goes back, it cause k--
            }
            stack[++top] = c;
        }

        int start=0;
        while(start < newLength && stack[start] == '0'){
            start++;
        }

        return start == newLength ? "0" : new String(stack, start, newLength-start);
    }
}
