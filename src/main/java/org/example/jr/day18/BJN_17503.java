package org.example.jr.day18;

import java.io.*;
import java.util.*;

public class BJN_17503 {

    public static class Beer implements Comparable<Beer> {
        int like;
        int alcoholLevel;

        public Beer(int like, int alcoholLevel) {
            this.like = like;
            this.alcoholLevel = alcoholLevel;
        }

        @Override
        public int compareTo(Beer beer) {
            // 도수 오름차순, 선호도 오름차순으로 정렬
            if (this.alcoholLevel != beer.alcoholLevel) {
                // 도수
                return Integer.compare(this.alcoholLevel, beer.alcoholLevel);
            }
            // 선호도
            return Integer.compare(this.like, beer.like);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int duration = Integer.parseInt(st.nextToken());
        int targetLike = Integer.parseInt(st.nextToken());
        int beerTypeCnt = Integer.parseInt(st.nextToken());

        List<Beer> beers = new ArrayList<>();

        for (int i = 0; i < beerTypeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int alcohol = Integer.parseInt(st.nextToken());
            beers.add(new Beer(like, alcohol));
        }


        // 도수 오름차순, 선호도 오름차순
        Collections.sort(beers);

        // 선호도 오름차순 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int likeSum = 0;

        for (Beer beer : beers) {
            pq.offer(beer.like);
            likeSum += beer.like;


            if (pq.size() > duration ) {

                likeSum -= pq.poll();
            }


            // 선호도 합 이상
            // 맥주 n개
            if (pq.size() == duration  && likeSum >= targetLike) {
                System.out.println(beer.alcoholLevel);
                return;
            }
        }

        System.out.println(-1);
    }
}
