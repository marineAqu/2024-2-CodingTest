package org.example;

import java.util.*;

public class BaekJoon1890 {

    //주의해야 하는 것:
    //1. 시간초과 (dfs)
    //2. 메모리 초과 (bfs)
    //3. int 오버플로우 (경로의 개수는 2^63-1보다 작거나 같음)


    static int[][] map;
    static int n;
    static boolean visited[][];
    static long[][] dp;
    static Queue<Node> queue = new LinkedList<Node>();

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //게임판 크기
        map = new int[n][n];
        visited = new boolean[n][n];
        dp = new long[n][n];

        // 맵 그리기
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++)
                map[i][k] = sc.nextInt();
        }

        //반드시 오른쪽 혹은 아래로만 가야한다. 
        //도착할 수 있는 경로의 개수를 구해야 한다.

        //dfs 사용 -> 시간초과 날 것 같지만 당연히 나버렸다
        //bfs(0, 0); //bfs로 구현하니 메모리 초과 발생
        //dp[][] 로 해당 위치로 도달할 수 있는 경우의 수를 계산??..........
        // -> 그러면 dp[n][m] = dp[n-1][m] + dp[n][m+1] 이지만 (모든 칸이 한칸만 이동 가능한 경우)
        //     이동 가능한 칸 수가 정해져 있으므로 이에 유의해서 풀면 될 듯 하다

        //그럼 0, 0 부터 시작해서, dp[x + 칸수][y] += dp[x][y] 식으로 ?........ **중복해서 더해지면 안됨 -> visited로 관리(자신)
        //다만 모든 칸이 한칸만 이동 가능해서 경로를 구하는 것과는 달리 내 바로 왼, 내 바로 위만 검사한다고 되는 게 X. 왼 3칸 전과 왼 1칸과 위 1칸 모두 나한테 필요함
        // -> 그러니까 나한테 도달하기 전에 모든 내 왼칸과 모든 내 위칸이 dp계산이 끝나있어야 한다.
        //따라서 dp += ... 는 나+내가이동할수있는칸 에 하되, bfs로 이동하는 것은 내 1칸 다음 아래, 오른 으로 가야한다. 

        dp[0][0] = 1;
        bfsForDp(0, 0);

        System.out.println(dp[n-1][n-1]);
    }

    /*static void dfs(int x, int y){
        if(x == n-1 && y == n-1) {
            count++;
            return;
        }
        
        //오른쪽
        if(x + map[y][x] < n){
            dfs(x + map[y][x], y);
        }
        //아래
        if(y + map[y][x] < n){
            dfs(x, y + map[y][x]);
        }
    }*/

    static void bfsForDp(int a, int b){
        queue.add(new Node(a, b));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            //이동할 것 미리 넣어두기
            if(now.x + 1 < n && visited[now.y][now.x + 1] == false) {
                visited[now.y][now.x + 1] = true;
                queue.add(new Node(now.x + 1, now.y));
            }
            if(now.y + 1 < n && visited[now.y + 1][now.x] == false) {
                visited[now.y + 1][now.x] = true;
                queue.add(new Node(now.x, now.y + 1));
            }

            //내가 더 갈 수 없거나 || 나한테 도달할 방법이 전혀 없는 경우
            if(map[now.y][now.x] == 0 || dp[now.y][now.x] == 0){
                continue;
            }

            //오른쪽
            if(now.x + map[now.y][now.x] < n){
                dp[now.y][now.x + map[now.y][now.x]] += dp[now.y][now.x];
            }
            //아래
            if(now.y + map[now.y][now.x] < n){
                dp[now.y + map[now.y][now.x]][now.x] += dp[now.y][now.x];
            }
        }
    }

    /*static void bfs(int a, int b){
        queue.add(new Node(a, b));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.x == n-1 && now.y == n-1) {
                count++;
                continue;
            }

            if(map[now.y][now.x] == 0){
                continue;
            }

            //오른쪽
            if(now.x + map[now.y][now.x] < n){
                queue.add(new Node(now.x + map[now.y][now.x], now.y));
            }
            //아래
            if(now.y + map[now.y][now.x] < n){
                queue.add(new Node(now.x, now.y + map[now.y][now.x]));
            }
        }
    }*/
}