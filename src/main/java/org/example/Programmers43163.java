package org.example;

import java.util.*;

public class Programmers43163 {

    public int solution(String begin, String target, String[] words) {
        int count = 0;
        int equalCount = 0;
        int[] visited = new int[words.length];
        Queue<String> queue = new LinkedList<>();

        queue.add(begin);

        //bfs 실행
        while (!queue.isEmpty()) {
            String now = queue.poll();
            //방문 ++해주기

            for(String n : words){
                equalCount = 0;

                //1글자만 다른지 확인
                for(int i=0; i<now.length(); i++){
                    if(now.charAt(i) != n.charAt(i)){
                        equalCount++;
                    }
                }

                //아래에 1글자만 다른것에 미방문한 것인지도 체크 필요
                //1글자만 다른 경우
                if(equalCount == 1) {
                    queue.add(n);
                }
            }
        }

        return count;
    }

}