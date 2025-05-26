package org.example.ne.day13.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 입력: <> k개 나열된 순서열 A
 *   숫자 넣기: 0 ~ 9
 *   2 <= k <= 9
 *
 * 출력: 부등호 만족 정수 중 최댓값, 최솟값
 *
 *
 * ex)
 * 2
 * < >
 * 897
 * 021
 * */
public class B2529_부등호 {
    static boolean[] USED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        USED = new boolean[9];
        int[] resultArr = new int[N + 1];
        Arrays.fill(resultArr, -1);

        int usedIdx = 0;
        int resultIdx = 0;
        /* 감도 못잡는 중 */
        for (int i = 0; i < resultArr.length; i++) {
            if (input[i].equals("<")) {
                int prevNum = resultArr[]
                int min = findMin();
                resultArr[i] = min;
                USED[min] = true;
            }
        }

    }

    static int findMin() {
        for (int i = 0; i < USED.length; i++) {
            if (!USED[i]) {
                return i;
            }
        }
        return -1;
    }

    static int findMax() {
        for (int i = USED.length - 1; i >= 0; i--) {
            if (!USED[i]) {
                return i;
            }
        }
        return -1;
    }
}
