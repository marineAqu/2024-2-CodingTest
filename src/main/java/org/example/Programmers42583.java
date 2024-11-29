package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers42583 {
    //프로그래머스 lv2 다리를 지나는 트럭 (큐)
    //https://school.programmers.co.kr/learn/courses/30/lessons/42583
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<bridge_length; i++) queue.add(0);

        int nowIndex = 0;
        int nowWeight = 0;
        int nowCount = 0;

        int temp;

        int trunk;

        while (nowIndex < truck_weights.length){
            trunk = truck_weights[nowIndex];

            //한 칸씩 진전
            temp = queue.poll();
            answer++;

            //트럭 하나가 도착한 경우
            if(temp > 0){
                nowWeight -= temp;
                nowCount--;
            }

            //무게를 초과하거나 길이를 초과한 경우
            if(nowWeight + trunk > weight || nowCount > bridge_length){
                queue.add(0);
            }

            //무게도 길이도 초과하지 않은 경우
            else{
                queue.add(trunk);

                nowIndex++;
                nowCount++;
                nowWeight += trunk;
            }
        }

        return answer + queue.size();
    }
}
