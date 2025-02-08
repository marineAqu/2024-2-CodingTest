package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon19637{
    // 시간초과 문제 해결하기:
    // 바이너리서치를 이용하기
    // 바이너리서치를 쓰고도 시간초과 문제 -> 버퍼리더&스트링토크나이저 사용으로 해결

    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token =new StringTokenizer(br.readLine());

        StringBuilder st = new StringBuilder();


        int n = Integer.parseInt(token.nextToken()); //칭호 개수
        int m = Integer.parseInt(token.nextToken()); //캐릭터 수

        int start, end, mid = 0;

        int yourvalue;

        String name[] = new String[n];
        int nameValue[] = new int[n]; //내림차순


        for(int i=0; i<n; i++){
            token =new StringTokenizer(br.readLine());
            name[i] = token.nextToken();
            nameValue[i] = Integer.parseInt(token.nextToken());

            //숫자 중복을 지워주어야 이진탐색이 가능할 것 같은데
            //모든 숫자가 중복인 경우도 고려해야 한다
            //count로 중복이면 이 다음 것이 덮어쓰게 하고 이진탐색 end를 length가 아닌 count로 주기
        }

        //binarySearch
        for(int i=0; i<m; i++){
            token =new StringTokenizer(br.readLine());
            yourvalue = Integer.parseInt(token.nextToken());

            start = 0;
            end = n-1;

            while (start <= end) {
                mid = (start + end) / 2;

                if(yourvalue <= nameValue[mid]){
                    end = mid - 1;
                }
                else start = mid + 1;
            }

            st.append(name[start]+"\n");
        }

        System.out.print(st);
    }
}
