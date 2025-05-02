package org.example.ne.day04.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2470_두_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[2];
        int N = Integer.parseInt(br.readLine());
        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int leftIdx = 0;
        int rightIdx = liquids.length - 1;
        int min = Integer.MAX_VALUE;

        while (leftIdx < rightIdx) {
            int sum = liquids[leftIdx] + liquids[rightIdx];
            int abs = Math.abs(sum);
            if (abs < min) {
                min = abs;
                result[0] = liquids[leftIdx];
                result[1] = liquids[rightIdx];
            }

            if (sum < 0) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
