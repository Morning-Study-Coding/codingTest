package org.example.jr.day01.midder;

import java.util.*;
import java.io.*;

public class BJN_1654{
    /**
     *  int 자료형 범위
     *  -2³¹ ~ 2³¹ - 1
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lanArr = new int[k];


        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            lanArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lanArr);

        long left =1;
        long right = lanArr[k-1];
        long result = 0;

        while(left<=right){
            long mid = (left+right)/2;
            long cnt = 0;

            for(Integer lan: lanArr){
                cnt += (lan/mid);

            }

            if(cnt>=n){
                left = mid+1;
                result = Math.max(result, mid);

            }else{
                right = mid-1;
            }

        }


        System.out.println(result);
    }
}
