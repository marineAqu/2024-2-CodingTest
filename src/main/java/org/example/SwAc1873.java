package org.example;

import java.util.Scanner;
import java.io.FileInputStream;

class SwAc1873{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        int h, w;
        int n;
        String inputSt;
        char userInput;
        int nowUserPoint[] = new int[3]; // [2]는 현재 방향 상태 (0은 아래 1은 위 2는 왼 3은 오른)

        T=sc.nextInt();
        int temp;

        for(int test_case = 1; test_case <= T; test_case++){
            h=sc.nextInt();
            w=sc.nextInt();
            sc.nextLine(); //빈 엔터 받기
            temp = 0; //테케마다 초기화
            int[][] arr = new int[h][w]; //맵

            //맵 받기
            for(int i=0; i<h; i++) {
                inputSt = sc.nextLine();

                for(int k=0; k<w; k++) {
                    //int 형태로 아스키코드값 arr에 저장
                    arr[i][k] = inputSt.charAt(k);

                    if(temp == 0 || arr[i][k] == '>' || arr[i][k] == 'v' || arr[i][k] == '<' || arr[i][k] == '^') {
                        nowUserPoint[0] = i;
                        nowUserPoint[1] = k;
                        nowUserPoint[2] = arr[i][k]; //방향을 저장
                        temp = 1;
                    }
                }
            }

            //유저 입력 받기 (조작)
            n = sc.nextInt();
            inputSt = sc.nextLine(); // 버퍼 비우기
            inputSt = sc.nextLine();

            //입력대로 수행
            for(int i=0; i<n; i++){
                userInput = inputSt.charAt(i);
                //발사 -> 방향에 따라 다른 반복문 실행
                //디버깅 해결: 지금까지 맵에 나자신을 그리지 않다가 if(arr[nowUserPoint[0]][nowUserPoint[1]] == (int)'>') 로 나자신 위치를 체크하는걸로 해서 실행이안됐던것
                // nowUserPoint[2]에 담아놨으니 그걸로체크하면 됨
                if(userInput == 'S'){
                    //오른쪽을 향하는 경우
                    if(nowUserPoint[2] == (int)'>'){
                        for(int k=nowUserPoint[1]+1; k<w; k++) {
                            if(arr[nowUserPoint[0]][k] == (int)'*') {
                                arr[nowUserPoint[0]][k] = (int)'.';
                                break;
                            }
                            if(arr[nowUserPoint[0]][k] == (int)'#'){
                                break;
                            }
                        }
                    }

                    //왼쪽을 향하는 경우
                    if(nowUserPoint[2] == (int)'<'){
                        for(int k=nowUserPoint[1]-1; k>=0; k--) {
                            if(arr[nowUserPoint[0]][k] == (int)'*') {
                                arr[nowUserPoint[0]][k] = (int)'.';
                                break;
                            }
                            if(arr[nowUserPoint[0]][k] == (int)'#'){
                                break;
                            }
                        }
                    }

                    //위을 향하는 경우
                    if(nowUserPoint[2] == (int)'^'){
                        for(int k=nowUserPoint[0]-1; k >= 0; k--) {
                            if(arr[k][nowUserPoint[1]] == (int)'*') {
                                arr[k][nowUserPoint[1]] = (int)'.';
                                break;
                            }
                            if(arr[k][nowUserPoint[1]] == (int)'#'){
                                break;
                            }
                        }
                    }

                    //아래을 향하는 경우
                    if(nowUserPoint[2] == (int)'v'){
                        for(int k=nowUserPoint[0]+1; k < h; k++) {
                            if(arr[k][nowUserPoint[1]] == (int)'*') {
                                arr[k][nowUserPoint[1]] = (int)'.';
                                break;
                            }
                            if(arr[k][nowUserPoint[1]] == (int)'#'){
                                break;
                            }
                        }
                    }

                    //끝: 왼, 아래, 위 모두 발포 코드 작성하기

                }
                //이하 이동하는 경우
                //지나간자리도 매꿔줘야함
                //자리가 차있어서 이동하지못하더라도 입력들어오면 방향바꿔줘야함
                //아래로 이동
                else if(userInput == 'D'){
                    nowUserPoint[2] = 'v';
                    if(nowUserPoint[0] < h-1 && arr[nowUserPoint[0]+1][nowUserPoint[1]] == (int)'.') {
                        //자리매꾸기 위치이동하기 방향저장하기
                        arr[nowUserPoint[0]][nowUserPoint[1]] = '.';
                        nowUserPoint[0]++;
                    }
                }

                //위로 이동
                else if(userInput == 'U'){
                    nowUserPoint[2] = '^';
                    if(nowUserPoint[0] > 0 && arr[nowUserPoint[0]-1][nowUserPoint[1]] == (int)'.') {
                        arr[nowUserPoint[0]][nowUserPoint[1]] = '.';
                        nowUserPoint[0]--;
                    }
                }

                //왼으로 이동
                else if(userInput == 'L'){
                    nowUserPoint[2] = '<';
                    if(nowUserPoint[1] > 0 && arr[nowUserPoint[0]][nowUserPoint[1]-1] == (int)'.') {
                        arr[nowUserPoint[0]][nowUserPoint[1]] = '.';
                        nowUserPoint[1]--;
                    }
                }

                //오른으로 이동
                else if(userInput == 'R'){
                    nowUserPoint[2] = '>';
                    if(nowUserPoint[1] < w-1 && arr[nowUserPoint[0]][nowUserPoint[1]+1] == (int)'.') {
                        arr[nowUserPoint[0]][nowUserPoint[1]] = '.';
                        nowUserPoint[1]++;
                    }
                }

                //end: 왼, 오른 모두 이동코드 작성하기
            }


            //여지껏 맵에 내위치를 그리지 않았는데 사용자에게 보여줘야하니까 그리기
            arr[nowUserPoint[0]][nowUserPoint[1]] = nowUserPoint[2];

            //결과 출력
            System.out.print("#"+test_case+" ");
            for(int i=0; i<h; i++) {
                for(int k=0; k<w; k++) System.out.print((char)arr[i][k]);
                System.out.println();
            }
        }
    }
}