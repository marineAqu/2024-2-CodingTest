package org.example;

import java.util.Scanner;

public class Java0923 {
    Scanner scanner = new Scanner(System.in);

    //3장 정렬
    public void no6(){
        //6번 슬라이드 문제, 버블정렬 문제[015] 수 정렬하기 1 (시간제한 2초)

        int n = scanner.nextInt();
        int[] arr = new int[n];
        int temp = 0;

        for(int i=0; i<n; i++) arr[i] = scanner.nextInt();

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0; i<n; i++) System.out.println(arr[i]);
    }

    public void no12(){
        //12번 슬라이드 문제, 선택정렬 문제[017] 내림차순으로 자릿수 정렬하기 (시간제한 2초)

    }
}
