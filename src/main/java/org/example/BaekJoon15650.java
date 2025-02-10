package org.example;

import java.util.*;

public class BaekJoon15650 {

    static int bignum;
    static boolean visited[];

    static void dfs(String line, int depth, int beforeNum){
        for(int i=1; i<=bignum; i++){
            if(visited[i] == false && i > beforeNum){
                if(depth == 1){
                    System.out.println(line+i);
                }

                else{
                    visited[i] = true;
                    dfs(line+i+" ", depth-1, i);
                    visited[i] = false;
                }
            }
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        bignum = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[bignum+1];

        dfs("", m, 0);
    }
}
