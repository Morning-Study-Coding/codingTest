package org.example.ne.day14.middler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *
 * 가로/세로/대각선 5개
 * 6개는 우승 아님
 *
 * 결과: 검읜색 이겼나, 흰색 이겼나, 아직 결정되기 전인가 (동시 이기는 경우 x
 *
 * 출력: 검은색 승 - 1, 흰색 승 - 2, 결정 전 - 0
 *       가장 위 가로줄 번호, 세로줄 번호
 * */
public class B2615_오목 {
    static int[][] grid = new int[19][19];
    static boolean[][] visited = new boolean[19][19];
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                depth += 1;
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;

                    for (int k = 0; k < dx.length; k++) {
                        depth = 1;
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if ((nextX >= 0) && (nextY >= 0) && (nextX < 19) && (nextY < 19) && (grid[nextX][nextY] == grid[i][j])) {
                            depth += 1;
                            dfs(nextX, nextY, grid[i][j], dx[k], dy[k]);
                        }

                        if (depth == 5) {
                            System.out.println(grid[i][j]);
                            System.out.printf("%d %d", i + 1, j + 1);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    static void dfs(int x, int y, int color, int dirX, int dirY) {
        int nextX = x + dirX;
        int nextY = y + dirY;
        if ((nextX >= 0) && (nextY >= 0) && (nextX < 19) && (nextY < 19) && (grid[nextX][nextY] == color)) {
            depth += 1;
            dfs(nextX, nextY, color, dirX, dirY);
        }
    }
}
