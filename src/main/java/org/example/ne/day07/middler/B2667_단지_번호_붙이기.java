package org.example.ne.day07.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B2667_단지_번호_붙이기 {
    /* 단지가 끊긴 건 어떻게 알지 */
    /* BFS는 큐, visited가 핵심이다 */
    static int N;
    static int[][] houses;
    static boolean[][] visited;
    static List<Integer> result;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        /* 문제 조건 생성 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();

        /* 그리드 초기화 */
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(input[j]);
            }
        }

        /* 집 위치(단지)가 끊겨 있으므로 전체 그리드 탐색 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                /* 지도에 집이 존재하고 방문하지 않았을 때, 주변 탐색 시작 */
                if (houses[i][j] != 0 && !visited[i][j]) {
                    bfs(new int[]{i, j});
                }
            }
        }

        /* 답 출력 */
        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }

    static void bfs(int[] position) {
        /* 방문 수, 방문 위치 초기화 */
        int houseCnt = 1;
        visited[position[0]][position[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(position);

        /* 상하좌우 순회 시작 */
        while (!queue.isEmpty()) {
            int[] currPosition = queue.poll();
            int x = currPosition[0];
            int y = currPosition[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (isAvailableRange(nextX, nextY) && houses[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    houseCnt++;
                }
            }
        }
        result.add(houseCnt);
    }

    static boolean isAvailableRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    /* 재귀로도 가능 */
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isAvailableRange(nx, ny) && !visited[nx][ny] && houses[nx][ny] == 1) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }
}
