package org.example;

import java.util.*;

class Heart{
    int x, y;

    Heart(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon20125 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String line = sc.nextLine();

        Heart heart = null;
        int backbornSize = 0;
        int lefthand = 0;
        int righthand = 0;
        int leftfoot = 0;
        int rightfoot = 0;

        for(int i=0; i<n; i++){
            line = sc.nextLine();
            
            //심장을 아직 찾지 못한 경우 심장부터 찾자
            if(heart == null){
                for(int t=0; t<n; t++){
                    if(line.charAt(t) == '*') //머리 발견
                        heart = new Heart(t, i+1); //심장은 머리 바로 아래
                }
            }

            //심장을 이미 알고 있는 경우 (==윗줄에서 머리가 있었던 경우)
            else{
                //팔 길이 모르는 경우
                if(lefthand == 0){
                    for(int t=0; t<n; t++){
                        if(lefthand == 0 && line.charAt(t) == '*') //왼팔 시작 지점 발견
                            lefthand = heart.x - t;
                        
                        if(lefthand != 0 && line.charAt(t) == '_'){ //왼팔을 이미 지난 경우
                            righthand = t - heart.x - 1;
                            break;
                        }
                    }
                }

                //허리 길이 모르는 경우
                if(backbornSize == 0){
                    //허리 끝을 찾기
                    if(line.charAt(heart.x) == '_') backbornSize = i - heart.y - 1;
                }

                //허리 길이 아는 경우
                else{
                    //다리 길이를 모르는 경우
                    if(leftfoot == 0){
                        if(line.charAt(heart.x - 1) == '_'){
                            leftfoot = i - heart.y - backbornSize - 1;
                        }
                    }

                    if(rightfoot == 0){
                        if(line.charAt(heart.x + 1) == '_'){
                            rightfoot = i - heart.y - backbornSize - 1;
                        }
                    }
                }
            }
        }

        if(righthand == 0) righthand = n - heart.x - 1;
        if(leftfoot == 0) leftfoot = n - heart.y - backbornSize - 1;
        if(rightfoot == 0) rightfoot = n - heart.y - backbornSize - 1;

        System.out.println((heart.y + 1) + " " + (heart.x + 1)); //심장 출력
        System.out.println(lefthand + " " + righthand + " " + backbornSize + " " + leftfoot + " " + rightfoot);
    }
}
