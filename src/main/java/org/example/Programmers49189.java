package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers49189 {
    // 프로그래머스 49189(가장 먼 노드) lv3
    // 가장 먼 노드의 개수 구하기, BFS

    LinkedList<Integer>[] adj;
    int[] visited;
    Queue<Integer> queue = new LinkedList();
    //가장 멀리 떨어진 노드 개수
    int answer = 0;
    int maxkm = 0;

    public void addEdge(int a, int b){
        for(int i=0; i<adj[a].size(); i++){
            if(adj[a].get(i) > b){
                adj[a].add(i, b);
                return;
            }
        }
        adj[a].add(b);
    }

    public void bfs(int v){
        visited[v] = 0;
        queue.add(v);

        while (!queue.isEmpty()){
            int num = queue.poll();
            for(int i : adj[num]){
                if(visited[i] == -1){
                    visited[i] = visited[num] + 1;
                    if(visited[i] > maxkm){
                        maxkm = visited[i];
                        answer = 1;
                    }
                    else if (visited[i] == maxkm) answer++;
                    queue.add(i);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        //초기화
        visited = new int[n+1];
        Arrays.fill(visited, -1);
        adj = new LinkedList[n+1];
        for (int i=0; i<n+1; i++) adj[i] = new LinkedList<>();

        //그래프그리기
        for(int i=0; i<edge.length; i++){
            addEdge(edge[i][0], edge[i][1]);
            addEdge(edge[i][1], edge[i][0]);
        }

        bfs(1);

        return answer;
    }
}
