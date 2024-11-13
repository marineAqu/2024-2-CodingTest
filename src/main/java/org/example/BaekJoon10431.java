package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon10431 {
    Scanner sc = new Scanner(System.in);

    public void sort(int t){
        int count = 0;
        int[] arr = new int[20];
        int num;

        arr[0] = sc.nextInt();
        for(int i=1; i<20; i++){ //숫자 입력받으며 정렬
            arr[i] = sc.nextInt();

            if(arr[i-1] > arr[i]) {
                num = arr[i];

                //한 칸씩 미루다가 나보다 작은 애 있으면 stop
                for(int k=i-1; k>=0; k--){
                    if(arr[k] > num) {
                        count++;
                        arr[k+1] = arr[k];
                        if(k==0) arr[k] = num;
                    }
                    else {
                        arr[k+1] = num;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(t+" "+count);
    }

    public void no10431(){
        //백준 10431번: 줄 세우기 (실버 5)
        int p = sc.nextInt(); //테스트 케이스

        for(int i = 0; i<p; i++){
            //함수 호출
            sort(sc.nextInt());
        }
    }

    //삽입정렬
}
