package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1003 {

    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        dp[2][0] = 1;
        dp[2][1] = 1;

        int t = Integer.parseInt(br.readLine());
        int n;
        int saveDP = 2;

        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());

            if(n > 1 && dp[n][0] == 0){
                for(int k=saveDP+1; k<=n; k++){
                    dp[k][0] = dp[k-1][0] + dp[k-2][0];
                    dp[k][1] = dp[k-1][1] + dp[k-2][1];
                }
                saveDP = n;
                sb.append(dp[n][0]+" "+dp[n][1]+"\n");
            }

            else sb.append(dp[n][0]+" "+dp[n][1]+"\n");

            //0이나 1이어야  return함
            //2라면 0, 1 (1, 1)
            //3이면 2, 1 -> 0, 1, 1 (1, 2)
            //4라면 3, 2 -> 1, 2, 0, 1-> 1, 1, 0, 0, 1 (2, 3)
            // 5라면 4, 3 -> (3, 5)

            //즉 f(n) = f(n-1) + f(n-2)
        }

        System.out.print(sb.toString());
    }


}
