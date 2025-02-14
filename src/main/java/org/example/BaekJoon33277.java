package org.example;

import java.util.*;

public class BaekJoon33277 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        //24시간 = 100%
        //12시간 = 50%
        //6시간 = 25%
        // 3시간(180분) = 12.5%
        // 36분 = 2.5%
        //1시간 = 4.1....
        // 1.5시간 = 6.25%
        
        //24*60 = 총 1440분.
        
        int hour = 0;
        int min = 0;
        
        //몫 - 나머지 계산.
        int x = (m*1440)/n;
        hour = x/60;
        min = x%60;
        
        //  1440 : x = n : m
        // n*x = m*1440
        //x = (m*1440/n)
        //x / 60 = 시간
        // x % 60 = 분
        //출력



        if(hour < 10) System.out.print("0"+hour);
        else System.out.print(hour);
        System.out.print(":");
        if(min < 10) System.out.print("0"+min);
        else System.out.print(min);
    }
}