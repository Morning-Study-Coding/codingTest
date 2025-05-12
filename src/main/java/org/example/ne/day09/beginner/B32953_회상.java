package org.example.ne.day09.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B32953_회상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int classCnt = Integer.parseInt(input[0]);
        int studentCheckCnt = Integer.parseInt(input[1]);
        Map<String, Integer> studentClassMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < classCnt; i++) {
            int studentCnt = Integer.parseInt(br.readLine());
            String[] students = br.readLine().split(" ");
            for (String student : students) {
                studentClassMap.put(student, studentClassMap.getOrDefault(student, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> studentInfo : studentClassMap.entrySet()) {
            if (studentInfo.getValue() >= studentCheckCnt) result++;
        }

        System.out.println(result);
    }
}
