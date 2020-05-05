package com.company;
/*
Day 3
Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines;
otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * I have the question, does the order of string matters?
 * use a map to hold every char, and a int to record number
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ran = ransomNote.length();
        int mag = magazine.length();

        if(mag<ran) return false;

        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<mag; i++){
            char c = magazine.charAt(i);
            if(!mp.containsKey(c)) mp.put(c,0);
            int count = mp.get(c)+1;
            mp.put(c, count);
        }

        for(int j=0; j<ran;j++){
            char r = ransomNote.charAt(j);
            if(mp.containsKey(r)){
                int count = mp.get(r);
                if(count==0){
                    return false;
                }else{
                    count--;
                    mp.put(r,count);
                }
            }else{
                return false;
            }
        }
        return true;
    }

    /*
    fastest solution: use an array to count 26 characters
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] chars = new int[26];
        int counts = 0;
        for (int i = 0; i < ransomNote.length(); i++)
        {
            int index = ransomNote.charAt(i) - 'a';
            if (chars[index] == 0) counts++;
            chars[index]++;
        }

        for (int i = 0; i < magazine.length(); i++)
        {
            int index = magazine.charAt(i) - 'a';
            if (chars[index] == 1) counts--;
            if (counts == 0) return true;
            chars[index]--;
        }

        return counts == 0;
    }
}
