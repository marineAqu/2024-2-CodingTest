package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Programmers92341 {
    //프로그래머스 "주차요금계산"
    //https://school.programmers.co.kr/learn/courses/30/lessons/92341
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        String line;
        int temp;
        int valtemp;

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> answerMap = new HashMap<>();

        for(int i=0; i<records.length; i++){
            if(records[i].split(" ")[2].equals("IN")) {
                line = records[i].split(" ")[0];

                temp = (((line.charAt(0)-'0') * 10) + (line.charAt(1)-'0'))* 60;
                temp += (line.charAt(3)-'0') * 10 + (line.charAt(4)-'0');

                map.put(Integer.parseInt(records[i].split(" ")[1]), temp);
            }
            else {
                line = records[i].split(" ")[0];

                temp = (((line.charAt(0)-'0') * 10) + (line.charAt(1)-'0'))* 60;
                temp += (line.charAt(3)-'0') * 10 + (line.charAt(4)-'0');

                temp -= map.remove(Integer.parseInt(records[i].split(" ")[1]));

                if(answerMap.containsKey(Integer.parseInt(records[i].split(" ")[1])))
                    temp += answerMap.remove(Integer.parseInt(records[i].split(" ")[1]));
                answerMap.put(Integer.parseInt(records[i].split(" ")[1]), temp);
            }
        }
        //들어오고 아직 나가지 않은 경우 계산 필요
        map.forEach((strKey, strValue)->{
            if(answerMap.containsKey(strKey)){
                int last = answerMap.remove(strKey);
                answerMap.put(strKey, last + 1439 - strValue);
            }
            else answerMap.put(strKey, 1439 - strValue);
        });

        LinkedList keyval = new LinkedList(answerMap.keySet());
        Collections.sort(keyval);

        //정산, 정렬
        int money;
        answer = new int[keyval.size()];
        for(int i=0; i<keyval.size(); i++){
            money = 0;
            valtemp = answerMap.get(keyval.get(i));

            valtemp -= fees[0];
            if(valtemp > 0) money = (valtemp/fees[2]) * fees[3];
            if(valtemp%fees[2] > 0) money += fees[3];

            answer[i] = fees[1] + money;
        }

        return answer;
    }
}
