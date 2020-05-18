package com.company;

public class Main {

    public static void main(String[] args) {
        String str = "abaabaa";
        String p = "aa";
       System.out.println(new FindAllAnagramInAString().findAnagrams(str,p).toString());
    }
}