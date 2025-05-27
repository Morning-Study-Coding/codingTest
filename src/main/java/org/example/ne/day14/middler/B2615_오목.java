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
 *
 * 주의: 4방향만 탐색해도 됨 / 5개라면 직전 돌 확인 필요
 * */
public class B2615_오목 {
    static int[][] grid = new int[19][19];
    // →, ↓, ↘, ↙
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (grid[i][j] != 0) {  // 1, 혹은 2인 경우
                    for (int k = 0; k < dx.length; k++) {   // 방향별 탐색 시작
                        cnt = 1;
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (isValidRange(nextX, nextY) && (grid[nextX][nextY] == grid[i][j])) { // 유효한 범위 && 같은 색상
                            cnt += 1;
                            dfs(nextX, nextY, grid[i][j], dx[k], dy[k]);    // 한 방향으로 탐색
                        }

                        int beforeX = i - dx[k];
                        int beforeY = j - dy[k];
                        // 직전 돌 색상도 확인
                        if (cnt == 5 && !(isValidRange(beforeX, beforeY) && grid[beforeX][beforeY] == grid[i][j])) {
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

    private static boolean isValidRange(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < 19) && (y < 19);
    }

    static void dfs(int x, int y, int color, int dirX, int dirY) {
        int nextX = x + dirX;
        int nextY = y + dirY;
        if (isValidRange(nextX, nextY) && (grid[nextX][nextY] == color)) {
            cnt += 1;
            dfs(nextX, nextY, color, dirX, dirY);
        }
    }
}
