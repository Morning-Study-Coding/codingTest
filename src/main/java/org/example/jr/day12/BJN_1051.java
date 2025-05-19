package org.example.jr.day12;

import java.util.Scanner;

public class BJN_1051 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int maxArea = 1;

        // 완전탐색: 모든 시작점 (i, j) 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 정사각형 한 변의 길이 size + 1
                for (int size = 1; i + size < N && j + size < M; size++) {
                    // 네 꼭짓점 확인
                    int topLeft = board[i][j];
                    int topRight = board[i][j + size];
                    int bottomLeft = board[i + size][j];
                    int bottomRight = board[i + size][j + size];

                    if (topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
                        int area = (size + 1) * (size + 1);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        System.out.println(maxArea);
    }



}
