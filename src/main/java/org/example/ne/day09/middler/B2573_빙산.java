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
public class B2573_빙산 {
    static int[][] iceberg;
    static int[][] updatedIceberg;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        iceberg = new int[x][y];
        for (int i = 1; i < x - 1; i++) {
            String[] xData = br.readLine().split(" ");
            for (int j = 1; j < y - 1; j++) {
                iceberg[i][j] = Integer.parseInt(xData[j]);
            }
        }
        /* 덩어리 분리 유무 확인 */
        /* 년수 확인 */
        /* 0이 아닌 원소 찾아서 상하좌우 0 확인*/
        int cnt = 0;
        int years = 0;
        updatedIceberg = iceberg;
        while (true) {
            visited = new boolean[x][y];
            for (int i = 1; i < x - 1; i++) {
                for (int j = 1; j < y - 1; j++) {
                    if (iceberg[i][j] != 0 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int ice = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (iceberg[nextX][nextY] == 0) {
                    ice++;
                } else {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
