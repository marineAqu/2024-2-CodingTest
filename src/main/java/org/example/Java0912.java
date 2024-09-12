package org.example;

import java.io.*;
import java.util.Stack;

public class Java0912 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void back28278() throws IOException {
        // 백준 28278 : https://www.acmicpc.net/problem/28278
        int n = Integer.parseInt(br.readLine());
        String temp;
        Stack<Integer> stack = new Stack<>();


        for(int i=0; i<n; i++){
            temp = br.readLine();

            if(Integer.parseInt(temp.split(" ")[0]) == 1) stack.push(Integer.parseInt(temp.split(" ")[1]));
            else if(Integer.parseInt(temp.split(" ")[0]) == 2){
                if(stack.empty()) bw.write("-1\n");
                else bw.write(stack.pop()+"\n");
            }
            else if(Integer.parseInt(temp.split(" ")[0]) == 3) bw.write(stack.size()+"\n");
            else if(Integer.parseInt(temp.split(" ")[0]) == 4) {
                if(stack.empty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if( Integer.parseInt(temp.split(" ")[0]) == 5){
                if(stack.empty()) bw.write("-1\n");
                else bw.write(stack.peek()+"\n");
            }
        }
        bw.flush();
    }
}
