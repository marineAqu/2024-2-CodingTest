package org.example;

import java.util.*;

public class BaekJoon4659 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String word;
        boolean isHaveMo; //1번 항목
        int tripleCountMo; //2번 항목
        int tripleCountJa; //2번 항목
        boolean isGood;

        while(true){
            word = sc.nextLine();
            
            isGood = true;
            isHaveMo = false;
            tripleCountMo = 0;
            tripleCountJa = 0;

            if(word.equals("end")) break;

            //모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            //모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            //같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
        
            for(int i=0; i<word.length(); i++){
                //3조건 검사
                if(i > 0 && word.charAt(i) == word.charAt(i-1) && (word.charAt(i) != 'e' && word.charAt(i) != 'o')){
                    isGood = false;
                    break;
                }

                if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i'|| word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                    //1조건 검사
                    if(isHaveMo == false) isHaveMo = true;
                    
                    //2조건 검사
                    tripleCountJa = 0;
                    tripleCountMo++;
                }

                //2조건 검사
                else{
                    tripleCountMo = 0;
                    tripleCountJa++;
                }

                if(tripleCountJa > 2 || tripleCountMo > 2){
                    isGood = false;
                    break;
                }

            }

            if(isHaveMo == false || isGood == false) System.out.println("<" + word +"> is not acceptable.");
            else System.out.println("<" + word +"> is acceptable.");
        }
    }
}
