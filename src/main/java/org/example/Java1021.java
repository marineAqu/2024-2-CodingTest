package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java1021 {

    //6장 그리디

    public void no4() throws IOException {
        //4번 슬라이드 문제, 그리디 문제[032] 동전 개수의 최솟값 구하기 (제한시간 1초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1021\\greedy_coins_03.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //arr[0]은 1, arr[1]은 5, arr[2]는 10, arr[3]은 50, arr[4]은 100, arr[5]은 500, arr[6]은 1000, arr[7]은 5000, arr[8]은 10000, arr[9]은 50000
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int count = 0;

        for (int i = 0; i < n; i++) {
            switch (Integer.parseInt(br.readLine())) {
                case 1:
                    arr[0]++;
                    break;
                case 5:
                    arr[1]++;
                    break;
                case 10:
                    arr[2]++;
                    break;
                case 50:
                    arr[3]++;
                    break;
                case 100:
                    arr[4]++;
                    break;
                case 500:
                    arr[5]++;
                    break;
                case 1000:
                    arr[6]++;
                    break;
                case 5000:
                    arr[7]++;
                    break;
                case 10000:
                    arr[8]++;
                    break;
                case 50000:
                    arr[9]++;
                    break;
            }
        }

        //코인 카운트 완료
        int temp = 5;
        int nowNum = 50000;
        int rtemp;

        for (int i = 9; i >= 0; i--) {
            if (k == 0) break;

            if (arr[i] != 0) {
                rtemp = k / nowNum;
                k -= rtemp * nowNum;
                count += rtemp;

                if(rtemp != 0) System.out.println(nowNum + " * " + rtemp);
            }


            //다음 코인으로
            if (temp == 5) {
                nowNum /= temp;
                temp = 2;
            } else if (temp == 2) {
                nowNum /= temp;
                temp = 5;
            }
        }

        System.out.println(count);
    }


    public void no11() throws IOException{
        //11번 슬라이드 문제
        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1021\\greedy_cards_02.txt"));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int tempsum;
        int sum = 0;

        //숫자 모두 받기
        for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        //정렬
        Arrays.sort(arr);

        //더하기
        for(int i = 0; i<n-1; i++){
            if(arr[i+1] == 0) continue;

            tempsum = arr[i] + arr[i+1];
            System.out.println(arr[i] + " + " + arr[i+1] + " = " + tempsum);
            arr[i+1] = tempsum;
            arr[i] = 0;
            sum += tempsum;

            Arrays.sort(arr);
        }

        System.out.println(sum);

    }

    public void no18() throws IOException{
        //18번 슬라이드 문제, 그리디 문제[035] 회의실 배정하기 (제한시간 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1021\\greedy_meetings_01.txt"));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //정렬: 시작하는 순, 시작하는 시간이 같으면 일찍 끝나는 순
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int endTime = arr[0][1];
        sb.append("Meeting:" + arr[0][0] + " - " + arr[0][1] + "\n");
        int count = 1;

        //진행할 회의 개수
        for(int i=1; i<n; i++){
            //정렬 상 시작하는 시간이 같은 뒤 인덱스는 늦게끝남
            if(arr[i][0] == arr[i-1][0]) continue;

            //더 빨리 끝나는 회의를 찾은 경우
            if(arr[i][1] < endTime) {
                endTime = arr[i][1];
                sb.delete(sb.lastIndexOf("M"), sb.lastIndexOf("\n"));
                sb.append("Meeting: " + arr[i][0] + " - " + arr[i][1] + "\n");
            }

            //이 다음 회의를 찾은 경우
            else if(arr[i][0] >= endTime){
                count++;
                endTime = arr[i][1];
                sb.append("Meeting: " + arr[i][0] + " - " + arr[i][1] + "\n");
            }
        }
        System.out.println(sb);
        System.out.println(count);
    }

    public void no23() throws IOException{
        //23번 슬라이드 문제, 그리디 문제[036] 최솟값을 만드는 괄호 배치 찾기 (제한시간 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1021\\greedy_min_02.txt"));

        String str = br.readLine();
        int plustemp1 = 0;
        int minustemp2 = 0;
        int count = 0;
        int sum = 0;
        int num[] = new int[50];

        Pattern pattern = Pattern.compile("\\d+|[()\\+\\-]");
        Matcher matcher = pattern.matcher(str);
        // + - ( ) 를 기준으로 자르기

        int numCount = 0;

        //숫자만 모음
        while (matcher.find()) {
            String value = matcher.group();
            if(!value.equals(")") && !value.equals("(") && !value.equals("+") && !value.equals("-")) {
                num[numCount] = Integer.parseInt(value);
                numCount++;
            }
        }

        plustemp1 += num[count];
        count++;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(' || str.charAt(i)==')') continue;

            if(str.charAt(i) == '-') {
                if(count == 1) System.out.print("-(");
                else System.out.print(")-(");
                minustemp2 += num[count];
                count++;
                continue;
            }

            else if (str.charAt(i) == '+') {
                minustemp2 += num[count];
                count++;
                System.out.print("+");
                continue;
            }

            System.out.print(str.charAt(i));
        }

        System.out.print(") = " + (plustemp1 - minustemp2));

    }
}