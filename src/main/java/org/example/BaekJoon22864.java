package org.example;

import java.util.*;

public class BaekJoon22864 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //피로도
        int b = sc.nextInt(); //처리량
        int c = sc.nextInt(); //줄어드는 피로도
        int m = sc.nextInt(); //피로도 한계점

        int work = 0;
        int strass = 0;
        int hour = 0;

        while (true){
            //24시간이 되면 중단
            if(hour == 24) break;

            //피로도 체크 - 한번 더 일했을 때 임게점이면 쉬고 아니면 일한다
            if(strass + a > m){
                //쉰다
                strass -= c;
                if(strass < 0) strass = 0;
                //피로도가 -면 0으로 수정
            }
            else{
                //일한다
                strass += a;
                work += b;
            }

            hour++;
        }

        System.out.print(work);
    }
}
