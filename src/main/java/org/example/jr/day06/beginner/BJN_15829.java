package org.example.jr.day06.beginner;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BJN_15829 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        char[] cArr = st.nextToken().toCharArray();
        long sum = 0;

        for(int i=0; i<n; i++){
            int num = cArr[i]-96;
            sum+= (long) (num*Math.pow(31,i));

        }

        System.out.println(sum);

    }



}
