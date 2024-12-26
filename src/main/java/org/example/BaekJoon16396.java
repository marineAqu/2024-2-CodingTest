package org.example;

import java.util.*;

public class BaekJoon16396 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10000];

        int n = sc.nextInt();
        int a, b;
        int count = 0;

        for(int i=0; i<n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            for(int t=a; t<b; t++) arr[t] = 1;
        }

        for(int i=1; i<10000; i++){
            if(arr[i] == 1) count++;
        }

        System.out.print(count);
    }
}
