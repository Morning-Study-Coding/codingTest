package org.example.jr.day05.beginner;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class BJN_27160 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Map<String,Integer> card = new HashMap<>();


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int cnt = card.getOrDefault(fruit,0);
            card.put(fruit,cnt+(Integer.parseInt(st.nextToken())));
        }
        String result = "";
        for (Entry<String, Integer> entry : card.entrySet()) {
            if(entry.getValue()==5){
                result =  "YES";
                break;
            }
            result = "NO";
        }

        System.out.println(result);


    }

}
