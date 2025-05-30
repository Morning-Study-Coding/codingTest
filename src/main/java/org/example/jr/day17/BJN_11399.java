package org.example.jr.day17;

import java.io.*;
import java.util.*;

public class BJN_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr =  new int[n];
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int time = 0;
        int sum=0;
        for(int i=0; i<n; i++){
            time+=arr[i];
            sum += time;
        }

        System.out.println(sum);



    }

}
