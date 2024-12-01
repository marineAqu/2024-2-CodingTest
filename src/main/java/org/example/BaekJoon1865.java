package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1865 {
    //백준 1865 웜홀 (벨만포드/골드3)

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int km;

        public Node(int start, int end, int km){
            this.start = start;
            this.end = end;
            this.km = km;
        }

        @Override
        public int compareTo(Node o) {
            return this.km - o.km;
        }
    }
    public void no1865(){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        boolean isGoPast;

        for(int i=0; i<tc; i++){
            isGoPast = false;

            int node = sc.nextInt();
            int edge = sc.nextInt();
            int wormhole = sc.nextInt();

            int[] dis = new int[node+1];
            Arrays.fill(dis, edge*10000);
            ArrayList<Node> nodelist = new ArrayList<>();
            int a, b, c;

            //엣지
            for(int t=0; t<edge; t++){
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();

                //a에서 b로 가는 도로가 둘 이상일 수도 있음에 주의
                nodelist.add(new Node(a, b, c));
                nodelist.add(new Node(b, a, c));
            }

            //웜홀
            for(int t=0; t<wormhole; t++){
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();

                nodelist.add(new Node(a, b, -c));
            }

            //dis[1] = 0;

            dis[0] = 0;

            for (int j = 1; j <= node; j++) {
                nodelist.add(new Node(0, j, 0));
            }

            //업데이트 수행
            //도착점 가는 길
            for(int k=1; k<=node; k++){
                for(Node nowNode : nodelist){
                    if(dis[nowNode.start] != edge*10000 && dis[nowNode.end] > dis[nowNode.start] + nowNode.km){
                        dis[nowNode.end] = dis[nowNode.start] + nowNode.km;
                    }
                }
            }

            //음수 사이클 검사
            for(Node nowNode : nodelist){
                if(dis[nowNode.start] != edge*10000 && dis[nowNode.end] > dis[nowNode.start] + nowNode.km){
                    isGoPast = true;
                    break;
                }
            }

            System.out.println(isGoPast ? "YES" : "NO");
        }
    }
}
