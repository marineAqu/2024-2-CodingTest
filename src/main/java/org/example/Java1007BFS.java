package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java1007BFS {
    LinkedList<Integer> adj[];

    Queue<Integer> queue = new LinkedList<>();

    public void addEdge(int v, int w) {
        //삽입 정렬해야 한다 (문제에서 정점 번호가 작은 것을 먼저 방문해야 한다고 했기 때문)
        for(int i=0; i<adj[v].size(); i++){
            if(adj[v].get(i) > w){
                adj[v].add(i, w);
                return;
            }
        }
        adj[v].add(w);
    }

    public void dfs(int v, boolean[] visited){
        visited[v] = true;
        for(int i : adj[v]){
            if(!visited[i]){
                System.out.print(i+" ");
                dfs(i, visited);
            }
        }
    }


    public void bfs(int v, boolean[] visited){
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            int num = queue.poll();
            System.out.print(num+" ");
            for(int i : adj[num]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void no23()  throws IOException {
        //23번 슬라이드 문제, 문제26: DFS와 BFS 프로그램 (제한시간 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1007\\bfs_04.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        boolean[] visited_bfs = new boolean[n+1];
        int v, w;

        adj = new LinkedList[n+1];

        for(int i=0; i<n+1; i++){
            adj[i] = new LinkedList<>();
        }

        String line;
        //그래프 만들기
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            addEdge(v, w);
            addEdge(w, v);
        }

        long startTime = System.currentTimeMillis();

        //dfs 결과
        System.out.print(start+" ");
        dfs(start, visited);


        System.out.println();

        //bfs 결과
        bfs(start, visited_bfs);

        System.out.println();
        System.out.println("시간: "+(System.currentTimeMillis() - startTime) + "ms");
    }
}
