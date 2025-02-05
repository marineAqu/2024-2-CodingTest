package org.example;

import java.util.*;

public class BaekJoon19941 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //햄버거와 사람/ 최대 20000
        int k = sc.nextInt(); //먹을 수 있는 거리

        String line = sc.nextLine(); //버퍼 비우고
        line = sc.nextLine();
        Queue<Integer> hamberger = new LinkedList<>(); //햄버거
        Queue<Integer> person = new LinkedList<>(); //사람

        int count = 0; //햄버거를 먹을 수 있는 최대 사람 수
        int now;
        boolean didEat;

        //이전에 남은 햄버거를 저장해두자?,,,,,, 큐에 햄버거 위치 저장
        // -> 없으면?,,, 이다음 햄버거를 먹어야 함

        //1. 햄버거일 경우 사람큐에서 꺼내가며 먹일 수 있으면 먹인다
        //1-2. 못먹인 경우 햄버거큐에 넣는다
        //2. 사람인 경우 햄버거 큐에서 꺼내가며 먹일 수 있으면 먹인다
        //2-2. 못먹은 경우 사람큐에 넣는다


        //체크
        for(int i=0; i<n; i++){
            didEat = false;

            //햄버거일 경우
            if(line.charAt(i) == 'H') {
                //기다린 사람이 있는 경우
                while (person.size() > 0) {
                    now = person.poll();
                    
                    //먹일 수 있는 경우
                    if(i - now <= k){
                        count++;
                        didEat = true;
                        break;
                    }
                }

                //1-2
                if(didEat == false) hamberger.add(i);
            }
            
            
            //사람인 경우
            else{
                while (hamberger.size() > 0) {
                    now = hamberger.poll();
                    
                    if(i - now <= k) {
                        count++;
                        didEat = true;
                        break;
                    }
                }

                //2-2
                if(didEat == false) person.add(i);
            }

        }

        System.out.println(count);
       

    }
    
}
