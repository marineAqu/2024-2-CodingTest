package org.example;

import java.util.*;

public class BaekJoon2644 {
    static LinkedList<Integer>[] adj;
    static int visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;

        //전체 사람의 수
        int n = sc.nextInt();
        visited = new int[n+1];
        adj = new LinkedList[n+1];

        for(int i=0; i<=n; i++)
            adj[i] = new LinkedList<Integer>();

        //촌수를 계산해야 하는 짝
        int a = sc.nextInt();
        int b = sc.nextInt();

        //부모 - 자식 관계 수
        int m = sc.nextInt();

        //부모 - 자식 관계 (x가 y의 부모)
        for(int i=0; i<m; i++){
            x = sc.nextInt();
            y = sc.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }

        //dfs 수행
        dfs(a, b);

        if(visited[b] == 0) System.out.println("-1");
        else System.out.println(visited[b]);

    }

    public static void dfs(int start, int end) {
        if(start == end) return;

        for(int now : adj[start]){
            if(visited[now] == 0 || visited[now] > visited[start] + 1) {
                visited[now] = visited[start] + 1;
                dfs(now, end);
            }
        }
    }
}