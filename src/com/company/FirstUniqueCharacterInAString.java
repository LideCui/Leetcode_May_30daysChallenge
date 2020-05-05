package com.company;
/* Given a string, find the first non-repeating character in it and return it's index.
    If it doesn't exist, return -1.
 */

import java.util.HashMap;

/*
solve this problem before, use map to hold
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer[]> mp = new HashMap<>();
        int index = -1;

        for(int i=0; i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                Integer[] node = new Integer[2];
                node[0] = mp.get(s.charAt(i))[0] + 1;
                node[1] = mp.get(s.charAt(i))[1];
                mp.put(s.charAt(i), node);
            }else{
                Integer[] node = new Integer[2];
                node[0] = 1;
                node[1] = i;
                mp.put(s.charAt(i),node);
            }
        }

        for(int i=0; i<s.length();i++){
            if(mp.get(s.charAt(i))[0]==1 && (index>mp.get(s.charAt(i))[1] || index==-1)){
                index=mp.get(s.charAt(i))[1];
            }
        }

        return index;
    }
    /*
    sample solution:
    Have to admit my solution is very cumbersome
     */
    public int firstUniqChar2(String s) {
        int res = Integer.MAX_VALUE;

        for(char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);

            if(index != -1 && index == s.lastIndexOf(c)) //use the library to find last element of c, return last occurrence
                res = Math.min(res, index);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    /*
    four variations of IndexOf(), find first occurrence of a char or str from the beginning or some location.
     */
}
