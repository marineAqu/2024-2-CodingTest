package org.example;

import java.util.*;

public class BaekJoon1253 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];
        int count  = 0;

        int point1 = 0;
        int point2 = n-1;

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        //투포인터로 푸는 문제같음
        //음수가 범위 내에 있음에 주의, 자기자신은 포함하지 않음에 주의

        Arrays.sort(arr);

        //각 숫자에 대해 좋은 수인지 검사
        for(int i=0; i<n; i++){
            //포인터 초기화
            if (i == 0) point1 = 1;
            else point1 = 0;
            if(i == n-1) point2 = n-2;
            else point2 = n-1;

            while(point1 < point2){
                if(arr[point1] + arr[point2] == arr[i]){
                    count++;
                    break;
                    
                }

                else if(arr[point1] + arr[point2] > arr[i]) {
                    if(point2-1 != i) point2--;
                    else point2 -= 2;
                }
                
                else{
                    if(point1+1 != i) point1++;
                    else point1 += 2;
                }
            }
        }

        System.out.println(count);
    }
}
