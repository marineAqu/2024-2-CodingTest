package org.example;

import java.util.Scanner;

public class BaekJoon1312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt(); //소수점아래 몇번째

        // 30 / 4 = 7
        //rest = 2

        int rest = a;
        int val = 0;

        for(int i=0; i<n; i++){
            if(rest == 0) {
                System.out.print("0");
                return;
            }

            val = (rest * 10) / b;
            rest = (rest * 10) % b;
        }

        System.out.print(val % 10);
    }
}