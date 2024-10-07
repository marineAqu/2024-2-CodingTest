package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Java1007DFS {
    LinkedList<Integer> adj[]; //no8에 사용하는 인접리스트

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void dfs(int v, boolean[] visited){
        visited[v] = true;
        for(int i : adj[v]){
            if(!visited[i]){
                dfs(i, visited);
            }
        }
    }

    public void no8() throws IOException {
        //8번 슬라이드 문제, 깊이우선 문제[023] 연결 요소의 개수 구하기 (시간제한 3초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1007\\dfs_05.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        int v, w;
        int count = 0;

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

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i, visited);
                count++;
            }
        }

        System.out.println("count: "+count);
        System.out.println("수행시간: " + (System.currentTimeMillis() - startTime) + "ms");
    }

}
