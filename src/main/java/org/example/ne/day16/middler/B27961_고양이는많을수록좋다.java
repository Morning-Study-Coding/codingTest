package org.example.ne.day16.middler;

import java.awt.font.ImageGraphicAttribute;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 생성 / 복제(0이상 k이하) 마법 중 하나 사용
 * 고양이 수는 0이상 10 12승 이하
 *
 * */
public class B27961_고양이는많을수록좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long sum = 0;
        long cnt = 0;
        while (sum != N) {
            long diff = N - sum;
            long newMagic = sum + 1;
            long maxPlusMagic = sum + sum;
            long plusMagic = sum + (N - sum);

            // 한마리 더한 값 or 0 이상 sum 이하 추가
            if (N - newMagic < N - maxPlusMagic) {
                sum = newMagic;
            } else if (diff > sum) {
                sum = maxPlusMagic;
            } else {
                sum = plusMagic;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
