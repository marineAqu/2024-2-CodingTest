package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Java0923{
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
        int n = scanner.nextInt();
        int[] arr = new int[n];


        for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
        int minNum, minIndex, temp;

        for(int i=0; i<n-1; i++){
            minNum = arr[i];
            minIndex = i;

            //중 최솟값 찾기
            for(int k=i+1; k<n; k++){
                if(arr[k] < minNum){
                    minNum = arr[k];
                    minIndex = k;
                }
            }

            //교환
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        //출력
        for(int i=n-1; i>=0; i--) System.out.println(arr[i]);
    }

    public void no20() throws IOException {
        //20번 슬라이드 문제, 삽입정렬 문제[018] ATM 인출시간 계산하기 (시간제한 1초)

        //5개짜리 파일
        /*
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\insertion_5.txt"));
        int n = 5;
         */

        //1000개짜리 파일
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\insertion_1000.txt"));
        int n = 1000;

        int[] arr = new int[n];
        int temp = 0;
        int nowNum = 0;
        int sum = 0;
        String tempStr = br.readLine();

        for(int i=0; i<n; i++){
            nowNum = Integer.parseInt(tempStr.split(" ")[i]);
            temp = 0; //초기화 (내가 제일 작음)

            //끼워넣을 index 찾기
            for(int k=i-1; k>=0; k--){
                if(arr[k] < nowNum){
                    temp = k+1; //끼워넣을 index
                    break;
                }
            }

            //시프트
            for(int k=i; k>temp; k--){
                arr[k] = arr[k-1];
            }

            arr[temp] = nowNum;
        }

        //인출시간 계산
        for(int i=0; i<n; i++){
            for(int k=0; k<=i; k++){
                sum += arr[k];
            }
        }

        System.out.println(sum);
    }

    private void quickSort(int start, int end, int[] arr){
        if(start >= end) return;

        int pivot = start;
        int left = start+1;
        int right = end;
        int temp = 0;

        while(left <= right){
            while(left <= end && arr[left] <= arr[pivot]) left++;
            while(right > start && arr[right] >= arr[pivot]) right--;

            if(left > right){
                temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }
            else{
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        quickSort(start, right-1, arr);
        quickSort(right+1, end, arr);
    }

    public void no28() throws IOException {
        //28번 슬라이드 문제, 퀵정렬 문제[019] k번째 수 구하기 (시간제한 2초)

        // 5개짜리 파일

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\quick_5.txt"));
        int n = 5;
        int k = 2;


        //100개짜리 파일
        /*
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\quick_100.txt"));
        int n = 100;
        int k = 20;
         */

        /*
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\quick_5000000.txt"));
        int n = 5000000;
        int k = 50;
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        int[] arr = new int[n];

        for(i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, n-1, arr);

        System.out.println(arr[k-1]);
    }
}
