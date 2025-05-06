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
        BigInteger sum = new BigInteger("0");

        for(int i=0; i<n; i++){
            int num = cArr[i]-96;
            sum = sum.add(BigInteger.valueOf(31).pow(i).multiply(BigInteger.valueOf(num)));

        }

        System.out.println(sum);

    }



}
