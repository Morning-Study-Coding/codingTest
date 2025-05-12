package org.example.ne.day09.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)
 * 만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.
 * */
/*
 * 입력:
 * int[][] 빙산
 *
 * 로직:
 *  1) 빙산 갯수 확인
 *  2) 빙산 녹이기
 *  3) 빙산 년수 확인
 *
 * 출력
 *  빙산 갯수가 2개 이상이 되는 년수
 *  끝까지 2개가 안되면 0
 * */
public class B2573_빙산 {
    static int[][] ICEBERG;
    static int[][] ZEROS;
    static boolean[][] VISITED;
    static int[] DX = {0, 0, -1, 1};
    static int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 행
        int M = Integer.parseInt(input[1]); // 열
        br.readLine();                      // 첫 행 스킵(모두 0)

        /* 빙산 배열 초기화 */
        ICEBERG = new int[N][M];
        for (int i = 1; i < N - 1; i++) {
            String[] xData = br.readLine().split(" ");
            for (int j = 1; j < M - 1; j++) {
                ICEBERG[i][j] = Integer.parseInt(xData[j]);
            }
        }

        int years = 0;              // 경과 년수
        while (true) {
            boolean flag = false;   // 반복 중지 플래그(모든 빙산 0 여부)
            int cnt = 0;            // 덩어리 갯수

            /* 방문 배열, 주변 0 갯수 배열 초기화 */
            VISITED = new boolean[N][M];
            ZEROS = new int[N][M];
            /* 연차별 덩어리 탐색 */
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (ICEBERG[i][j] != 0 && !VISITED[i][j]) {
                        cnt++;
                        if (cnt == 2) { // 덩어리 갯수가 2가 되면 리턴
                            System.out.println(years);
                            return;
                        }
                        bfs(i, j);
                    }
                }
            }

            /* 년도 증가, 빙산 녹이기 */
            years++;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    ICEBERG[i][j] = Math.max(ICEBERG[i][j] - ZEROS[i][j], 0);
                    if (ICEBERG[i][j] != 0) flag = true;    // 한 개의 빙산이라도 0이 아니면 반복
                }
            }
            if (!flag) break;
        }
        System.out.println(0);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        VISITED[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int zeroCnt = 0;    // 주변 0 갯수
            for (int i = 0; i < DX.length; i++) {
                int nextX = currX + DX[i];
                int nextY = currY + DY[i];
                if (nextX >= 0 && nextY >= 0 && nextX < ICEBERG.length && nextY < ICEBERG[0].length && !VISITED[nextX][nextY]) {
                    if (ICEBERG[nextX][nextY] == 0) {
                        zeroCnt++;
                    } else {
                        VISITED[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            ZEROS[currX][currY] = zeroCnt;  // 주변 0 갯수 저장 배열 업데이트
        }
    }
}
