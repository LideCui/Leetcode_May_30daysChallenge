package com.company;

public class Trie {

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    class TrieNode
    {
        TrieNode[] children = new TrieNode[26];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    };

    TrieNode root;


    /** Inserts a word into the trie. */
    public void insert(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode pCrawl = root;
        System.out.println();

        for(level =0; level <length; level++) {
            index = word.charAt(level)-'a';
            if(pCrawl.children[index]==null)
                pCrawl.children[index]=new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int level;
        int length = word.length();
        int index;
        TrieNode pCrawl = root;

        for(level = 0; level<length; level++){
            index=word.charAt(level)-'a';
            if(pCrawl.children[index]==null)
                return false;
            pCrawl = pCrawl.children[index];
        }

        return (pCrawl!=null && pCrawl.isEndOfWord);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int level;
        int length = prefix.length();
        int index;
        TrieNode pCrawl = root;

        for(level = 0; level<length; level++){
            index=prefix.charAt(level)-'a';
            if(pCrawl.children[index]==null)
                return false;
            pCrawl = pCrawl.children[index];
        }

        return pCrawl!=null;
    }
}
