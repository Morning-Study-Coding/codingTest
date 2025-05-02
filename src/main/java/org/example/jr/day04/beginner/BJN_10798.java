package org.example.jr.day04.beginner;

import java.io.*;
import java.util.*;

public class BJN_10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        String[][] grid = new String[5][15];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], "-");
        }

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            char[] chars = st.nextToken().toCharArray();
            int j =0;
            for(char c :  chars){
                grid[i][j] = String.valueOf(c);
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<15; i++){
            for(int j=0; j<5; j++){

                if(grid[j][i].equals("-")){
                    continue;
                }
                sb.append(grid[j][i]);

            }
        }

        System.out.print(sb);

    }

}
