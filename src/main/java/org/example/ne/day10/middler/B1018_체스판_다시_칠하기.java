package org.example.ne.day10.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 입력
 *   MXN 크기 보드판
 *
 * 로직
 *   전체 순회하면서 색칠해야 하는 정사각형 찾기 - bfs로 8개까지만 하/좌 방향
 *   최소로 포함하는 값 찾기
 *
 * 출력
 * 칠해야하는 정사각형의 최소 개수
 *
 * */
public class B1018_체스판_다시_칠하기 {
    static boolean[][] BOARD;
    static boolean[][] VISITED;
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{-1, 0};
    static int RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        BOARD = new boolean[N][M];
        String startColor = null;
        boolean equalStart = true;
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            if (i == 0) startColor = data[0];
            for (int j = 0; j < M; j++) {
                String square = data[j];
                if ((!equalStart && startColor.equals(square)) || (equalStart && !startColor.equals(square))) {
                    BOARD[i][j] = true;
                }
                equalStart = !equalStart;
            }
            equalStart = !equalStart;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 8 <= N && j + 8 <= M) {
                    VISITED = new boolean[N][M];
                    VISITED[i][j] = true;
                    RESULT = 0;
                    dfs(i, j, 1);
                }
            }
        }
        System.out.println(RESULT);
    }

    private static void dfs(int x, int y, int idx) {
        if (idx == 9) {
            return;
        }

        if (x >= 0 && y >= 0 && !VISITED[x][y]) {
            VISITED[x][y] = true;
            RESULT++;
            for (int i = 0; i < 2; i++) {
                dfs(x + dx[i], y + dy[i], idx + 1);
            }
        }
    }
}
