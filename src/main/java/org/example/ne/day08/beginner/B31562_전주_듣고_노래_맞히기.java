package org.example.ne.day08.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 정환이 알고있는 노래제목, 음이름으로 데이터를 만든다.
 * 첫 세 음으로 맞춰야됨.
 * */
public class B31562_전주_듣고_노래_맞히기 {
    public static void main(String[] args) throws IOException {
        String duplicated = "?";
        String none = "!";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int songDataCnt = Integer.parseInt(condition[0]);
        int songQuestionCnt = Integer.parseInt(condition[1]);
        Map<String, String> songData = new HashMap<>();

        for (int i = 0; i < songDataCnt; i++) {
            String[] input = br.readLine().split(" ");
            String title = input[1];
            String notes = input[2] + input[3] + input[4];
            songData.put(title, notes);
        }

        for (int i = 0; i < songQuestionCnt; i++) {
            String question = br.readLine().replace(" ", "");
            String result = "";

            for (Map.Entry<String, String> note : songData.entrySet()) {
                if (note.getValue().equals(question)) {
                    result = result.isEmpty() ? note.getKey() : duplicated;
                }
            }
            System.out.println(result.isEmpty() ? none : result);
        }
    }
}
