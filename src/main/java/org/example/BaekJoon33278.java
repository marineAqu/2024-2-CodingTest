package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 주의사항
 * 1. 기울기가 나무의 높이보다 넘칠 수 있다
 * 2. 삼각형 한 변의 길이 중 실수가 존재할 수 있다
 * 3. 너무 높아 다다음 나무에도 그림자 영향을 주는 경우가 있을 수 있다
 *      -> 이 경우, 그림자가 가장 멀리까지 있는 값(bestShadow)을 저장해두고, [i+1][0]이 시작지점이라고 한다면
 *           그림자 삼각형의 밑변을 알 수 있으므로 그림자 삼각형의 높이도 알 수 있다.
*/

public class BaekJoon33278 {
    public static void main(String args[]) throws IOException{
        //기울기가 높이와 밑변의 비율
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //나무 수
        long t = Long.parseLong(st.nextToken()); //기울기

        long answer = 0;
        long now;
        long bestShadow = Long.MIN_VALUE;

        //bestShadow에서 문제 발생. 위치가 음수인 경우도 존재하므로 0으로 초기화하면 안 된다
        //수정 이후에도 문제 발생 -> -10^9로 초기화했으나 bestShadow는 tree[i][1] + tree[i][0] * t 이기때문에
        //최솟값은 -10^9 * 10^3보다 작아야 한다.


        long[][] tree = new long[n][2]; //[0]은 위치, [1]은 크기

        for(int i=0; i<n; i++){
            st  = new StringTokenizer(br.readLine());
            tree[i][0] = Long.parseLong(st.nextToken());
            tree[i][1] = Long.parseLong(st.nextToken());
        }

        //정렬
        Arrays.sort(tree, new Comparator<long[]>(){
            @Override
            public int compare(long[] o1, long[] o2){
                return Long.compare(o1[0], o2[0]);
            }
        }); //오름차 정렬

        //계산
        for(int i=0; i<n-1; i++){
            //1. 가장 큰 그림자를 구한다 (bestShadow == 그림자의 끝점)

            /* 이 부분에서 오류가 났던 것 같다. 나눗셈을 전혀 사용하지 않고 구현하는 방법에 대해서 고민해보자 */
            //-> 어차피 now 계산 시에는 t를 곱해야 한다. 그렇다면 bestShadow에 미리 t를 곱한 값을 저장해두어 나눗셈을
            //      사용하지 않을 수 있다.

            if(tree[i][1] + (tree[i][0] * t) > bestShadow) bestShadow = tree[i][1] + tree[i][0] * t;

            //2. 그림자가 지지 않을 경우 스킵(위치+밑변 <= 다음나무위치)
            if(bestShadow <= tree[i+1][0] * t) continue;

            //3. 계산
            now = bestShadow - tree[i+1][0] * t;
            if(now > tree[i+1][1]) now = tree[i+1][1]; //넘치는 경우 대비

            answer += now;
        }

        System.out.print(answer);
    }
}
