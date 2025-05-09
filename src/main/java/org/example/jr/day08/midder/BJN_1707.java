package org.example.jr.day08.midder;

import java.io.*;
import java.util.*;

public class BJN_1707 {

    /**
     * 1. 입력
     *    테스트 케이스
     *    정점개수 간선개수
     *    그래프 연결 관계
     *
     * 2. 로직
     *    인접한 노드 : flag 다름
     *    인접하지 않은 노드 : flog 같음
     *
     * */

    static List<List<Integer>> grid = new ArrayList<>();

    static int node ;

    static char[] flags;// B | R

    static Queue<Integer> queue = new LinkedList<>();

    static boolean[] visited ;

    static String result = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tryCnt = Integer.parseInt(st.nextToken());

        for(int i=0; i<tryCnt; i++){

            st =  new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            flags = new char[node+1];
            visited = new boolean[node+1];

            for(int j=0; j<=node; j++){
                grid.add(new ArrayList<>());
            }

            for(int k=0; k<=node; k++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                grid.get(start).add(end);
                grid.get(end).add(start);

                queue.add(1);
                visited[1] = true;
                flags[1]='B';
                bfs();
            }


        }
        System.out.println(result);


    }
    public static void bfs(){
        while(!queue.isEmpty()){
            int now = queue.poll();

            for (Integer next : grid.get(now)) {
                if(flags[next]==' ' ){
                    flags[next]= now =='B'?'R':'B';
                }else if(flags[next]!=' '){
                    if(flags[next]==flags[now]){
                        result="NO";
                        return;

                    }


                }
            }
        }

    }

}
