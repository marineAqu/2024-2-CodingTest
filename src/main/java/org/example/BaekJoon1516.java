package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1516 {

    //백준 1516 게임 개발 (위상정렬, 골드3)
    public void no1516(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] indegree = new int[n+1];
        int[] time = new int[n+1];
        Arrays.fill(indegree, 0);
        Arrays.fill(time, 0);

        int num;

        LinkedList<Integer>[] adj = new LinkedList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new LinkedList<>();

        for(int i=1; i<=n; i++){
            time[i] = sc.nextInt();

            num = sc.nextInt();
            //처음 소요시간과 마지막에 -1은 빼고
            while (num != -1){
                adj[num].add(i);
                indegree[i]++;

                num = sc.nextInt();
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++)
            if(indegree[i] == 0) queue.add(i);

        int[] result = new int[n+1];
        Arrays.fill(result, 0);

        while (!queue.isEmpty()){
            int x = queue.poll();
            result[x] = Math.max(result[x], time[x]);

            for(int y : adj[x]){
                indegree[y]--;
                result[y] = Math.max(result[y], result[x] + time[y]);

                if(indegree[y] == 0) {
                    queue.add(y);
                }
            }
        }

        for(int i=1; i<=n; i++) System.out.println(result[i]);
    }
}
