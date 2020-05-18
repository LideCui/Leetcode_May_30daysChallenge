package com.company;


import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInAString {
    private static final int MAX = 26;

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        if(m<n) return null;

        ArrayList<Integer> ls = new ArrayList<>();

        char[] countP = new char[MAX];
        char[] countW = new char[MAX];
        for(int i=0;i<n;i++){
            countP[p.charAt(i)-'a']++;
            countW[s.charAt(i)-'a']++;
        }

        for(int i=n;i<m;i++){
            if(compare(countP,countW))
                ls.add(i-n);
            countW[s.charAt(i)-'a']++;
            countW[s.charAt(i-n)-'a']--;
        }
        if(compare(countP,countW)) ls.add(m-n);
        return ls;
    }

    private boolean compare(char[] arr1, char[] arr2){
        for(int i=0;i<MAX;i++) {
            if (arr1[i] != arr2[i]) return false;
        }
            return true;
    }
}
