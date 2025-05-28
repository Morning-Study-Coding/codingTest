package org.example.jr.day15;

import java.io.*;
import java.util.*;

public class BJN_15686 {

    /**
     * 로직
     *    1. 입력 파싱 -> 집 좌표 리스트와 치킨집 좌표 리스트 저장
     *
     *    2. 모든 집과 치킨집 사이의 맨해튼 거리 계산 - 이중 for 순회
     *       int[][] distance = new int[house][chicken];
     *
     *    3. 치킨집 중 M개 고르는 조합 생성 (백트래킹, or combinations)
     *       모든 집에 대해, 선택된 M개의 치킨집 중 최소 거리를 더함
     *       도시 치킨거리로 갱신
     *
     *
     * */

    static int N, M;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static int[][] distance;
    static int minCityDistance = Integer.MAX_VALUE;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value== 1) houses.add(new Point(i, j));
                else if (value == 2) chickens.add(new Point(i, j));
            }
        }

        // 거리 테이블
        int houseCount = houses.size();
        int chickenCount = chickens.size();
        distance = new int[houseCount][chickenCount];

        for (int i = 0; i < houseCount; i++) {
            Point h = houses.get(i);
            for (int j = 0; j < chickenCount; j++) {
                Point c = chickens.get(j);
                distance[i][j] = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
            }
        }

        combination(0, 0, new int[M]);

        System.out.println(minCityDistance);
    }

    static void combination(int depth, int start, int[] selected) {
        if (depth == M) {
            int total = 0;

            for (int i = 0; i < houses.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    min = Math.min(min, distance[i][selected[j]]);
                }
                total += min;
            }

            minCityDistance = Math.min(minCityDistance, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            combination(depth + 1, i + 1, selected);
        }
    }

}
