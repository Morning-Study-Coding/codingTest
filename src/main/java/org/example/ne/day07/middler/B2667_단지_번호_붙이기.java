package org.example.ne.day07.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2667_단지_번호_붙이기 {
    /* 단지가 끊긴 건 어떻게 알지 */
    /* BFS는 큐, visited가 핵심이다 */
    static int[][] houses;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(input[j]);
            }
        }
//        System.out.println(Arrays.deepToString(houses));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (houses[i][j] != 0) {
                    bfs();
                }
            }
        }


    }

    static void bfs () {

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];
            if (houses[x][y] == 0) {

            }
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int[] nextPos = {x + dx[i], y + dy[i]};
                int nextPosX = nextPos[0];
                int nextPosY = nextPos[1];
                if (nextPosX >= 0 && nextPosY >= 0 && houses[nextPosX][nextPosY] != 0 && !visited[nextPosX][nextPosY]) {
                    queue.add(new int[]{nextPosX, nextPosY});
                }
            }
        }
    }
}
