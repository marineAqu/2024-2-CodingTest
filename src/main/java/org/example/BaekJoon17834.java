package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BaekJoon17834 {

    //백준 17834 사자와 토끼 (이분그래프/골드2)

    LinkedList<Integer>[] adj;
    boolean check = true;
    int num1GrapCount = 0;
    int num2GrapCount = 0;

    public void dfs(int v, int[] visited, int oneOR){
        if(oneOR == 1) {
            oneOR = 0;
            num1GrapCount++;
        }
        else {
            oneOR = 1;
            num2GrapCount++;
        }

        visited[v] = oneOR;

        for(int i : adj[v]){
            if(visited[i] == -1){
                dfs(i, visited, oneOR);
            }
            else{
                if(visited[i] == oneOR){
                    check= false;
                    //이분그래프가 아님
                    return;
                }
            }
        }
    }

    public void no17834(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //node
        int m = sc.nextInt(); //edge

        int a, b;
        adj = new LinkedList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<>();

        int visited[] = new int[n+1];
        Arrays.fill(visited, -1);

        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1, visited, 1);

        //이분 그래프가 아님
        if(check == false) System.out.println("0");
        else {
            //전체에서 같은 그래프에 있는 경우를 빼줘야 한다
            // 전체: n*(n-1)
            // 같은 그래프:
            System.out.println((n*(n-1)) - ((num1GrapCount * (num1GrapCount - 1)) + (num2GrapCount * (num2GrapCount - 1))));
        }
    }
}
