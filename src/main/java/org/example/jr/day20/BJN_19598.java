package org.example.jr.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJN_19598 {
    /**
     *
     *
     * 로직
     *    회의 종료시간 < 시작시간 -> 재사용
     *    회의 종료시간 > 시작시간 -> 회의실 추가
     *
     *    1. 우선순위 : 회의 시작시각 오름차순 -> 리스트
     *    2. 우선순위 : 회의 종료시각 오름차순 -> 우선순위 큐
     *
     * */

    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        // 시작 시간 오름차순 정렬
        Collections.sort(meetings);

        // 회의실 종료 시간 우선순위 큐
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for (Meeting m : meetings) {
            if (!room.isEmpty() && room.peek() <= m.start) {
                room.poll(); // 회의실 재사용
            }
            room.offer(m.end); //회의실 추가
        }

        System.out.println(room.size());
    }
}
