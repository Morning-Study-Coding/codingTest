package org.example.jr.day07.midder;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJN_2667 {

    static int[][] dir = new int[][]{{-1,0},{0,1},{0,-1},{-1,0}};

    static int[][] grid;
    static boolean[][] visited;

    static List<Integer> result = new ArrayList<>();

    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char[] arr = st.nextToken().toCharArray();

            for(int j=0; j<n; j++){

               grid[i][j] = arr[j]-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    Queue<int[]> queue = new LinkedList<>();
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                    result.add( bfs(queue,1));

                }
            }
        }


        for (Integer i : result.stream().sorted().collect(Collectors.toList())) {
            System.out.println(i);
        }

    }

    public static int bfs(Queue<int[]> q, int cnt){

        while(!q.isEmpty()){

            int[] loc = q.poll();

            for(int[] dir:dir){
                int x = dir[0];
                int y = dir[1];

                int newX = loc[0]-x;
                int newY = loc[1]-y;

                boolean isExist = isAvailable(newX,newY);
                if(isExist){
                    if(grid[newX][newY]==1 && !visited[newX][newY]){
                        cnt++;
                        visited[newX][newY]=true;
                        q.offer(new int[]{newX,newY});
                    }

                }


            }
        }

        return cnt;

    }

    public static boolean isAvailable(int x, int y){
        if (x >= n || y >= n || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

}
