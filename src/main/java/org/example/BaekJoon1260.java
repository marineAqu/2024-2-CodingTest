package org.example;

import java.util.*;

class BaekJoon1260{
    static LinkedList<Integer> adj[];
    static boolean visited[];
    static Queue<Integer> queue = new LinkedList<Integer>();

    static void dfs(int i){
        visited[i] = true;
        System.out.print(i+" ");

        for(int now : adj[i]){
            if(visited[now] == false){
                dfs(now);
            }
        }
    }

    static void bfs(int i){
        visited[i] = true;
        queue.add(i);

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");

            for(int t : adj[now]){
                if(visited[t] == false){
                    visited[t] = true;
                    queue.add(t);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //정점 수
        int m = sc.nextInt(); //간선 수
        int v = sc.nextInt(); //시작 번호

        int a, b;

        visited = new boolean[n+1];
        adj = new LinkedList[n+1];
        for(int i=0; i<=n; i++) adj[i] = new LinkedList<Integer>();

        //정점 연결
        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        //dfs / bfs 수행

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false); //다시 false로 초기화
        bfs(v);
    }
}