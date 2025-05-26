package org.example.ne.day13.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
 *
 * 패인 : 앞에서 채워나가는 방식으로는 정답 누락, 부등호 조건 처리 어려움 등이 있음
 *
 * 로직: 완전탐색
 *  1) 첫번째 자리를 지정해서 재귀 시작
 *  2) 부등호를 확인하면서 0~9까지 사용되지 않은 것 탐색
 *  3) 부등호 식에 부합하지 않으면 이전 단계로 돌아가서 탐색
 *  4) 가능한 결과값 중 가장 작은 값과 큰 값 리턴
 * */
public class B2529_부등호 {
    static String[] SIGNS;
    static boolean[] USED;
    static List<String> RESULTS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SIGNS = br.readLine().split(" ");
        USED = new boolean[10];

        /* 시작 숫자 고정, 재귀 탐색 */
        int signIdx = 0;
        for (int i = 0; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            USED[i] = true;
            dfs(i, signIdx, sb);
            USED[i] = false;
        }

        System.out.println(RESULTS.get(RESULTS.size() - 1));
        System.out.println(RESULTS.get(0));
    }

    static void dfs(int prev, int signIdx, StringBuilder sb) {
        /* 종료 조건 - 부등호 배열 끝 도달 */
        if (signIdx == SIGNS.length) {
            RESULTS.add(sb.toString());
            return;
        }

        String sign = SIGNS[signIdx];
        for (int i = 0; i < USED.length; i++) {
            if (!USED[i] && ((sign.equals("<") && prev < i) || (sign.equals(">") && prev > i))) {
                USED[i] = true;
                sb.append(i);
                dfs(i, signIdx + 1, sb);

                /* 재귀에서 돌아왔을 때 재탐색 여지 남김 */
                USED[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
