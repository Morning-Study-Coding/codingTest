package org.example.jr.day18;


import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class BJN_17503_Binary {
    /**
     *
     * 맥주 축제
     *
     * 1. 입력
     *      축제 기간(N), 목표 선호도(L), 맥주 종류(K)
     *
     *      선호도, 도수
     *
     *
     * 2. 로직
     *      우선순위큐 1) 도수낮은것 2) 선호도 높은것
     *
     * 3. 출력
     *     마신 맥주의 도수최소
     *
     * */

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int date = Integer.parseInt(st.nextToken());
        int like = Integer.parseInt(st.nextToken());
        int beerTypeCnt = Integer.parseInt(st.nextToken());

        int[][] beers = new int[beerTypeCnt][2];


        for (int i=0; i<beerTypeCnt; i++)   {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken());
            beers[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(beers, Comparator.comparingInt(a -> a[1]));

        int[] alcohols = Arrays.stream(beers).mapToInt(e ->e[1]).toArray();
        int left = alcohols[0];
        int right = alcohols[beerTypeCnt-1];

        int minAlcohol = -1;


        while(left<=right){
            int mid = (left+right)/2;

            int likeSum = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();


            for(int i=0; i<beerTypeCnt; i++){
                if(beers[i][1]>mid)  break;
                pq.add(beers[i][0]);
                likeSum+=beers[i][0];

                if(pq.size()>date){
                    likeSum -= pq.poll();
                }
            }



            if(likeSum>=like && pq.size()==date){
                minAlcohol = mid;
                right = mid-1;

            }else{
                left = mid+1;

            }

        }

        System.out.println(minAlcohol);


    }

}

