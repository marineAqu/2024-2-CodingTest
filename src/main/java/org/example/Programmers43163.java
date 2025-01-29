package org.example;

import java.util.*;

public class Programmers43163 {
    static int answer = -1;

    public static void main(String[] args){

    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, -1);

        //target까지 가기까지의 count를 리턴, 만약 words안에 target이 없으면 0 return
        if(answer != -1) return answer;
        return 0;
    }

    public void dfs(String begin, String target, String[] words, boolean[] visited, int count){
        int equalCount = 0;
        count++;

        if(target.equals(begin)) {
            answer = count;
            return;
        }

        for(int i=0; i<words.length; i++){
            if(visited[i] == false){
                //방문하지 않은 경우
                equalCount = 0;

                //다른 글자 수 세기
                for(int k=0; k<begin.length(); k++){
                    if(begin.charAt(k) != words[i].charAt(k)) equalCount++;
                }

                //한글자만 다른 경우
                if(equalCount == 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, visited, count);
                    visited[i] = false;
                }
            }
        }
    }
}