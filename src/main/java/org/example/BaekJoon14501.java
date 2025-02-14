package org.example;

import java.util.*;

public class BaekJoon14501 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //1. 뒤에서부터 일단 상담을 할 수는 있는지 확인한다.
        //2. 상담이 가능할 경우, 이익을 모두 더한다. (5일까지 상담인데, 5일에는 2일짜리 상담이 있는 것은 신경쓰지 X)
        //3. 가장 많은 이익을 얻는 것을 출력

        int n = sc.nextInt();
        int[][] cal = new int[n+1][3];

        //값 받기
        for(int i=1; i<=n; i++){
            cal[i][0] = sc.nextInt();
            cal[i][1] = sc.nextInt();
        }

        int temp = 0;

        //dp 계산

        cal[n][2] = (cal[n][0] > 1) ? 0 : cal[n][1];

        for(int i=n-1; i>0; i--){
            //상담 불가
            if(cal[i][0] + i - 1 > n) cal[i][2] = cal[i+1][2];

            //상담 가능, 끝이 아님
            else {
                //1. 하루짜리 상담인 경우
                if(cal[i][0] == 1){
                    cal[i][2] = cal[i+1][2] + cal[i][1];
                    continue;
                }

                //2. 하루보다 많은 날짜가 필요한 상담의 경우

                //상담을 진행할 경우 이익 계산 시 해당 날짜 밖 dp값을 가져오면서 outofBound 문제 발생.
                if(i+cal[i][0] > n){
                    //그간 상담 진행을 안 했는지 확인
                    if (cal[i+1][2] == 0) {
                        cal[i][2] = cal[i][1];
                        continue;
                    }

                    //이익 계산
                    temp = cal[i][1];
                }

                // 2-1. 그간 상담 진행을 안 한 경우
                else if (cal[i+1][2] == 0 || cal[i + cal[i][0]][2] == cal[i+1][2]){
                    cal[i][2] = cal[i+1][2] + cal[i][1];
                    continue;
                }

                //이 상담을 진행할 경우 얻는 이익
                else temp = cal[i + cal[i][0]][2] + cal[i][1]; 

                if (temp < cal[i+1][2]) {
                    //2-2-1. 이 상담을 안 하는 편이 얻는 이익이 큰 경우
                    cal[i][2] = cal[i+1][2];
                }

                //2-2-2. 이 상담을 하는 편이 얻는 이익이 큰 경우
                else cal[i][2] = temp;
            }
        }

        System.out.print(cal[1][2]);
    }
}
