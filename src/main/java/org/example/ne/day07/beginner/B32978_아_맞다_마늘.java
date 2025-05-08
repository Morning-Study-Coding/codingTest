package org.example.ne.day07.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B32978_아_맞다_마늘 {
    public static void main(String[] args) throws IOException {
        app1();
    }

    static void app1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ingredients = br.readLine().split(" ");
        String[] usedIngredients = br.readLine().split(" ");

        Arrays.sort(ingredients);
        Arrays.sort(usedIngredients);

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.println(ingredients[i]);
            }

            if (!ingredients[i].equals(usedIngredients[i])) {
                System.out.println(ingredients[i]);
                break;
            }
        }
    }

    static void app2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ingredients = br.readLine().split(" ");
        String[] usedIngredients = br.readLine().split(" ");

        Arrays.sort(usedIngredients);

        for (String original : ingredients) {
            if (Arrays.binarySearch(usedIngredients, original) < 0) {
                System.out.println(original);
                break;
            }
        }
    }

    static void app3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ingredients = br.readLine().split(" ");
        String[] usedIngredients = br.readLine().split(" ");

        Map<String, Boolean> cookingMap = new HashMap<>();

        for (String used : usedIngredients) {
            cookingMap.put(used, false);
        }

        for (String original : ingredients) {
            if (cookingMap.get(original) == null) {
                System.out.println(original);
                break;
            }
        }
    }

    static void app4() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ingredients = br.readLine().split(" ");
        String[] usedIngredients = br.readLine().split(" ");
        Arrays.sort(ingredients);
        boolean[] used = new boolean[N];

        for (String usedIngredient : usedIngredients) {
            int idx = Arrays.binarySearch(ingredients, usedIngredient);
            used[idx] = true;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                System.out.println(ingredients[i]);
                break;
            }
        }
    }
}
