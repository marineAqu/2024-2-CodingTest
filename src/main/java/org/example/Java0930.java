package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Java0930 {

    //4장 정렬

    //합병정렬에 사용할 함수
    int[] sorted = new int[1000000];

    public void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public void merge(int[] arr, int start, int mid, int end){
        int i = start;
        int j = mid+1;
        int k = start;

        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                sorted[k++] = arr[i++];
            }else{
                sorted[k++] = arr[j++];
            }
        }

        if(i > mid){
            for(int t=j; t<=end; t++){
                sorted[k++] = arr[t];
            }
        }else{
            for(int t=i; t<=mid; t++){
                sorted[k++] = arr[t];
            }
        }

        for(int t=start; t<=end; t++){
            arr[t] = sorted[t];
        }
    }

    public void no7() throws IOException {
        //7번 슬라이드 문제, 병합정렬 문제[020] 수 정렬하기 2 (시간제한 2초)

        // 5개짜리 파일
        //BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0930\\merge_5.txt"));
        //int n = 5;

        // 100개짜리 파일
        //BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0930\\merge_100.txt"));
        //int n = 100;

        // 1000000개짜리 파일
        BufferedReader br = new BufferedReader(new FileReader
                ("C:\\Codingtest2024\\src\\main\\resources\\Java0930\\merge_1000000.txt"));
        int n = 1000000;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long startTime = System.currentTimeMillis();

        mergeSort(arr, 0, n-1);

        System.out.println("수행시간: " +
                (System.currentTimeMillis() - startTime) + "ms");

        System.out.println(Arrays.toString(arr));
    }

    int[] bucket = new int[10]; //자릿수 분포
    int[] output = new int[10000000]; // 임시정렬배열

    public void radixSort(int[] arr, int n){
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > max) max = arr[i];
        }

        int nowJari = 1;
        while(max / nowJari > 0){
            for(int i=0; i<10; i++) bucket[i] = 0;

            for(int i=0; i<n; i++){
                bucket[(arr[i] / nowJari) % 10]++;
            }

            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1];
            }

            for(int i=n-1; i>=0; i--){
                output[--bucket[(arr[i] / nowJari) % 10]] = arr[i];
            }

            for(int i=0; i<n; i++){
                arr[i] = output[i];
            }

            nowJari *= 10;
        }
    }

    public void no16() throws IOException {
        //16번 슬라이드 문제, 기수정렬 문제[022] 수 정렬하기3 (시간제한 3초)

        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java0930\\radix_10000000.txt"));
        int n = 10000000;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long startTime = System.currentTimeMillis();

        radixSort(arr, n);

        System.out.println(Arrays.toString(arr));

        System.out.println("수행시간: " +
                (System.currentTimeMillis() - startTime) + "ms");
    }
}
