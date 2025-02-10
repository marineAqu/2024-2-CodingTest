package org.example;

import java.util.*;

public class BaekJoon1874 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        //수열을 만들수 있는지 없는지 먼저 확인하고, 가능하다면 순서 출력
        // push -> + / pop -> -
        int n = sc.nextInt(); // 숫자 개수

        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        //가능한지 확인하려면: 그 이전 수가 먼저 나타날 수 있는데 (팝 한 다음 푸시)
        // 높은 수가 나온 뒤 (5) 낮은 수가 나오고(3) 그 사이 수(4)가 나올 수 없다. 
        
        //** = 즉 바로 다음 숫자가 나타나는 게 아닌 건너뛰기가 불가능. (중간에 이미 pop한 게 아니라면)
        
        int count = 0; //문제의 index를 가리킴 
        int pushnum = 1; //넣어야 할 값
        int now;
        int stnum;

        //뒤에서부터 계산
        Stack<Integer> st = new Stack<>();
        
        //전부 다 넣지 않았거나 스택에 pop할 것이 남아있는 경우
        while (pushnum <= n || !st.empty()) {

            if(st.isEmpty()){
                //비어있으면 push해야함
                st.push(pushnum++);
                sb.append("+\n");

                continue;
            }

            now = arr[count]; //문제의 수
            stnum = st.pop(); //스택의 맨 앞

            //pop하는 경우
            if(now == stnum) {
                sb.append("-\n");
                count++;
            }

            //push하는 경우
            else if(stnum < now && pushnum <= now){
                st.push(stnum); //뺀거 도로 넣기
                sb.append("+\n");
                st.push(pushnum++);
            }

            else{
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        // while 종료
        System.out.print(sb);
    }
}
