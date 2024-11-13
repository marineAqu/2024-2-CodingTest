package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon2331 {

    ArrayList<Integer> arr = new ArrayList<>();

    public int cal(int num, int p){
        int result = 0;
        int temp;

        while(num/10 != 0){
            temp = num % 10;
            result += (int) Math.pow(temp, p);
            num /= 10;
        }

        result += (int) Math.pow(num, p);

        return result;
    }

    public void no2331(){
        //백준 2331번: 반복 수열 (실버 4)
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int p = sc.nextInt();

        int num;

        arr.add(a);

        while(true){
            num = cal(arr.get(arr.size()-1), p); //마지막으로 넣은 것
            if(arr.contains(num)) {
                System.out.println(arr.indexOf(num));
                break;
            }
            else arr.add(num);
        }
    }
}
