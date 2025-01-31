package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Java1125 {
    
    //10장: 트리

    ArrayList<Integer>[] arr;
    int answer[];
    int count = 0;

    public void dfsForNo4(int v, boolean[] visited){
        visited[v] = true;
        for(int i : arr[v]){
            if(!visited[i]){
                answer[i] = v;
                dfsForNo4(i, visited);
            }
        }
    }

    public void dfsForNo14(int v, boolean[] visited){
        visited[v] = true;
        if(v != 0 && arr[v].size() == 1) count++;

        for(int i : arr[v]){
            if(!visited[i]){
                dfsForNo14(i, visited);
            }
        }
    }

    public void no4() throws IOException {
        //4번 슬라이드 문제, 트리 문제[067] 트리의 부모 찾기 (제한시간 1초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1125\\q67_03.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 개수
        arr = new ArrayList[n+1];
        answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        //초기화
        for(int i=1; i<n+1; i++) arr[i] = new ArrayList<>();

        int a, b;

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        dfsForNo4(1, visited);

        for(int i=2; i<=n; i++){
            System.out.println(i+":"+answer[i]);
        }
    }

    public void no14() throws IOException{
        //14번 슬라이드 문제, 트리 문제[068] 리프 노드의 개수 구하기 (제한시간 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1125\\q68_01.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        count = 0;

        arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<>();

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        int temp;

        //각 부모
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            temp = Integer.parseInt(st.nextToken());

            if(temp == -1) continue;

            arr[i].add(temp);
            arr[temp].add(i);
        }

        //지울 노드
        st = new StringTokenizer(br.readLine());
        int delete = Integer.parseInt(st.nextToken());

        for(int i: arr[delete]) arr[i].remove(Integer.valueOf(delete));
        arr[delete].clear();

        dfsForNo14(0, visited);
        System.out.println(count);
    }

    //트라이에 사용할 Node class
    static class Node{

        Node[] children;
        boolean isEnd;

        public Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    public void no23() throws IOException{
        //23번 슬라이드 문제, 트라이(trie) 문제[069] 문자열 찾기 (제한시간 2초)

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int countNum = 0;

        Node root = new Node();
        Node current;

        for(int i=0; i<n; i++){
            String str = scanner.next();
            current = root;

            for(int j=0; j<str.length(); j++){
                int index = str.charAt(j) - 'a';

                if(current.children[index] == null){
                    current.children[index] = new Node();
                }

                current = current.children[index];
            }

            current.isEnd = true;
        }

        for(int i=0; i<m; i++){
            String str = scanner.next();
            current = root;
            boolean isFind = true;

            for(int j=0; j<str.length(); j++){
                int index = str.charAt(j) - 'a';

                if(current.children[index] == null){
                    isFind = false;
                    break;
                }

                current = current.children[index];
            }

            if(isFind && current.isEnd) countNum++;
        }

        System.out.println(countNum);
    }

    public void no32() throws IOException{
        //32번 슬라이드 문제, 이진 트리 문제[070] 트리 순회하기 (제한시간 2초)

        BufferedReader br = new BufferedReader(new FileReader("C:\\Codingtest2024\\src\\main\\resources\\Java1125\\q70_01.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] binaryTree = new int[n][2];

        int main, left, right;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            main = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            binaryTree[main - 'A'][0] = left == '.' ? -1 : left - 'A';
            binaryTree[main - 'A'][1] = right == '.' ? -1 : right - 'A';
        }

        System.out.print("\n전위 순회: ");
        preOrder(binaryTree, 0);
        System.out.print("\n중위 순회: ");
        inOrder(binaryTree, 0);
        System.out.print("\n후위 순회: ");
        postOrder(binaryTree, 0);

    }

    //전위함수
    public void preOrder(int[][] binaryTree, int root){
        if(root == -1) return;

        System.out.print((char)(root + 'A'));
        preOrder(binaryTree, binaryTree[root][0]);
        preOrder(binaryTree, binaryTree[root][1]);
    }

    //중위함수
    public void inOrder(int[][] binaryTree, int root){
        if(root == -1) return;

        inOrder(binaryTree, binaryTree[root][0]);
        System.out.print((char)(root + 'A'));
        inOrder(binaryTree, binaryTree[root][1]);
    }

    //후위함수
    public void postOrder(int[][] binaryTree, int root){
        if(root == -1) return;

        postOrder(binaryTree, binaryTree[root][0]);
        postOrder(binaryTree, binaryTree[root][1]);
        System.out.print((char)(root + 'A'));
    }
}
