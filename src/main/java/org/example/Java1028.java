package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Java1028 {
    public void no7() {
        //7번 슬라이드 문제, 정수론 문제[032] 소수 구하기 (제한시간 2초)

        Scanner sc = new Scanner(System.in);

        //시작 끝
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n+1];

        //초기화
        for (int i = 0; i < n+1; i++) arr[i] = 0;

        //합성수 지우기
        for(int i=2; i<=Math.sqrt(n); i++){
            if(arr[i] == 1) continue;
            for(int j=2; i*j<=n; j++){
                arr[i*j] = 1;
            }
        }

        //소수 출력
        for(int i=m; i<=n; i++)
            if(arr[i] == 0) System.out.println(i);
    }

    public void no18() {
        //18번 슬라이드 문제, 정수론 문제[032] 오일러 피 함수 구현하기 (제한시간 1초)

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long start = System.currentTimeMillis();

        int count = 0;

        int[] arr = new int[n+1];

        //초기화
        for (int i = 0; i < n+1; i++) arr[i] = 0;

        //약수 -> 반복문 실행
        for(int i = 2; i<=n; i++){
            if(arr[i] == 1) continue;
            if(n%i == 0){
                for(int j=i; j<=n; j+=i){
                    arr[j] = 1;
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(arr[i] == 0) count++;
        }

        //소수 출력
        System.out.println("걸린 시간(ms): "+(System.currentTimeMillis()-start));
        System.out.println("오일러 피 count: "+count);
    }

    public int GCD(int a, int b){
        if(b == 0) return a;
        else return GCD(b, a % b);
    }

    public void no26(){
        //26번 슬라이드 문제, 정수론(유클리드 호제법) 문제[042] 최소 공배수 구하기 (제한시간 1초)

        Scanner sc = new Scanner(System.in);

        //시작 끝
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mod = GCD(a, b);

        System.out.println("mod(최대공약수): "+mod);

        System.out.print("최소공배수: "+(a*b)/mod);
    }

    public void no35(){
        //35번 슬라이드 문제, 정수론 문제(확장 유클리드 호제법)[045] Ax + By = C (제한시간 1초)

        Scanner sc = new Scanner(System.in);

        //시작 끝
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

    }

    /*for(int i=2; i<n; i++){
            temp = i*i;
            if(temp >= (n-m+1)) break; //인덱스 넘치면 정지
            arr[temp-m] = 1;
        }
         */
}
