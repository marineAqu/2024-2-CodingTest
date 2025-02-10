package org.example;

import java.util.*;

public class BaekJoon33257 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int e = sc.nextInt();
        int count = 1;

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for(int i=1; i<n; i++){
            if(arr[i] - arr[i-1] >= e) count++;
        }

        System.out.print(count);
    }
}
