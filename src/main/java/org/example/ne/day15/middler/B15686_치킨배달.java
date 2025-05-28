package org.example.ne.day15.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * N*N 도시, r행 c열
 * r. c >= 1
 * 각 칸은 빈 칸 0 / 치킨집 1 / 집 2
 *
 * 두 칸 사이 거리는 r1 - r2 + c1 - c2
 * 치킨 거리: 집과 가장 가까운 치킨집과의 거리
 *
 * 치킨 거리가 가장 적게 되는 M개 구하기
 *
 * */
public class B15686_치킨배달 {
    static int[][] grid;
    static boolean[][] visited;
    static int[][] chickenMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        grid = new int[N][N];
        visited = new boolean[N][N];
        chickenMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(data[j]);
            }
        }

        // 1. 1인 경우 2인 치킨집과의 거리를 모두 찾아서 최소값만 남긴다.
        // 2. 치킨집이 발견되면 각 집에서 치킨집까지의 거리 저장
        // 3. 가장 거리 합 적은 치킨집만 M개 남기기?
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) visited[i][j] = true;
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(new int[]{i, j}, i, j);
                }
            }
        }
        List<Integer> result = new ArrayList<>();

    }

    static void dfs(int[] from, int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValidRange(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                int value = grid[nextX][nextY];
                if (value == 2) {
                    int[] chickenPos = new int[]{nextX, nextY};
                    int diff = Math.abs(from[0] - nextX) + Math.abs(from[1] - nextY);
                    chickenMap[nextX][nextY] += diff;
                }
                dfs(from, nextX, nextY);
//                visited[nextX][nextY] = false;
            }
        }
    }

    private static boolean isValidRange(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid.length;
    }
}
