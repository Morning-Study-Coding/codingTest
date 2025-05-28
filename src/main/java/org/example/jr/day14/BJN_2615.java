package org.example.jr.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_2615 {

    static int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
    static int[][] grid = new int[19][19];
    static boolean[][] visited = new boolean[19][19];
    static int result=0;
    static int x;
    static int y;

    /**
     * 입력
     *    19*19
     *    1 : 흰색
     *    2 : 검은색
     *    0 : 없음
     *
     *
     *
     *
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<19; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){
                if (grid[i][j] != 0) {

                    dfs(new int[]{i,j},1,grid[i][j]);
                }
            }
        }

        System.out.println(result);


    }

    public static void dfs(int[] start, int cnt, int prev){

        if(cnt==5){
            result = prev;
            return;
        }

        if(!visited[start[0]][start[1]]){

            for (int[] dir : dirs) {
                int nextX = start[0]+dir[0];
                int nextY = start[1]+dir[1];
                if(nextX<0 || nextX>=19 || nextY<0 || nextY>=19 || (grid[nextX][nextY]!=prev)){
                    continue;
                }
                visited[start[0]][start[1]] = true;

                dfs(new int[]{nextX,nextY},cnt+1, prev);
                visited[start[0]][start[1]] = false;
            }
        }
    }

}
