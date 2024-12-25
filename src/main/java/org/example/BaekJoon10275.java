package org.example;

import java.util.Scanner;
import java.lang.Math;

public class BaekJoon10275 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        int t = sc.nextInt();
        for(int i=0; i<t; i++) casefun();
    }

    public static void casefun(){
        int n = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long at = (a>b)? b:a;

        //쪼갠 뒤 더하기 조합 시 작은 쪽을 만족하면 된다
        //1. 그러면 a, b 중 뭐가 더 작은지 구하고
        //2. 작은 쪽의 조합을 구해야한다
        //2-1. 2^n < a < 2^m의 n을 구하고
        //2-2. a-(2^n) 가 또 2의 몇승인지 구해야한다
        //2-3. 반복해서 구해서 a를 구성하는 가장 작은 2^n 요소의 n을 구한다
        //3. n - 가장작은요소의지수 = 정답
//        int count = n/2;
//
//        while(true){
//            if(at < Math.pow(2, count)) {
//                count--;
//            }
//            else if(at > Math.pow(2, count)) {
//                at -= (long) Math.pow(2, count);
//            }
//            else break;
//            //else if(at == Math.pow(2, count)) break;
//        }
        int count = 0; // 몇 번 나눴는지 저장


        //수정: 조합이라는 게 2^n(2^m+1) 조합으로 묶을 수 있으니까 그 n을 찾으면됨
        // =조합 내 가장 작은 숫자의 지수를 찾는 일이니까
        // => pow 사용하지 않아도 되고 시간초과 문제 해결

        // 작은 값을 반복적으로 2로 나눔
        while (at > 1) {
            if (at % 2 == 0) { // 2로 나눠 떨어질 경우
                at /= 2;
                count++;
            }
            else break; // 2로 나눠지지 않으면 중단
        }

        System.out.println(n-count);
    }
}