package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon4779 {

    static String[] blankDp = new String[13];

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n;

        blankDp[2] = "   ";
        blankDp[3] = "         ";

        while((line = br.readLine()) != null){
            n = Integer.parseInt(line);
            if(n == 0){
                System.out.println("-");
                continue;
            }

            System.out.println(repeatMethod(n));
        }
    }
    //n=4라면
    //- -   - -         - -   - -/                           /- -   - -         - -   - -
    //빈칸 크기: 1-> 3(2)-> 9(3) -> 27(4)..
    //즉 결과적으로 출력되는 것은 - - 밖에없고, 중간에 얼마나 비어있느냐가 출력의 문제이다.

    public static String repeatMethod(int n){
        StringBuilder sb = new StringBuilder();
        String dot = "- -";

        //3나눈 것만큼 먼저 출력하기를 반복
        if(n == 1) return dot;
        else {
            sb.append(repeatMethod(n-1));
            if(blankDp[n] == null){
                makeBlank(n);
            }
            sb.append(blankDp[n]);
            sb.append(repeatMethod(n-1));
            return sb.toString();
        }
    }

    public static void makeBlank(int t){
        if(blankDp[t-1] == null) makeBlank(t-1);
        blankDp[t] = blankDp[t-1] + blankDp[t-1] + blankDp[t-1];
    }
}
