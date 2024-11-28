package org.example;

public class BaekJoon27433 {

    public long pac(long num){
        //0이 되면 return, 그 전까진 계속 함수호출
        if(num == 0) return 1;
        return num * pac(num-1);
    }

    public void no27433(){
        long n = 20;

        System.out.println(pac(n));
    }
}