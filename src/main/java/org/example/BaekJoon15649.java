package org.example;

import java.util.*;

public class BaekJoon15649 {
    static int n;
    static boolean[] visited;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n+1];
        int m = sc.nextInt();

        //순열 구하기 : n까지의 수에서 m개를 뽑는다

        dfs("", m);
    }

    static void dfs(String line, int depth){
        for(int i=1; i<=n; i++){

            if(visited[i] == false){
                
                if(depth == 1){
                    System.out.println(line+i);
                    //return;
                }
                
                else{
                    visited[i] = true;
                    dfs(line+i+" ", depth-1);
                    visited[i] = false;
                }
            }
        }
    }
}
