package org.example.ne.day18.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * N일동안 축제
 * k종류의 맥주
 * 1인당 1병, 이전 종류는 안됨
 *
 * 선호도 / 도수 레벨
 * 선호도 합이 M 이상 되도록
 *
 * 간 레벨의 최소값은?
 * */
public class B17503_맥주축제 {
    static class Beer {
        public int favor, alcohol;

        public Beer(int favor, int alcohol) {
            this.favor = favor;
            this.alcohol = alcohol;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);  // 축제 기간
        int M = Integer.parseInt(data[1]);  // 채워야 하는 선호도
        int K = Integer.parseInt(data[2]);  // 맥주 종류(갯수)

        List<Beer> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            String[] beerStr = br.readLine().split(" ");
            beers.add(new Beer(Integer.parseInt(beerStr[0]), Integer.parseInt(beerStr[1])));
        }
        beers.sort(Comparator.comparing(beer -> beer.alcohol));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Beer beer : beers) {
            M -= beer.favor;
            pq.add(beer.favor);
            if (pq.size() == N) {
                if (M > 0) {
                    Integer q = pq.poll();
                    M += q == null ? 0 : q;
                } else {
                    System.out.println(beer.alcohol);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
