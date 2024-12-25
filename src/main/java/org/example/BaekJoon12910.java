package org.example;

import java.util.*;

public class BaekJoon12910 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] brand = new int[51];
        Arrays.fill(brand, 0);

        //값 받기
        for(int i=0; i<n; i++) brand[sc.nextInt()]++;

        int answer = 0;

        //아 이해했다 나눌 사탕 개수 k를 결정하면 무조건 1부터 k까지 하나씩 골라야돼
        //예제 1이면
        //k=1 : 1 - 1가지
        //k=2 : 1, 2 - 1가지
        //k=3 : 1, 2, 3 - 1가지

        //예제 2면
        //k=1 : 1 - 2가지
        //k=2 : 1, 2 - 2가지

        //1. 현재 배열값이 0인지를 확인하기, 0이면 중단
        //2. 아니라면 k를 1씩 늘려가며 조합 수 구하고 더하기
        for(int i=1; i<51; i++){
            if(brand[i] == 0) break;

            if(i == 1) answer = brand[i];
            else{
                brand[i] *= brand[i-1];
                answer += brand[i];
            }
        }
        System.out.print(answer);
    }
}
