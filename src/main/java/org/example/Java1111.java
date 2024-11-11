package org.example;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Java1111 {
    public void no7() throws IOException {
        //7번 슬라이드 문제: (위상 정렬) 그래프(2) 문제[53] 줄 세우기 (제한시간: 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1111\\q53_03.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //에지 개수
        int a, b;
        LinkedList<Integer> adj[] = new LinkedList[n+1]; //인접리스트
        int[] inDegree = new int[n+1]; //진입 차수 배열


        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<>(); //초기화
        for(int i=0; i<n+1; i++) inDegree[i] = 0; //진입 차수 배열 초기화

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            inDegree[b]++;
        }

        //위상 정렬 수행
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=1; i<n+1; i++){
            if(inDegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int x = queue.poll(); //현재 노드
            System.out.print(x+" ");
            for(int y : adj[x]){
                inDegree[y]--;
                if(inDegree[y] == 0) queue.add(y);
            }
        }
    }

    public void no15() throws IOException {
        //15번 슬라이드 문제: (위상 정렬) 그래프(2) 문제[54] 게임 개발하기 (제한시간: 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1111\\q54_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //건물 종류 수
        int t, a;

        LinkedList<Integer> adj[] = new LinkedList[n+1]; //인접 리스트
        for (int i = 0; i < n+1; i++) adj[i] = new LinkedList<>(); //초기화

        int[] indegree = new int[n+1]; //진입 차수
        Arrays.fill(indegree, 0); //초기화

        int[] time = new int[n+1]; //건물 짓는데 걸리는 시간
        Arrays.fill(time, 0); //초기화

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken()); //건물 짓는데 걸리는 시간
            while(true){
                a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                adj[a].add(i);
                indegree[i]++;
            }
        }

        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        int[] result = new int[n+1]; //건물을 짓는데 걸리는 최소 시간
        Arrays.fill(result, 0); //초기화

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int y : adj[now]){
                indegree[y]--;
                result[y] = Math.max(result[y], result[now] + time[now]);
                if(indegree[y] == 0) queue.add(y);
            }
        }

        for (int i = 1; i < n+1; i++) {
            System.out.println(result[i] + time[i]);
        }
    }

    static class Node{
        int idx;
        int km;

        public Node(int idx, int km) {
            this.idx = idx;
            this.km = km;
        }
    }

    public void no31() throws IOException {
        //31번 슬라이드 문제: (다익스트라) 그래프(2) 문제[56] 최단 경로 구하기 (제한시간: 1초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1111\\q56_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //노드 개수
        int e = Integer.parseInt(st.nextToken()); //에지 개수

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken()); //시작 노드

        //거리 배열
        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNode] = 0;

        //인접 리스트
        LinkedList<Node>[] adj = new LinkedList[v+1];
        for (int i = 0; i < v+1; i++) {
            adj[i] = new LinkedList<>();
        }

        int a, b, km;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            km = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, km));
        }

        //다익스트라
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startNode, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(Node next : adj[now.idx]){
                if(distance[next.idx] > distance[now.idx] + next.km){
                    distance[next.idx] = distance[now.idx] + next.km;
                    queue.add(new Node(next.idx, distance[next.idx]));
                }
            }
        }

        for (int i = 1; i < v+1; i++) {
            if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }

    public void no38() throws IOException {
        //38번 슬라이드 문제: (다익스트라) 그래프(2) 문제[58] K번째 최단 경로 찾기 (제한시간: 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1111\\q58_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long start = System.currentTimeMillis();

        int n = Integer.parseInt(st.nextToken()); //도시 개수
        int m = Integer.parseInt(st.nextToken()); //도로 개수
        int k = Integer.parseInt(st.nextToken()); //k번째 최단 경로

        int a, b, km;

        //인접 리스트
        LinkedList<Node>[] adj = new LinkedList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            km = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, km));
        }

        //다익스트라
        PriorityQueue<Integer>[] distance = new PriorityQueue[n+1];
        for (int i = 0; i < n+1; i++) {
            //거꾸로정렬해야됨!!!
            distance[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.km));

        queue.add(new Node(1, 0));
        distance[1].add(0);

        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(Node next : adj[now.idx]){
                if(distance[next.idx].size() < k){
                    distance[next.idx].add(now.km + next.km);
                    queue.add(new Node(next.idx, now.km + next.km));
                }
                else if(distance[next.idx].peek() > now.km + next.km){
                    distance[next.idx].poll();
                    distance[next.idx].add(now.km + next.km);
                    queue.add(new Node(next.idx, now.km + next.km));
                }
            }
        }

        System.out.println("걸린 시간(ms): "+(System.currentTimeMillis()-start));

        //출력
        for(int i=1; i<n+1; i++){
            if(distance[i].size() == k) {
                System.out.println(i+ " : "+distance[i].poll());
            }
            else System.out.println(i+ " : -1");
        }
    }
}
