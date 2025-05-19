package org.example.ne.day12.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 입력: NXM크기의 정사각형
 *   0 < N, M <= 50
 * 로직: 꼭짓점에 쓰여 잇는 수가 모두 같은 가장 큰 '정사각형' 찾기
 *   1. 꼭짓점이 0이 아닌 경우 같은 숫자 찾으면 탐색
 * 출력: 정답 정사각형의 크기
 * */
public class B1051_숫자_정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < nums.length; j++) {
                grid[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int maxSize = 1;

        /* 그리드 전체 탐색 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int maxPossibleSize = Math.min(N - i, M - j);
                for (int size = maxSize; size < maxPossibleSize; size++) {
                    int target = grid[i][j];
                    int topRight = grid[i][j + size];
                    int bottomLeft = grid[i + size][j];
                    int bottomRight = grid[i + size][j + size];
                    if (topRight == target && bottomLeft == target && bottomRight == target) {
                        maxSize = size + 1;
                    }
                }
            }
        }
        System.out.println(maxSize * maxSize);
    }
}
