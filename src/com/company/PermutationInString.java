package com.company;

import java.util.ArrayList;

public class PermutationInString {
    private static final int MAX = 26;
    public boolean checkInclusion(String s1, String s2) {//s1=p,s2=s
        int m = s2.length();
        int n = s1.length();
        if(m<n) return false;

        char[] countP = new char[MAX];
        char[] countW = new char[MAX];
        for(int i=0;i<n;i++){
            countP[s1.charAt(i)-'a']++;
            countW[s2.charAt(i)-'a']++;
        }

        for(int i=n;i<m;i++){
            if(compare(countP,countW))
                return true;
            countW[s2.charAt(i)-'a']++;
            countW[s2.charAt(i-n)-'a']--;
        }
        if(compare(countP,countW)) return true;
        return false;
    }

    private boolean compare(char[] arr1, char[] arr2){
        for(int i=0;i<MAX;i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}
