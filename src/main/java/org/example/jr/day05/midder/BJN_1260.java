package org.example.jr.day05.midder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJN_1260 {
    static int[] visited;
    static int[][] graph;
    static int node;

    static List<Integer> resultDfs = new ArrayList<>();
    static List<Integer> resultBfs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new int[node+1][node+1];

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start]=1;
        }

        visited = new int[node+1];
        Arrays.fill(visited,0);

        dfs(startNode);

        Arrays.fill(visited,0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] =1;

        bfs(queue);

        resultDfs.forEach(e -> System.out.print(e+" "));
        System.out.println();
        resultBfs.forEach(e -> System.out.print(e+" "));







    }

    public static void dfs(int startNode){
        visited[startNode]=1;
        resultDfs.add(startNode);

        for(int i=1; i<=node; i++){
            if(visited[i]!=1 && graph[startNode][i]==1){
                dfs(i);
            }
        }

    }

    public static void bfs(Queue<Integer> queue){

        while(!queue.isEmpty()){
            int curr = queue.poll();
            resultBfs.add(curr);

            for (int i = 1; i <= node; i++) {
                if (graph[curr][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }

        }

    }

}
