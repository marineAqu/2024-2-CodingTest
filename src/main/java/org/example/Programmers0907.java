package org.example;

//2024-2-codingtest
public class Programmers0907 {
    //프로그래머스 "주식가격"
    //https://school.programmers.co.kr/learn/courses/30/lessons/42584

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int count = 0;

        for(int i=0; i<prices.length; i++){
            count = 0;
            if(i == prices.length-1) {
                answer[i] = 0;
                break;
            }

            for(int k=i+1; k<prices.length; k++){
                if(k == prices.length-1) {
                    answer[i] = ++count;
                    break;
                }

                if(prices[i] <= prices[k])
                    count++;

                else{
                    answer[i] = ++count;
                    break;
                }
            }
        }

        return answer;
    }


    //프로그래머스 "네트워크"
    //https://school.programmers.co.kr/learn/courses/30/lessons/43162
    private void dfs(boolean[] visited, int[][] com, int n, int curr_v){
        visited[curr_v] = true;

        for (int j = 0; j < n; j++) {
            if (!visited[j] && com[curr_v][j] == 1) {
                dfs(visited, com, n, j);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, computers, n, i);
                answer++;
            }
        }

        return answer;
    }

}
