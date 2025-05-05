package org.example.ne.day04.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B27160_할리갈리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> cards = new HashMap<>();
        String result = "NO";
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int count = Integer.parseInt(input[1]);

            int sum = cards.getOrDefault(name, 0) + count;
            cards.put(name, sum);
        }
        for (int value : cards.values()) {
            if (value == 5){
                result = "YES";
                break;
            }
        }
        System.out.println(result);
    }
}
