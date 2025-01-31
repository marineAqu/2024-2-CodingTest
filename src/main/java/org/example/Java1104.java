package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Java1104 {

    //8장 그래프1

    int[] check;
    int nowCheck2 = 0;
    int no17Check = 0;

    LinkedList<Integer> answer = new LinkedList<>();
    int k;
    LinkedList<Integer> adj[];
    Queue<Integer> queue = new LinkedList<>();

    public void addEdge(int v, int w) {
        //삽입 정렬
        for(int i=0; i<adj[v].size(); i++){
            if(adj[v].get(i) > w){
                adj[v].add(i, w);
                return;
            }
        }
        adj[v].add(w);
    }

    public void dfs(int v, boolean[] visited){
        if(nowCheck2 == 1) nowCheck2 = 0;
        else nowCheck2 = 1;

        visited[v] = true;
        check[v] = nowCheck2;

        for(int i : adj[v]){
            if(!visited[i]){
                System.out.print(i+" ");
                dfs(i, visited);
            }
            else{
                if(check[i] == nowCheck2){
                    no17Check = 1;
                    return;
                }
            }
        }
    }

    public void bfs(int v, int[] visited){
        visited[v] = 0;
        queue.add(v);

        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i : adj[num]){
                if(visited[i] == -1){
                    visited[i] = visited[num]+1;
                    if(visited[i] == k) answer.add(i);
                    queue.add(i);
                }
            }
        }
    }

    public void no9() throws IOException {
        //9번 슬라이드 문제: 그래프 문제[46] 특정 거리의 도시 찾기 (제한시간: 2초)
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1104\\q46_01.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(st.nextToken());

        adj = new LinkedList[n+1];
        for(int i = 0; i<n+1; i++) adj[i] = new LinkedList<>();

        //그래프 데이터 저장
        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            addEdge(a, b);
            addEdge(b, a);
        }

        //visited 초기화
        int visited[] = new int[n+1];
        Arrays.fill(visited, -1);

        //bfs(x) 실행
        bfs(x, visited);


        //테스트용
        for(int i =1; i<n+1; i++) System.out.print(i+" : "+ visited[i] + " | ");
        System.out.println("\n----------------");

        //출력
        if(answer.isEmpty()) System.out.println("\n개수: -1");
        else {
            Collections.sort(answer);
            for(int i : answer) System.out.print(i+" ");
            System.out.println("\n개수: "+answer.size());
        }
    }

    public void no17() throws IOException {
        //17번 슬라이드 문제: 그래프 문제[48] 이분 그래프 판별하기 (제한시간: 2초)
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1104\\q48_03.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adj = new LinkedList[v + 1];
        for (int i = 0; i < v+1; i++) adj[i] = new LinkedList<>();
        check = new int[v+1];
        Arrays.fill(check, -1);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            addEdge(a, b);
            addEdge(b, a);
        }

        boolean[] visited = new boolean[v+1];

        dfs(1, visited);

        System.out.println();
        if(no17Check == 0) System.out.println("Yes");
        else System.out.println("No");
    }
    int[] parent;

    public void no36() throws IOException {
        //36번 슬라이드 문제: (유니온 파인드) 그래프 문제[50] 집합 표현하기 (제한시간: 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1104\\q50_02.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //집합의 개수
        int m = Integer.parseInt(st.nextToken()); //연산의 개수
        int oper, a, b;

        parent = new int[n+1];
        for(int i=1; i<n+1; i++) parent[i] = i; //초기화

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            oper = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            //집합 합치기(union)
            if(oper == 0) union(a, b);
            else if(oper == 1) {
                if(checkSame(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);

    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    public boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else return false;
    }
}
