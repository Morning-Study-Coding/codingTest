package org.example.ne.day10.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 입력
 *   MXN 크기 보드판
 *
 * 로직
 *   전체 순회하면서 색칠해야 하는 정사각형 찾기
 *   최소로 포함하는 값 찾기
 *   길찾기나 연결성 문제 아니라서 DFS/BFS 아님
 *  1. 구간 탐색
 *      for (int i=0;i<=N;i++) {
 *          for (int j=0;j<=M-8;j++) {
 *
 *  2. 첫 색상 별 색칠 필요 여부 탐색
 *
 * 출력
 *  칠해야하는 정사각형의 최소 개수
 *
 * */
public class B1018_체스판_다시_칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        /* 보드 구성 */
        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = data[j];
            }
        }

        /* 8*8 탐색 - 시작 색상이 W일때, B일때 */
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt = Math.min(getCnt(i, j, board, "W"), getCnt(i, j, board, "B"));
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }

    private static int getCnt(int i, int j, String[][] board, String startColor) {
        int cnt = 0;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if ((k + l) % 2 == 0) {
                    cnt = board[k][l].equals(startColor) ? cnt : cnt + 1;
                }else {
                    cnt = !board[k][l].equals(startColor) ? cnt : cnt + 1;
                }
            }
        }
        return cnt;
    }
}
