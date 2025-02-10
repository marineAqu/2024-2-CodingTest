package org.example;

import java.util.*;

public class BaekJoon9655 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 두사람이 돌을 1개 혹은 3개씩 가져갈 때,
        // 마지막 돌을 가져가는 사람이 승리
        // 선: SK / 후: CY

        //5개라면 1, 3, (선)
        // 3, 1, 1 (선)

        //6개면 3, 3 (후)
        // 1, 3, 1, 1 (후)
        // 1, 1, 3, 1 (후)

        //모두 1개씩만 가져간다면 가정하면 홀수일때 선이, 짝수일때 후가 이긴다
        //3개를 가져가는 것은 1개를 가져가는 것에서 한 라운드를 종료시키는 역할밖에 못한다. 2=1+1


        if(n % 2 == 0) System.out.print("CY");
        else System.out.print("SK");
    }
}
