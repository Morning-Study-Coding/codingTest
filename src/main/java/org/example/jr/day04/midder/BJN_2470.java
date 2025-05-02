package org.example.jr.day04.midder;

import java.io.*;
import java.util.*;

public class BJN_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int min = Integer.MAX_VALUE;

        int liquid1 = 0;
        int liquid2 = 0;

        while(left<right){

            int mixed = arr[left]+arr[right];

            if(Math.abs(mixed)<min){
                liquid1 = arr[left];
                liquid2 = arr[right];
                if(mixed==0){
                    break;
                }
                min = Math.abs(mixed);

            }

            if(mixed>=0){
                right -=1;

            }else{
                left +=1;
            }
        }


        System.out.print(liquid1+" "+liquid2);

    }

}
