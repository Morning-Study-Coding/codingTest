package org.example.jr.day01.beginner;

import java.io.*;
import java.util.*;

public class BJN_11719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        boolean flag = true;

        while(flag){

            String str = br.readLine();
            if(str==null){
                break;
            }

            list.add(str);
            for(char c : str.toCharArray()){
                if(!Character.isLetterOrDigit(c) && c != ' '){
                    list.remove(list.size()-1);
                    flag=false;
                }
            }
        }

        for (String s : list) {
            System.out.println(s);
        }

    }

}

