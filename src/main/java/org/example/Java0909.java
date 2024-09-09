package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class Java0909 {
    //2강 자료구조
    Scanner scanner = new Scanner(System.in);

    public void no3 (int n){
        int sum = 0;
        int firpoint = 1;
        int laspoint = firpoint+1;
        int answer = 1;

        while (true){
            if(firpoint == (n/2)+1) break;

            //sum 구하기
            sum = 0;
            for(int i=firpoint; i<=laspoint; i++){
                sum += i;
            }

            //점검
            if(sum < n){
                laspoint++;
            }
            else if(sum > n){
                firpoint++;
                laspoint = firpoint+1;
            }
            else{
                //해당되는 경우 출력
                for(int i=firpoint; i<=laspoint; i++){
                    System.out.print(i);
                    if(i!=laspoint) System.out.print("+");
                }
                System.out.println();

                firpoint++;
                laspoint = firpoint + 1;
                answer++;
            }
        }
        System.out.println(n);
        System.out.println("총 개수: "+answer);
    }

    public void no10(){
        //02. 자료구조 - 10번 슬라이드 문제
        //백준 1253번
        int goodNum = 0;
        int firpoint, laspoint;
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        //정렬
        Arrays.sort(arr);

        for(int i=0; i<n; i++){

            System.out.println("체크: "+i);

            firpoint = 0;
            laspoint = n-1;

            if(i == n-1) laspoint = i - 1;
            else if(i == 0) firpoint = 1;

            while (firpoint < laspoint){
                if(arr[firpoint] + arr[laspoint] == arr[i]){
                    System.out.println("chek!!!!!!!!!!!");

                    if(firpoint != i && laspoint != i) {
                        goodNum++;

                        System.out.println(arr[i]+"is goodNum: "+arr[firpoint]+"+"+arr[laspoint]);

                        break;
                    }
                    else{
                        firpoint++;
                        laspoint--;
                    }
                }
                else if(arr[firpoint] + arr[laspoint] < arr[i]) firpoint++;
                else if(arr[firpoint] + arr[laspoint] > arr[i]) laspoint--;

                if(firpoint >= n || laspoint < 0) break;
            }
        }

        System.out.println("좋은 수의 개수: "+goodNum);
    }
}
