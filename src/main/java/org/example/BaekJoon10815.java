package org.example;

import java.util.*;

public class BaekJoon10815 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        // 정렬
        Arrays.sort(arr);

        int m = sc.nextInt();
        int num;

        //검사
        for(int i=0; i<m; i++){
            num = sc.nextInt();

            //이진탐색 실행

            if(Arrays.binarySearch(arr, num) < 0) System.out.print("0 ");
            else System.out.print("1 ");
            
        }
    }
}