package org.example.ne.day04.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strList = new ArrayList<>();
        int maxLenght = 0;

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            strList.add(s);
            maxLenght = Math.max(maxLenght, s.length());
        }

        for (int i = 0; i < maxLenght; i++) {
            for (String str : strList) {
                if (i < str.length()) {
                    System.out.print(str.charAt(i));
                }
            }
        }
    }
}
