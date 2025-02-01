package org.example;

import java.util.*;

public class BaekJoon31395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        long count = 0; //전체 갯수 -> int의 범위를 벗어남
        int countIn = 0; //큰 하나의 묶음 안에 들어있는 원소 개수

        //오름차로 되어있는 부분 갯수 구하기

        //받으면서 큰 묶음을 구하고, 큰 묶음 하나 안에 들어있는 원소 개수를 구하면 된다.
        // -> 큰 묶음이 끝나는 순간에 계산하기

        arr[0] = sc.nextInt();

        for(int i=1; i<n; i++) {
            arr[i] = sc.nextInt();

            if(arr[i-1] < arr[i]) {
                countIn++;
            }

            else{
                countIn++; //처음 시작한 자기자신은 포함하지 않았으므로

                //1개짜리는 따로 마지막에 계산
                //2개짜리 모두 더하기, ... countIn개짜리 모두 더하기
                for(int t=2; t<=countIn; t++){
                    count += countIn - (t-1);
                }

                //계산 후 리셋
                countIn = 0;
            }
        }

        //모두 받았으므로 계속되는 중이었는지 확인하고 마지막 계산하기
        if(countIn > 0){
            countIn++; //처음 시작한 자기자신은 포함하지 않았으므로

            //2개짜리 모두 더하기, ... countIn개짜리 모두 더하기
            for(int t=2; t<=countIn; t++){
                count += countIn - (t-1);
            }
        }

        //1개짜리 갯수
        count += n;

        //반환
        System.out.print(count);
    }
}
