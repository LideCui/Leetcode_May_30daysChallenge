package com.company;
/*
Day 10
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */

/*
Make a N*N table to see who they trust
 */
public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] trustArr = new int[N+1];
        for(int[] p: trust){
            trustArr[p[0]]--;
            trustArr[p[1]]++;
        }
        for(int i=1;i<trustArr.length;i++){
            if(trustArr[i]==N-1) return i;
        }
        return -1;
    }
}
