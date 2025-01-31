package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

//5장 (이진탐색)

public class Java1007Binary {
    private void modQuicksort(int[] arr, int start, int end){
        int pivot = findPivot(start, end, arr);

        if(start < pivot - 1) modQuicksort(arr, start, pivot - 1);
        if(pivot + 1 < end) modQuicksort(arr, pivot + 1, end);
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

    //이진탐색
    public int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;

            if(arr[mid] == target){
                return 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return 0;
    }

    void no34() throws IOException {
        //34번 슬라이드 문제29: 원하는 정수 찾기 (제한시간 2초)
        //int n = 5;
        int n = 10;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1007\\binarysearch_02.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        long start = System.currentTimeMillis();

        //배열 입력
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //정렬
        modQuicksort(arr, 0, n-1);

        long end = System.currentTimeMillis();
        System.out.println("수행시간: " + (end - start) + "ms");
        //정답 출력
        for (int i = 0; i < n; i++) {
            System.out.println(binarySearch(arr, Integer.parseInt(st.nextToken())));
        }

    }
}
