package org.example.jr.day02.midder;

import java.io.*;
import java.util.*;

public class BJN_11663 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pointCnt = Integer.parseInt(st.nextToken());

        int lineCnt = Integer.parseInt(st.nextToken());
        int[] pointArr = new int[pointCnt];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<pointCnt; i++){
            pointArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pointArr);

        int[] result = new int[lineCnt];

        for(int j=0; j<lineCnt; j++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int startIdx = lowerBound(pointArr,start);
            int endIdx = upperBound(pointArr,end);
            result[j] = endIdx-startIdx;
        }
        Arrays.stream(result).forEach(System.out::println);


    }

    public static int lowerBound(int[] arr, int target){

        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;

            if(target<=arr[mid]){
                right = mid;
            }else{
                left = mid+1;
            }

        }

        return left;
    }

    public static int upperBound(int[] arr, int target){

        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;

            if(target<arr[mid]){
                right = mid;
            }else{
                left = mid+1;
            }

        }
        return left;
    }

}
