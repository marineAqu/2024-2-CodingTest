package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class Programmers42839 {
    int[] arr;
    LinkedList<Integer> linkedList = new LinkedList<>();
    boolean[] visited;

    public void dfs(int num){
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(!linkedList.contains(num*10 + arr[i]))
                    linkedList.add(num*10 + arr[i]);
                dfs(num*10 + arr[i]);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        Arrays.fill(visited, false);
        int answer = 0;
        int[] prime = new int[(int) Math.pow(10, numbers.length())];
        arr = new int[numbers.length()];

        prime[0] = 1;
        prime[1] = 1;
        //일단 소수 모두 구하고
        for(int i=2; i<=Math.sqrt(Math.pow(10, numbers.length())); i++){
            if(prime[i] == 1) continue;
            for(int j=2; i*j<Math.pow(10, numbers.length()); j++){
                prime[i*j] = 1;
            }
        }

        //일단 각 수 저장
        for(int i=0; i<numbers.length(); i++)
            arr[i] = (numbers.charAt(i)-'0');

        //모든 경우 조합
        dfs(0);

        //소수배열에 들어있는지 확인
        for(int i=0; i<linkedList.size(); i++)
            if(prime[linkedList.get(i)] != 1) answer++;

        return answer;
    }
}
