package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon2501 {
    public void no2501(){
        Scanner sc = new Scanner(System.in);

        //백준 10431번: 줄 세우기 (실버 5)
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        if(n != 1) arr.add(n);
        for(int i=2; i<=n/2; i++){
            if(n%i == 0) {
                if(arr.contains(i)) break;
                arr.add(i);
                if(i != n/i) arr.add(n/i);
            }
        }

        Collections.sort(arr);
        System.out.println(arr);

        if(arr.size() < m) System.out.println("0");
        else System.out.println(arr.get(m-1));
    }
}
