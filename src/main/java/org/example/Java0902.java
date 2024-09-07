package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Java0902 {

    public void no2(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int add = 0;

        for(int i=0; i<n; i++){
            add += sc.nextInt();
        }

        System.out.print(add);

    }

    public void no35(){
        //ppt 35페이지: 구간 합 구하기

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] addN = new int[n];

        addN[0] = sc.nextInt();
        for(int k=1; k<n; k++){
            addN[k] = addN[k-1] + sc.nextInt();
        }

        int i, j = 0;

        for(int k=0; k<m; k++){
            i = sc.nextInt();
            j = sc.nextInt();

            if(i>1) System.out.print(addN[j-1]-addN[i-2]);
            else System.out.print(addN[j-1]);
        }
    }
}
