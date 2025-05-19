package org.example.ne.day08.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B1707_이분_그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] condition = br.readLine().split(" ");
            int V = Integer.parseInt(condition[0]);
            int E = Integer.parseInt(condition[1]);
            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for (int j = 0; j < E; j++) {
                String[] input = br.readLine().split(" ");
                int v1 = Integer.parseInt(input[0]);
                int v2 = Integer.parseInt(input[1]);
                if (setA.contains(v2)) {
                    setA.add(v2);
                    setB.add(v1);
                } else {
                    setA.add(v1);
                    setB.add(v2);
                }
            }
        }
    }
}
