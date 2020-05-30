package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int num) {
        if(num==0) return new int[]{0};
        if(num==1) return new int[]{0,1};
        int[] res = new int[num+1];
        res[0]=0;
        res[1]=1;

        int root = log2(num);

        for(int i=1;i<root;i++){
            int[] prev = Arrays.copyOfRange(res,(int)Math.pow(2,i-1), (int)Math.pow(2,i));
            for(int j=0; j<prev.length; j++){
                res[(int)Math.pow(2,i)+j] = prev[j];
            }
            for(int j=0; j<prev.length; j++){
                res[(int)(Math.pow(2,i)+Math.pow(2,i-1)+j)] = prev[j]+1;
            }
        }

        int[] last = Arrays.copyOfRange(res, (int)Math.pow(2,root-1), (int)Math.pow(2,root));
        for(int j=0; j<last.length;j++){
            int index = (int)Math.pow(2,root)+j;
            if(index>res.length-1) break;
            res[index] = last[j];
        }
        for(int j=0; j<last.length;j++){
            int index = (int)(Math.pow(2,root)+Math.pow(2,root-1)+j);
            if(index>res.length-1) break;
            res[index] = last[j]+1;
        }
        return res;
    }

    private int log2(int num){
        if(num==1) return 0;
        return 1+log2(num>>1);
    }

    public int[] countBits2(int num) {
        if (num < 0)
            return new int[1];

        // allocate array incuding 0->num
        int[] countBitArray = new int[num + 1];

        // initial DP data
        countBitArray[0] = 0;

        for (int i = 1; i <= num; i++) {
            // if num is even, bit count is same as num / 2
            // if odd, bit count is same as (num / 2) + 1
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        }

        return countBitArray;

    }
}
