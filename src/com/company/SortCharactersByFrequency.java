package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Given a string, sort it in decreasing order based on the frequency of characters.
//"tree" -> "eert"

//learn to how to analyze the lower bound of a problem, how to do an algo in a scientific approach
public class SortCharactersByFrequency {
//    public String frequencySort(String s) {
//        int[] count = new int[256];
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//            count[(int)c]++;
//        }
//
//        // mp<frequency, list of char>
//       HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
//       for(int i=0; i<count.length;i++){
//           if(mp.containsKey(count[i])){
//               mp.get(count[i]).add(i);
//           }else {
//               mp.put(count[i], new ArrayList<>());
//               mp.get(count[i]).add(i);
//           }
//       }
//       printEle(count);
//       Arrays.sort(count);
//       printEle(count);
//
//       char[] res = new char[s.length()];
//       int index = 0;
//       for(int i=count.length-1;i>=0;i--){
//           if(count[i]==0) break; //unused array
//           ArrayList<Integer> ls = mp.get(count[i]);
//           for(Integer v:ls){
//               char c = (char)(int)v;
//               for(int j=count[i];j>0;j--){
//                   res[index]=c;
//                   index++;
//               }
//           }
//           if(index==res.length) break;
//       }
//
//       return String.valueOf(res);
//    }
    public String frequencySort(String s) {
        int len = s.length();
        int[] count = new int[256];

        int bucketLevel =0;
        for(int i=0;i<len;i++){
            count[s.charAt(i)]++;
            bucketLevel = Math.max(bucketLevel,count[s.charAt(i)]);
        }

        StringBuilder[] buckets = new StringBuilder[bucketLevel+1];
        for(int i=0; i<buckets.length;i++){
            buckets[i]= new StringBuilder();
        }

        for(int i=0; i<256;i++){
            int freq = count[i];
            if(freq>0){
                buckets[freq].append((char)i);
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i=bucketLevel;i>0;i--){
            char[] oneBucket = buckets[i].toString().toCharArray();
            for(int j=0;j<oneBucket.length;j++){
                for(int k=0;k<i;k++){
                    res.append(oneBucket[j]);
                }
            }
        }
        return String.valueOf(res);
    }

    private void printEle(int[] a){
        for(int ele: a){
            if(ele!=0)
                System.out.print(ele+" ");
        }
        System.out.println();
    }
}
