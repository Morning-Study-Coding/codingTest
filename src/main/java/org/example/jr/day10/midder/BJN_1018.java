package org.example.jr.day10.midder;

import java.io.*;
import java.util.*;

public class BJN_1018 {

    /**
     * 입력
     *    width, height
     *    WB....
     *
     * 로직
     *    1. M*N 판 8*8로 자르기
     *    for(int i = 0; i <= M - 8; i++){
     *       for(int j = 0; j <= N - 8; j++){
     *              체스 시작점
     *
     *        }
     *    }
     *
     *
     *    2. 인접한 칸 조회, 색 확인
     *      for(int i=시작점; i<8; i++){
     *          for(int j=시작점 ; j<8; j++){
     *
     *              1. 시작 흰색 : 흰 -> 검 -> 흰-> 검
     *                  2,4,6,8,.. : 검정
     *                  1,3,5,7... : 흰색
     *
     *              2. 시작 검은색 : 검 -> 흰 -> 검 -> 흰
     *                  2,4,6,8...  : 흰색
     *                  1,3,5,7... : 검정
     *
     *          }
     *      }
     *
     *
     * 출력
     *    min
     *
     * */

    static int[][] grid;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        grid = new int[height][width];

        for(int i=0; i<height; i++){
            st = new StringTokenizer(br.readLine());
            char[] colored = st.nextToken().toCharArray();
            for (int j=0; j<colored.length; j++) {
                if(colored[j]=='W'){
                    grid[i][j] = 0;

                }else{
                    grid[i][j] = 1;

                }
            }

        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= height - 8; i++) {
            for (int j = 0; j <= width - 8; j++) {
                min = Math.min(min, getMinPaint(i, j));
            }
        }

        System.out.println(min);
    }

    public static int getMinPaint(int startX, int startY) {
        int startWRepaintCnt = 0;
        int startBRepaintCnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int expectStartW = ((i + j) % 2 == 0) ? 0 : 1;
                int expectStartB = ((i + j) % 2 == 0) ? 1 : 0;

                if (grid[startX + i][startY + j] != expectStartW) startWRepaintCnt++;
                if (grid[startX + i][startY + j] != expectStartB) startBRepaintCnt++;
            }
        }

        return Math.min(startWRepaintCnt, startBRepaintCnt);
    }

}
