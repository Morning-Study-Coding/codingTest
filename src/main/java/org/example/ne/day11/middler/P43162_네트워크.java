package org.example.ne.day11.middler;


import java.util.LinkedList;
import java.util.Queue;

/*
 * 입력
 *  컴퓨터 개수 n (1 <= n <= 200)
 *  연결정보 computers
 *  컴퓨터 i, 컴퓨터 j 연결 -> computers[i][j] = 1, computers[i][i] = 1
 *
 * 로직
 *  방문 체크 배열 -> visited[n]
 *  탐색 -> 끊기면
 *
 * 출력
 *  네트워크의 개수
 * */
public class P43162_네트워크 {
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] != 0 && !visited[j]) {
                    dfs(j, 0, computers, n);
                    answer++;
                }
            }
        }
        return answer;
    }

    static void dfs(int i, int j, int[][] computers, int n) {
        // i번 컴퓨터의 연결정보 j
        if (computers[i][j] != 0 && !visited[j]) {
            visited[j] = true;
            for (int k = 0; k < n; k++) {
                dfs(j, k, computers, n);
            }
        }
    }
}
