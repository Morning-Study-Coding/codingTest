package org.example.jr.day03.beginner;

import java.io.*;
import java.util.*;

public class BJN_11945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n==0){
            return;
        }

        int[][] result = new int[n][m];
        for(int i=0; i<n;i++){

            char[] nums = br.readLine().toCharArray();

            for(int j=0; j<m; j++){
                result[i][m-1-j] = nums[j]-'0';

            }

        }

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }



    }

}
