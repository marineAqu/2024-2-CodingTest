package org.example;

import java.util.*;

/*
 * 시간초과 발생 -> 재귀 함수 형태라 그런 것 같으니 while 형태로 옮기자
 * 그런데도 시간초과 발생 -> StringBuilder로 수정
 * 시간초과 문제 해결 !!!!!!!!!!
 */


public class BaekJoon15656{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();


        //n개의 자연수 중 m개를 고른 수열, 같은 수를 여러번 고를 수 있음
        int n = sc.nextInt();

        int m = sc.nextInt();

        // 저장
        int arr[] = new int[n];
        int indexOfNum[] = new int[m]; // 0으로 초기화 되어있으니까
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        //정렬
        Arrays.sort(arr);

        boolean temp = true;

        // 사전 순으로 출력 -> 재귀함수 사용
        while (temp == true) {
            //한 줄 출력 완료
            for(int i=0; i<m; i++) st.append(arr[indexOfNum[i]]+" ");
            st.append("\n");

            //다음 단계를 위한 초기화 과정
            for(int i=m-1; i>-1; i--) {

                //갈 데까지 갔으므로 0으로
                if(indexOfNum[i] == arr.length - 1) {
                    if(i == 0) temp = false; //0번째 인덱스까지 모두 마지막 숫자 출력을 마쳤으면 함수 return
                    indexOfNum[i] = 0;
                }

                //갈 데까지 간 게 아니므로 ++
                else {
                    indexOfNum[i]++;
                    break;
                }
            }
        }

        System.out.println(st.toString());
        
        //printArr(arr, indexOfNum, m);

    }

        //0 0 0
        //0 0 1
        //0 0 2
        //0 1 0
        //0 1 1
        //0 1 2
        //0 2 0
        //...
        //인덱스 관점에선 이런 느낌
        //그러니까 
        // 1. for문으로 0부터 m-1까지 arr[indexOfNum[nowCount]]를 출력 후 줄넘김
        // 2. indexOfNum[]에서 m-1에서 0으로 --해가며 
        // 2-1. indexOfNum[i]가 n-1이면 m-1부터 지금까지 indexOfNum를 0으로 바꾸고 indexOfNum[i-1]++
        //** indexOfNum[0] == n이면 (n-1까지 출력을 마쳤으면) 종료한다.

    
//한 줄을 온전히 출력하는 함수
/* 
    static void printArr(int[] arr, int[] indexOfNum, int m){
        
        //한 줄 출력 완료
        for(int i=0; i<m; i++) System.out.print(arr[indexOfNum[i]]+" ");
        System.out.println();

        //다음 단계를 위한 초기화 과정
        for(int i=m-1; i>-1; i--) {

            //갈 데까지 갔으므로 0으로
            if(indexOfNum[i] == arr.length - 1) {
                if(i == 0) return; //0번째 인덱스까지 모두 마지막 숫자 출력을 마쳤으면 함수 return
                indexOfNum[i] = 0;
            }

            //갈 데까지 간 게 아니므로 ++
            else {
                indexOfNum[i]++;
                break;
            }
        }

        printArr(arr, indexOfNum, m);
    }
        */
}