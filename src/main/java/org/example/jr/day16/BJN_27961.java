package org.example.jr.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJN_27961 {
    // 목표 고양이 수를 만족 하는 최소 횟수 구하기
    // n = 고양이 수

    // 방법1 : 생성(단 한마리)
    // 방법2 : 복제(최대 전체 고양이 수)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //목표 고양이 마리수
        long n = Long.parseLong(st.nextToken());

        if(n==0){
            System.out.println(0);
            return;
        }
        // 생성 횟수
        long nowCnt = 1L;

        // 복제 횟수
        int copyCnt = 0;


        while(nowCnt<n){
            nowCnt*=2;
            copyCnt++;
        }

        System.out.print(copyCnt+1);
    }

}
