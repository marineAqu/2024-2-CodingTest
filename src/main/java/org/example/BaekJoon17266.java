package org.example;

import java.util.*;

public class BaekJoon17266 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt(); //굴다리 길이
        int m = sc.nextInt(); //가로등 개수

        int maxLength = 0;

        int endtoendLength; //처음, 끝 중 가장 큰 값
        int lasttemp;
        int temp = 0;


        //가로등이 하나만 있는 경우
        if(m == 1){
            temp = sc.nextInt();
            if(temp > n - temp) System.out.println(temp);
            else System.out.println(n - temp);
            return;
        }

        //가로등이 둘 이상인 경우

        //오름차순, 중복ㄴ
        endtoendLength = sc.nextInt(); //0~첫 가로등까지 거리
        lasttemp = endtoendLength;
        for(int i=1; i<m; i++){
            temp = sc.nextInt();
            if(maxLength < temp - lasttemp) maxLength = temp - lasttemp;

            lasttemp = temp;
        }
        temp = n - temp; //마지막 가로등부터 끝까지 거리
        if(endtoendLength < temp) endtoendLength = temp; 

        //모두 비추기 위한 가로등의 최소 높이
        //-> 가로등 까지의 가장 긴 거리를 구해야 한다
        //  ** 이때 가장 긴 거리가 가로등과 가로등 사이라면,
        // 두 가로등이 겹치므로 절반만큼 가로등이 높아도 된다.
        //이때 처음 시작과 끝 길이에 대해서 유의해야 한다.

        //maxLength/2 에서 홀수면 0.5가 버려지는데 반올림해야함
        //양극단과 가로등과가로등사이의 최대 거리 중 더 큰 것을 비교하고 계산
        if(maxLength % 2 == 0){
            if(endtoendLength >= (maxLength/2)) temp = endtoendLength;
            else temp = (maxLength/2);
        }
        else {
            if(endtoendLength >= ((maxLength+1)/2)) temp = endtoendLength;
            else temp = ((maxLength+1)/2);
        }

        System.out.println(temp);
        
    }
}
