package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Java1118 {

    static class Edge{
        int a, b, distance;

        public Edge(int a, int b, int distance){
            this.a = a;
            this.b = b;
            this.distance = distance;
        }
    }

    public void no8() throws IOException {
        //8번 슬라이드 문제, 그래프(3) 벨만포드 문제[059] 타임머신으로 빨리가기 (제한시간 1초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1118\\q59_03.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Edge> edges = new ArrayList<>();

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int a, b, distance;

        int[] dis = new int[node+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<edge; i++){
           st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, distance));
        }

        dis[1] = 0;

        for(int i=1; i<node; i++){
            for(Edge e : edges){
                if(dis[e.a] != Integer.MAX_VALUE && dis[e.b] > dis[e.a] + e.distance){
                    dis[e.b] = dis[e.a] + e.distance;
                }
            }
        }

        for(Edge e : edges){
            if(dis[e.a] != Integer.MAX_VALUE && dis[e.b] > dis[e.a] + e.distance){
                //이 경우 음수 사이클 존재 (한번 더 진행하니까 업데이트가 필요해진 상황 -> 음수 사이클인것)
                System.out.println("-1");
                return;
            }
        }

        for(int i=2; i<node+1; i++){
            if(dis[i] == Integer.MAX_VALUE) System.out.println("-1");
            else System.out.println(dis[i]);
        }
    }

    public void no26() throws IOException{
        //26번 슬라이드 문제, 그래프(3) 플로이드-워셜 문제[061] 가장 빠른 버스 노선 구하기 (제한시간 1초)

        // ** 오버플로우 문제 ** : 내 경우 Integer.MAX_VALUE를 사용하면서 lowCost[k][i] + lowCost[i][t] 에서 오버플로우가 났다.
        // ** 어쩐지 너무 큰 수의 음수가 나와서 당황했다. MAX_VALUE보다 작은 수를 사용하자.

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1118\\q61_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int city = Integer.parseInt(st.nextToken()); //도시 개수
        int bus = Integer.parseInt(st.nextToken()); //버스 개수
        int a, b, cost;

        int Max = 10000000;

        int[][] lowCost = new int[city+1][city+1];

        //초기화
        for(int i=1; i<city+1; i++){
            Arrays.fill(lowCost[i], Max);
            lowCost[i][i] = 0;
        }

        for(int i=0; i<bus; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            if(lowCost[a][b] > cost) lowCost[a][b] = cost; //중복 노선이 있을 수 있으므로
        }

        //플로이드-워셜 알고리즘 로직
        // ** 오버플로우를 겪었다 : 문제에 나타난 최대 비용을 보고 무지성 Integer.Max_value 사용 지양하자
        for(int i=1; i<=city; i++){
            for(int k=1; k<=city; k++){
                for(int t=1; t<=city; t++){
                    lowCost[k][t] = Math.min(lowCost[k][t], lowCost[k][i] + lowCost[i][t]);
                }
            }
        }

        //정답 출력
        for(int i=1; i<=city; i++){
            System.out.print(i+": ");
            for(int k=1; k<=city; k++){
                if(lowCost[i][k] == Max) System.out.print("-1 ");
                else System.out.print(lowCost[i][k]+" ");
            }
            System.out.println();
        }
    }

    int[] parents;

    public int find(int node){
        if(node == parents[node]) return node;
        return parents[node] = find(parents[node]);
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parents[b] = a;
    }

    public void no41() throws IOException{
        //41번 슬라이드 문제, 그래프(3) 문제[064] 최소 신장 트리 (제한시간 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1118\\q64_01.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        //에지 정보 저장
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance - o2.distance;
            }
        });

        parents = new int[n+1];

        for(int i=1; i<=n; i++) parents[i] = i; //부모는 자기 자신으로 초기화

        int a, b, dis;
        int answer = 0;

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            dis = Integer.parseInt(st.nextToken());

            pq.add(new Edge(a, b, dis));
        }

        int count = 0;
        while(count < n - 1){
            Edge edge = pq.poll();
            if(find(edge.a) != find(edge.b)){
                count++;
                //연결해도 사이클이 생기지 않는 경우
                union(edge.a, edge.b);
                answer += edge.distance;
            }
        }

        System.out.println(answer);
    }
}
