package org.example.jr.day07.begginer;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class BJN_31562 {


    //4 4
    //11 TwinkleStar C C G G A A G
    //8 Marigold E D E F E E D
    //23 DoYouWannaBuildASnowMan C C C G C E D
    //12 Cprogramming C C C C C C C
    //E D E
    //C G G
    //C C C
    //C C G


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, String> saved = new LinkedHashMap<>();

        int saveSongCnt = Integer.parseInt(st.nextToken());

        int tryCnt = Integer.parseInt(st.nextToken());

        Map<String,Integer> cntMap = new LinkedHashMap<>();

        for(int i=0; i<saveSongCnt; i++){
            st = new StringTokenizer(br.readLine());
            int songNum = Integer.parseInt(st.nextToken());
            String songName = st.nextToken();
            String code = st.nextToken().substring(0,2);

            saved.put(songName,code);

        }

        for(int i=0; i<tryCnt; i++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j<3; j++){
                sb.append(st.nextToken());

            }

            for(Entry<String, String> s : saved.entrySet()){
                int sCnt = cntMap.getOrDefault(s.getValue(),0);
                cntMap.put(s.getKey(),sCnt+1);
            }

        }

        for(Entry<String, Integer> r : cntMap.entrySet()){


        }



    }

}
