package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1504 {
    //백준 1504 특정한 최단 경로 (다익스트라/골드4)

    static class Node implements Comparable<Node>{
        int end;
        int km;

        public Node(int end, int km){
            this.end = end;
            this.km = km;
        }

        @Override
        public int compareTo(Node o) {
            return this.km - o.km;
        }
    }

    LinkedList<Node>[] adj;
    boolean[] visited;
    int[] dist;
    int n;

    public void no1504(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int v = sc.nextInt();

        visited = new boolean[n+1];
        Arrays.fill(visited, false);
        dist = new int[n+1];
        Arrays.fill(dist,  200000000);
        adj = new LinkedList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new LinkedList<>();

        int a, b, weight;
        for(int i=0; i<v; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            weight = sc.nextInt();

            //양방향
            adj[a].add(new Node(b, weight));
            adj[b].add(new Node(a, weight));
        }

        //반드시 거쳐야 하는 정점
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        // 1 -> v1 -> v2 -> N으로 가는 경우
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int ans = (res1 >=  200000000 && res2 >=  200000000) ?
                -1 : Math.min(res1, res2);

        System.out.println(ans);
    }

    // 다익스트라 알고리즘
    public int dijkstra(int start, int end) {
        Arrays.fill(dist,  200000000);
        Arrays.fill(visited, false);
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : adj[cur]) {
                    if (!visited[node.end] && dist[node.end] > dist[cur] + node.km) {
                        dist[node.end] = dist[cur] + node.km;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }
}