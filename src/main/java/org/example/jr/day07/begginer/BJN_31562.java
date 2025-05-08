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

        Map<String, String> savedByName = new LinkedHashMap<>();
        Map<String, String> savedByCode = new LinkedHashMap<>();

        int saveSongCnt = Integer.parseInt(st.nextToken());

        int tryCnt = Integer.parseInt(st.nextToken());


        for(int i=0; i<saveSongCnt; i++){
            st = new StringTokenizer(br.readLine());
            int songNum = Integer.parseInt(st.nextToken());
            String songName = st.nextToken();

            StringBuilder code = new StringBuilder();

            for(int j=0; j<7; j++){

                code.append(st.nextToken());
            }

            savedByName.put(songName,String.valueOf(code));
            savedByCode.put(String.valueOf(code),songName);

        }

        List<String> codeList = new ArrayList<>();

        for(int i=0; i<tryCnt; i++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j<3; j++){
                sb.append(st.nextToken());

            }
            codeList.add(String.valueOf(sb));

        }

        for(int i=0; i<codeList.size(); i++){
            int cnt = 0;
            String songName = null;
            for(Entry<String, String> song: savedByName.entrySet()){
                if(song.getValue().substring(0,3).equals(codeList.get(i))){
                    cnt++;
                    songName = savedByCode.get(song.getValue());
                }

            }

            if(cnt>=2){
                System.out.println("?");
            }else if(cnt==1){
                System.out.println(songName);
            }else{
                System.out.println("!");
            }

        }



    }

}
