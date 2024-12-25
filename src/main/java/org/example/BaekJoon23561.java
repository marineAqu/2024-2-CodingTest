package org.example;

import java.util.*;

public class BaekJoon23561 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args){
        int n = sc.nextInt();
        for(int i=0; i<n*3; i++){
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        System.out.print(arr.get(n*3 - n -1) - arr.get(n));
    }
}
