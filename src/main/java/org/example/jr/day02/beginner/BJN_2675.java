package org.example.jr.day02.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJN_2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] result = new String[n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            int duCnt = Integer.parseInt(s.split(" ")[0]);
            char[] cArr = s.split(" ")[1].toCharArray();

            StringBuilder sb = new StringBuilder();
            for(char c: cArr){
                for(int j=0; j<duCnt; j++){
                    sb.append(c);
                }
                result[i] = sb.toString();
            }
        }

        Arrays.stream(result).forEach(System.out::println);

    }
}
