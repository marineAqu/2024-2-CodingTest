package org.example;

import java.util.*;

public class BaekJoon20922 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        int maxCount = 0;

        int arr[] = new int[n];
        int countMany[] = new int[100001];

        int temp;

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        // 슬라이딩윈도우로풀어야하나
        //맞는듯

        //같은 정수가 k개 이하로 포함되어야 한다

        Deque<Integer> deque = new ArrayDeque<Integer>();

        for(int i=0; i<n; i++){

            // 나를 포함할 수 없는 경우 (내가 k를 넘은 경우)
            if(countMany[arr[i]] + 1 > k) {
                //나를 포함하면 k번을 넘어가기 때문에 포함하지 않고 최댓값을 저장
                if(deque.size() > maxCount) maxCount = deque.size();


                //이 이상 진행할 수 없기 때문에 횟수가 k가 되도록 이전을 일부 지운다
                while(true){
                    //하나 지웠으면 이제 나를 포함해도 넘치지 않음
                    temp = deque.removeFirst();
                    if(temp == arr[i]) break;
                    else countMany[temp]--;
                }
            }

            else countMany[arr[i]]++;
            
            //공통
            deque.add(arr[i]);
        }

        if(deque.size() > maxCount) maxCount = deque.size();

        System.out.print(maxCount);

    }
}
