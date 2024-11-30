package org.example;

import java.util.*;

public class BaekJoon1766 {
    //백준 1766 문제집 (위상정렬/골드2)

    public void no1766(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        LinkedList<Integer>[] adj = new LinkedList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<>();
        int[] indegree = new int[n+1];
        Arrays.fill(indegree, 0);

        int a, b, x;

        //간선 정보 얻기
        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            adj[a].add(b);
            indegree[b]++;
        }

        for(int i = 1; i<n+1; i++)
            if(indegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()){
            x = queue.poll();
            System.out.print(x+" ");
            for(int i : adj[x]){
                indegree[i]--;
                if(indegree[i] == 0) queue.add(i);
            }
        }

    }
}
