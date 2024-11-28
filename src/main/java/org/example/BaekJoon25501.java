package org.example;

import java.util.Scanner;

public class BaekJoon25501 {
    int count;
    public int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public void no25501(){
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        String st;

        for(int i=0; i<num; i++){
            count = 0;
            st = scanner.next();
            if(isPalindrome(st) == 1) System.out.println("1 "+count);
            else System.out.println("0 "+count);
        }
    }
}
