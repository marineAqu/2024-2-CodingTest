package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


//arraylist 사용 시 시간초과 발생 -> hashmap 사용
//arraylist는 모든 리스트를 돌면서 내가 찾으려는 것인지 확인하고,
//hashmap은 버킷을 만들고 그 버킷 내에 내가 찾으려는 값이 있는지 확인하므로 시간복잡도가 작다.

class Words implements Comparable<Words>{
    int frequency;
    String word;

    Words(int frequency, String word){
        this.frequency = frequency;
        this.word = word;
    }

    @Override
    public int compareTo(Words o){
        if(this.frequency == o.frequency){
            if(this.word.length() == o.word.length()){
                for(int i=0; i<word.length(); i++){
                    if(this.word.charAt(i) != o.word.charAt(i)){
                        return this.word.charAt(i) - o.word.charAt(i);
                    }
                }
            }
            return o.word.length() - this.word.length(); 
        }
        return o.frequency - this.frequency;
    }
}

// 잦은순 -> 긴순 -> 사전순
// 긴순, 사전순 정렬을 마친 뒤 각 단어의 빈도를 체크해서 재정렬한다.
// 단 긴순, 사전순 정렬로 인해 입력받으며 계속해서 단어의 순서가 바뀌므로 빈도를 어디에 어떻게 기록하느냐가 중요

// 차라리 정렬 없이 모든 입력을 받고 (빈도 따로, 단어 따로)
// Words 클래스를 만들어서 빈도수와 단어를 넣고 compareTo 로 정렬되도록 하기

public class BaekJoon20920 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken()); //영단어 수
        int m = Integer.parseInt(st.nextToken()); //외울 단어 길이

        LinkedList<Words> queue = new LinkedList<Words>();

        String line;

        ArrayList<String> wordLinkedList = new ArrayList<>(); //검색에 용이하도록 ArrayList 사용
        int[] intArrayList = new int[n];

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        for(int i=0; i<n; i++){
            line = br.readLine();
            
            //길이가 길거나 같아야 외움
            if(line.length() < m) continue;

            if(hashMap.containsKey(line)) hashMap.replace(line, hashMap.get(line)+1);
            else{
                hashMap.put(line, 1);
            }

            //시간초과
            /* 
            if((temp = wordLinkedList.indexOf(line)) != -1) intArrayList[temp]++;
            else {
                wordLinkedList.add(line);
                intArrayList[index] = 1;

                index++;
            }*/
        }


        for(Map.Entry<String, Integer> i : hashMap.entrySet()){
            queue.add(new Words(i.getValue(), i.getKey()));
        }

        //시간초과
        /*for(int i = 0; i<index; i++){
            queue.add(new Words(intArrayList[i], wordLinkedList.get(i)));
        }*/
        
        Collections.sort(queue);

        for(Words w : queue){
            bw.write(w.word+"\n");
            //System.out.println(w.word);
        }

        bw.flush();
    }
}