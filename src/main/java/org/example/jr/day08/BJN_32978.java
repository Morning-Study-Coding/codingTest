package org.example.jr.day08;

import java.io.*;
import java.util.*;

public class BJN_32978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());

        Set<String> ingredients = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<cnt; i++){
            ingredients.add(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());

        for(int i=0; i<cnt-1; i++){
            ingredients.remove(st.nextToken());
        }

        for(String notUsed: ingredients){
            System.out.print(notUsed);
        }



    }

}
