package org.example.jr.day09.midder;

import java.io.*;
import java.util.*;

public class BJN_2573 {

    static int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] grid;
    static boolean[][] visited;


    /**
     * 입력
     *    int[][] grid  = 빙산(>=1) + 물(0)
     *
     *
     * 로직
     *    1. bfs : 인접한 빙산 녹이기 (1년 마다)
     *    2. 빙산 녹인 후
     *    3. bfs : 빙하 덩어리 찾기
     *
     *
     * 출력
     *    걸린 시간
     *
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        grid = new int[height][width];
        visited = new boolean[height][width];

        int loafCnt = 0;
        int year = 0;

        for(int i=0; i<height; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<width;j++){
                grid[i][j] =Integer.parseInt(st.nextToken());
            }
        }


        while(true){


            //빙산 덩어리 확인
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    if(grid[i][j]!=0){

                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i,j});
                        visited[i][j] = true;

                        bfs(queue,false);
                        loafCnt++;
                    }
                }
            }
            if(loafCnt>=2){
                break;
            }

            //빙산 덩어리 녹이기
            year++;

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    if(grid[i][j]!=0){

                        bfs()
                    }
                }
            }






        }

        System.out.println(year);

    }

    public static void bfs(Queue<int[]> queue, boolean isMelting){
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            int x = loc[0];
            int y = loc[1];

            for(int[] dir : dirs){
                int nextX = x+dir[0];
                int nextY = y+dir[0];


                if(grid[nextX][nextY]!=0 && !visited[nextX][nextY]){
                    queue.offer(new int[]{nextX,nextY});
                    visited[nextX][nextY]=true;
                    if(isMelting){

                    }
                }


            }


        }


    }

}
