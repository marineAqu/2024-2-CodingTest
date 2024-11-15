package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1388 {
    //백준 1388번: 바닥 장식 (실버 4)


    public void no1388(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //줄
        int m = sc.nextInt();

        int count = 0;
        int isCountinue = 0;
        String line = sc.nextLine();

        ArrayList<Integer>[] arr = new ArrayList[m];
        for(int i=0; i<m; i++) arr[i] = new ArrayList<>();

        //-는 0, |는 1로 integer화

        for(int i=0; i<n; i++){
            isCountinue = 0;
            line = sc.nextLine();

            for (int k=0; k<m; k++){
                if(line.charAt(k) == '-') {
                    arr[k].add(0);

                    if(isCountinue == 0) {
                        isCountinue = 1;
                        count++;
                    }
                }
                else{
                    // '|' 인 경우
                    isCountinue = 0;
                    arr[k].add(1);
                }
            }
        }

        for(int i=0; i<m; i++){
            isCountinue = 0;
            for(int k=0; k<n; k++){
                if(arr[i].get(k) == 1) {
                    if(isCountinue == 0){
                        count++;
                        isCountinue = 1;
                    }
                }
                else isCountinue = 0;
            }
        }


        System.out.println(count);
    }

}
