package org.example;

import java.util.*;

public class BaekJoon3665 {

    //백준 3665 최종순위 (위상정렬, 골드1)
    Scanner sc = new Scanner(System.in);
    int pastRank[];
    LinkedList<Integer> adj[];

    public void Cal(){
        int n = sc.nextInt();
        int[] indegree = new int[n+1];

        adj = new LinkedList[n+1];
        for(int i=1; i<=n; i++)
            adj[i] = new LinkedList<>();

        pastRank = new int[n+1];

        int a, b;

        //처음 순위 저장
        for(int i=1; i<=n; i++){
            pastRank[i] = sc.nextInt();
            indegree[pastRank[i]] = i-1;
        }

        //adj 구성(내 이전 것들 모두 포함)
        // -> adj[pastRank[a]]는 팀번호 a의 것
        for(int i=n-1; i>=1; i--){
            for(int t=1; t+i<=n; t++)
                adj[pastRank[i]].add(pastRank[i+t]);
        }

        int m = sc.nextInt();

        //내 뒤에 있는 것의 개수(arr)를 저장
        //m 이후 a++, b--
        //arr의 수를 내림차로 출력하면 됨
        //이때 arr 수 중 n>=인 경우 임파써블 출력

        for(int i=0; i<m; i++){
            //순서가 바뀐 a, b 쌍
            // -> a < b (b가 a보다 높은 등수라는 의미 x)
            a = sc.nextInt();
            b = sc.nextInt();

            if(adj[a].contains(b)){
                adj[b].add(a);
                indegree[a]++;

                adj[a].remove(Integer.valueOf(b));
                indegree[b]--;
            }
            else{
                adj[a].add(b);
                indegree[b]++;

                adj[b].remove(Integer.valueOf(a));
                indegree[a]--;
            }

        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<n+1; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        int cnt = 0;
        String line = "";
        while (!queue.isEmpty()){
            int x = queue.poll();
            line += x+" ";
            cnt++;

            for(int y : adj[x]){
                indegree[y]--;
                if(indegree[y] == 0) queue.add(y);
            }
        }
        if(cnt != n) line = "IMPOSSIBLE";
        System.out.println(line);
    }

    public void no3665(){
        int testCase = sc.nextInt();

        for(int i=0; i<testCase; i++) Cal();
    }

}
