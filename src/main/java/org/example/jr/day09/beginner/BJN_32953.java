package org.example.jr.day09.beginner;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class BJN_32953 {

    /**
     * 3 2
     * 3
     * 12500001 12500002 12500003
     * 5
     * 12500001 12500003 12500005 12500007 12500009
     * 4
     * 12500001 12500004 12500007 12500010
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tryCnt = Integer.parseInt(st.nextToken());
        int duCnt = Integer.parseInt(st.nextToken());

        Map<String, Integer> lesson = new HashMap<>();

        for(int i=0; i<tryCnt; i++){
            st = new StringTokenizer(br.readLine());
            int studentCnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<studentCnt; j++){
                String studentNum = st.nextToken();
                lesson.put(studentNum,lesson.getOrDefault(studentNum,0)+1);
            }
        }

        int result=0;
        for (Entry<String, Integer> less : lesson.entrySet()) {
            if(less.getValue()>=duCnt){
                result++;
            }
        }
        System.out.println(result);

    }

}
