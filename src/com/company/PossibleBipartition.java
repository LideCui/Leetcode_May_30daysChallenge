package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class PossibleBipartition {
    /*
    Use a hashset (key: dislike[][0], dislike[][1])
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N==1) return true;
        HashMap<String, ArrayList<Integer>> groups = new HashMap<>();
        if(dislikes.length==1){
            return true;
        }
        groups.put("a",new ArrayList<>());
        groups.put("b",new ArrayList<>());
        groups.get("a").add(dislikes[0][0]);
        groups.get("b").add(dislikes[0][1]);
        for(int i=1;i<dislikes.length;i++){
            // dislike[][0] doesn't exist in a
            if(!groups.get("a").contains(dislikes[i][0])){
                if(groups.get("b").contains(dislikes[i][0])){
                    if(groups.get("b").contains(dislikes[i][1])) return false;
                    else{
                        groups.get("a").add(dislikes[i][1]);
                    }
                }else{
                    if(groups.get("a").contains(dislikes[i][1])) groups.get("b").add(dislikes[i][0]);
                    else if(groups.get("b").contains(dislikes[i][1])) groups.get("a").add(dislikes[i][0]);
                    else {
                        groups.get("a").add(dislikes[i][0]);
                        groups.get("b").add(dislikes[i][1]);
                    }
                }
            }
            // dislike[][0] exists in a
            else {
                if(groups.get("b").contains(dislikes[0][0])) return false;
                else {
                    if(groups.get("a").contains(dislikes[i][1])) return false;
                    else{
                        groups.get("b").add(dislikes[i][1]);
                    }
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition2(int N, int[][] dislikes) {
        int[] group = new int[N+1];
        for (int i = 0; i <= N; i++) {
            group[i] = i; // initial
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (group[a] == a && group[b] == b) {
                group[a] = b;
                group[b] = a;
            } else if (group[a] == a && group[b] != b) {
                // let a go to group that all hate b;
                group[a] = group[group[b]];
            } else if (group[b] ==b && group[a] != a) {
                group[b] = group[group[a]];
            } else if (group[b] == group[a]) {
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition3(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        for(int i = 1; i <= N; ++i) colors[i] = i;
        for(int i = 0; i < dislikes.length; ++i) {
            int p1 = dislikes[i][0], p2 = dislikes[i][1];
            if(colors[p2] == p2) colors[p2] = p1;
            else {
                int[] uf1 = find(p1, colors), uf2 = find(p2, colors);
                if(uf1[0] == uf2[0] && uf1[1] == uf2[1]) return false;
            }
        }
        return true;
    }

    private int[] find(int p, int[] colors) {
        int color = 0;
        while(colors[p] != p) {
            p = colors[p];
            color = color == 0 ? 1 : 0;
        }
        return new int[] {p, color};
    }
}
