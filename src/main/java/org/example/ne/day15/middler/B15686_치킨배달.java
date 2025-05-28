package org.example.ne.day15.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * N*N 도시, r행 c열
 * r. c >= 1
 * 각 칸은 빈 칸 0 / 치킨집 1 / 집 2
 *
 * 두 칸 사이 거리는 r1 - r2 + c1 - c2
 * 치킨 거리: 집과 가장 가까운 치킨집과의 거리
 *
 * 치킨 거리(각 집에서 가장 가까운 치킨집 거리의 합)가 가장 적게 되는 M개 구하기
 *
 * */
public class B15686_치킨배달 {
    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static int[][] chickenMap;
    static int N, M;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 치킨집, 집 별도 저장 -> 조합 탐색 위함
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String val = st.nextToken();
                if (val.equals("1")) houses.add(new Point(i, j));
                if (val.equals("2")) chickens.add(new Point(i, j));
            }
        }

        chickenMap = new int[houses.size()][chickens.size()];
        for (int i = 0; i < houses.size(); i++) {
            for (int j = 0; j < chickens.size(); j++) {
                chickenMap[i][j] = Math.abs(houses.get(i).x - chickens.get(j).x) + Math.abs(houses.get(i).y - chickens.get(j).y);
            }
        }

        selectChickens(0, new int[M], 0);
        System.out.println(minDist);
    }

    static void selectChickens(int startIdx, int[] selectedIdx, int cnt) {
        if (cnt == M) {
            System.out.println(Arrays.toString(selectedIdx));
            int sum = 0;
            for (int[] h : chickenMap) {
                int min = Integer.MAX_VALUE;
                for (int c : selectedIdx) {
                    min = Math.min(min, h[c]);
                }
                sum += min;
            }
            minDist = Math.min(minDist, sum);
            return;
        }

        for (int i = startIdx; i < chickens.size(); i++) {
            selectedIdx[cnt] = i;
            selectChickens(i + 1, selectedIdx, cnt + 1);
        }
    }
}
