package org.example;

public class Programmers43163 {
}
class Node{
    Node[] child;
    boolean isEnd;

    public Node(){
        child = new Node[26];
        isEnd = false;
    }

    public int solution(String begin, String target, String[] words) {
        //루트
        Node root = new Node();
        Node current;
        int index;
        int count = 0;

        //받은 문자로 트리 만들기
        for(int i=0; i<words.length; i++){
            current = root;

            //각 String에 대해서 트리 만들기
            for(int k=0; k<words[i].length(); i++){
                index = words[i].charAt(k) - 'a';

                if(current.child[index] == null){
                    current.child[index] = new Node();
                }

                current = current.child[index];
            }
        }

        //이제 가는 데 걸리는 count를 세야 한다
        //while(true){

        //}


        return count;
    }

}