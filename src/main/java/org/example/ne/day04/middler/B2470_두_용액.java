package org.example.ne.day04.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2470_두_용액 {
    /*
     * 산성용액: 1~10억 양의 정수
     * 알칼리성 용액: -1~ -10억 음의 정수
     * 같은 양의 용액 혼합 특성값: 각 합
     * 0에 가까운 특성값을 가진 용액 만들려고 함
     * ---
     * 출력은 오름차순
     * 두 경우가 있다면 아무거나 1개
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[2];
        int N = Integer.parseInt(br.readLine());
        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int leftIdx = 0;
        int rightIdx = liquids.length - 1;
        long min = Long.MAX_VALUE;

        long prevSum = Math.abs(liquids[leftIdx] + liquids[rightIdx]);
        while (leftIdx >= 0 && rightIdx < liquids.length && leftIdx < rightIdx) {
            long sum = Math.abs(liquids[leftIdx] + liquids[rightIdx]);
            if (sum < min) {
                min = sum;
                leftIdx++;
                result[0] = liquids[leftIdx];
                result[1] = liquids[rightIdx];
            } else {
                rightIdx--;
            }
        }
        System.out.println(result[0] + " " + result[1]);

    }
}
