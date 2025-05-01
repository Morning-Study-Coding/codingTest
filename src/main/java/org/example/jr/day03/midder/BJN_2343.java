package org.example.jr.day03.midder;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJN_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int lesson = Integer.parseInt(st.nextToken());
        int blue = Integer.parseInt(st.nextToken());

        st =  new StringTokenizer(br.readLine());

        int[] arr = new int[lesson];

        for(int i=0; i<lesson; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = Arrays.stream(arr).sum();
        int result = Integer.MAX_VALUE;

        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            int blueCnt = 0;
            int[] blueArr = new int[blue];
            boolean isOver = false;

            for(int i=0; i<lesson; i++){
                if(blueCnt>=blue){
                    isOver = true;
                    break;
                }
                sum+=arr[i];
                if(sum>=mid){
                    if(sum>mid){
                        blueArr[blueCnt] = sum-arr[i];
                        i--;
                    }else{
                        blueArr[blueCnt] = sum;
                    }
                    sum=0;
                    blueCnt++;
                }
                if(i==(lesson-1) && blueCnt<blue){
                    blueArr[blueCnt] = sum;
                }
            }

            if(isOver){
                left = mid+1;
            }else{
                int blueLaySize = Arrays.stream(blueArr).max().getAsInt();
                result = Math.min(blueLaySize,result);
                right = mid-1;

            }

        }

        System.out.println(result);


    }

}
