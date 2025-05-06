package org.example.ne.day06.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        BigInteger sum = BigInteger.ZERO;
        BigInteger r = BigInteger.valueOf(31);
        BigInteger divideNum = BigInteger.valueOf(1_234_567_891);

        for (int i = 0; i < input.length; i++) {
            BigInteger toInt = BigInteger.valueOf(input[i] - 'a' + 1);
            BigInteger pow = r.pow(i);
            sum = sum.add(pow.multiply(toInt));
        }
        System.out.println(sum.mod(divideNum));
    }
}
