package org.example.jr.day13;

import java.util.*;
import java.io.*;

public class BJN_2529 {

    /**
     *
     * 입력
     * 9
     * > < < < > > > < <
     *
     * 로직
     *  백트랙킹 (1~9)
     *  부등호 조건에 따라 다음 숫자 지정
     *  사용여부 업데이트 -> 초기화
     *
     * */
    static int depth;
    static List<String> result= new ArrayList<>();
    static boolean[] used = new boolean[10];
    static char[] sign;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        depth = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        sign=new char[depth];
        for (int i = 0; i < depth; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            used[i] = true;
            dfs(1, i, String.valueOf(i));
            used[i] = false;
        }

        String min = Collections.min(result);
        String max = Collections.max(result);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int n,int num, String nums){
        if(n==depth+1){
            result.add(nums);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                if ((sign[n - 1] == '<' && num < i) || (sign[n - 1] == '>' && num > i)) {
                    used[i] = true;
                    StringBuilder sb = new StringBuilder(nums).append(i);
                    dfs(n + 1, i, String.valueOf(sb));
                    used[i] = false;
                }
            }
        }
    }
}
