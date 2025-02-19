package org.example;

import java.io.BufferedReader;
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

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\insertion_5.txt"));
        int n = 5;


        //1000개짜리 파일
        /*
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\insertion_1000.txt"));
        int n = 1000;
         */

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

    private void modQuicksort(int[] arr, int start, int end, int k){
        int pivot = findPivot(start, end, arr);

        if(pivot == k) return;
        else if(k < pivot) modQuicksort(arr, start, pivot-1, k);
        else modQuicksort(arr, pivot+1, end, k);
    }

    private int findPivot(int start, int end, int[] arr){

        //데이터가 2개인 경우
        if(start + 1 == end){
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }

        int m = (start + end) / 2;

        swap(arr, start, m);
        int pivot = arr[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (j >= start + 1 && pivot < arr[j]) j--;
            //피벗보다 작은 수가 나올 때까지 j--

            while (i <= end && pivot > arr[i] ) i++;
            //피벗보다 큰 수가 나올 떄까지 i++

            if (i < j) swap(arr, i++, j--);  // 찾은 i와 j를 교환하기
            else break;
        }

        arr[start] = arr[j];
        arr[j] = pivot;

        return j;
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public void no28() throws IOException {
        //28번 슬라이드 문제, 퀵정렬 문제[019] k번째 수 구하기 (시간제한 2초)

        // 5개짜리 파일
        //BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\quick_5.txt"));
        //int n = 5;
        //int k = 2;

        //100개짜리 파일
        /*
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\quick_100.txt"));
        int n = 100;
        int k = 20;
         */

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0923\\quick_5000000.txt"));
        int n = 5000000;
        int k = 50;


        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        modQuicksort(arr, 0, n-1, k);

        System.out.println(arr[k-1]);
    }
}
