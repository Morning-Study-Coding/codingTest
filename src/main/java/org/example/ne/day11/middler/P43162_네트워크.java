package org.example.ne.day11.middler;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

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
        int[][] computers = {
                // 0  1  2  3  4  5  6
                {1, 1, 0, 0, 0, 0, 0}, // 0
                {1, 1, 1, 0, 0, 0, 0}, // 1
                {0, 1, 1, 0, 0, 0, 0}, // 2
                {0, 0, 0, 1, 1, 0, 0}, // 3
                {0, 0, 0, 1, 1, 1, 0}, // 4
                {0, 0, 0, 0, 1, 1, 0}, // 5
                {0, 0, 0, 0, 0, 0, 1}  // 6 → 혼자 떨어져 있음
        };
//        int[][] computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution3(7, computers));
    }

    /* DFS 방식 */
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        /* 각 컴퓨터 순회 */
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int i, int[][] computers, int n) {
        visited[i] = true;
        /* 연결된 컴퓨터 탐색 */
        for (int j = 0; j < n; j++) {
            if (computers[i][j] != 0 && !visited[j]) {
                dfs(j, computers, n);
            }
        }
    }

    /* dfs */
    public static int solution2(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    private static void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int j = 0; j < computers.length; j++) {
                if (computers[current][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    /* Union-Find 방식 */
    /*
     *   1. 부모 노드를 저장해둔다.
     *   2. 연결 여부 확인해서 부모 노드 업데이트
     * */
    static int[] parents;   // 부모 노드 정보

    public static int solution3(int n, int[][] computers) {
        parents = IntStream.range(0, n).toArray();
        System.out.println("초기 parents: " + Arrays.toString(parents));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) {
                answer++;
            }
        }
        return answer;
    }

    static void union(int i, int j) {
        int ip = findParents(i);    // i의 부모 노드
        int jp = findParents(j);    // j의 부모 노드
        System.out.printf("union(%d, %d) → root(%d), root(%d)\n", i, j, ip, jp);

        if (ip != jp) {
            parents[jp] = ip;       // j의 부모노드의 부모노드를 변경함
            System.out.println("병합 후 parents: " + Arrays.toString(parents));
        }
    }

    /* 부모 노드 찾기 */
    static int findParents(int i) {
        System.out.printf("find(%d): ", i);
        if (parents[i] != i) {
            int original = parents[i];
            parents[i] = findParents(parents[i]);
            System.out.printf("parents[%d] (%d → %d)\n", i, original, parents[i]);
        } else {
            System.out.printf("자기 자신이 루트 (%d)\n", i);
        }
        return parents[i];
    }
}
