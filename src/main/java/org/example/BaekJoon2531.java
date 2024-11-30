package org.example;

import java.util.*;

public class BaekJoon2531 {
    //백준 회전초밥 (투포인터, 슬라이딩 윈도우/실버1)
    
    public void no2531(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //벨트에 놓인 접시 수
        int d = sc.nextInt(); //가짓수
        int k = sc.nextInt(); //연속 수
        int c = sc.nextInt(); //쿠폰번호

        int[] isPres = new int[d+1];
        Arrays.fill(isPres, 0);
        Queue<Integer> queue = new LinkedList<>();
        int[] saveFrountNum = new int[k-1];

        int maxCount = 0;
        int count = 0;
        int num;

        for(int i=0; i<k; i++) {
            num = sc.nextInt();

            //나중에 사이클 끝부분을 위해 앞부분 저장
            if(i != k-1) saveFrountNum[i] = num;

            if(isPres[num] == 0) count++;
            isPres[num]++;
            queue.add(num);

            maxCount = count;
        }

        //쿠폰이 포함되어있지 않으면 count++;
        if(isPres[c] == 0) maxCount++;

        for(int i=k; i<n; i++) {
            //하나 지워지는 과정
            num = queue.poll();
            if(--isPres[num] == 0) count--;

            //하나 추가하기
            num = sc.nextInt();
            if(isPres[num] == 0){
                count++;
            }
            isPres[num]++;
            queue.add(num);

            //쿠폰이 포함되어있지 않으면 count++;
            if(isPres[c] == 0) {
                isPres[c]++;
                count++;
            }

            //최댓값보다 크면 최댓값 교체
            if(maxCount < count) maxCount = count;
        }

        //끝부분
        for(int i=0; i<k-1; i++){
            //하나 지워지는 과정
            num = queue.poll();
            if(--isPres[num] == 0) count--;

            //하나 추가하기
            num = saveFrountNum[i];
            if(isPres[num] == 0){
                count++;
            }
            isPres[num]++;
            queue.add(num);

            //쿠폰이 포함되어있지 않으면 count++;
            if(isPres[c] == 0) {
                isPres[c]++;
                count++;
            }

            //최댓값보다 크면 최댓값 교체
            if(maxCount < count) maxCount = count;
        }


        System.out.println(maxCount);

    }
}
