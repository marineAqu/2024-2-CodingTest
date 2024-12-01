package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon4485 {

    //백준 4485 젤다 문제 (다익스트라, dfs/골드4)

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int km;

        public Node(int x, int y, int km){
            this.x = x;
            this.y = y;
            this.km = km;
        }

        @Override
        public int compareTo(Node o) {
            return this.km - o.km;
        }
    }

    int n;
    int map[][] = new int[125][125];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int bfs(){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int[][] move = new int[n][n];

        for(int i=0; i<n; i++)
            Arrays.fill(move[i], Integer.MAX_VALUE);

        priorityQueue.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while (!priorityQueue.isEmpty()){
            Node pos = priorityQueue.poll();

            int px = pos.x;
            int py = pos.y;
            int cost = pos.km;

            if(px == n-1 && py == n-1) return cost;

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx>n-1 || ny<0 || ny>n-1) continue;

                if(cost + map[ny][nx] < move[ny][nx]){
                    move[ny][nx] = cost + map[ny][nx];
                    priorityQueue.add(new Node(nx, ny, cost + map[ny][nx]));
                }
            }
        }

        return -1;
    }

    public void no4485(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int nowCount = 1;

        while (n != 0){
            //맵 저장
            for(int i=0; i<n; i++){
                for(int k=0; k<n; k++)
                    map[i][k] = sc.nextInt();
            }

            //출력
            System.out.println("Problem "+nowCount+": "+bfs());
            nowCount++;

            n = sc.nextInt();
        }
    }
}
