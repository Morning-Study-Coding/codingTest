package org.example.jr.day19;

import java.io.*;
import java.util.*;

public class BJN_1946 {

    static class Applicant implements Comparable<Applicant> {
        int document;
        int interview;

        public Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Applicant other) {
            return this.document - other.document; // 서류 성적 기준 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Applicant> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                pq.add(new Applicant(doc, interview));
            }

            int count = 0;
            int bestInterview = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                Applicant current = pq.poll();

                if (current.interview < bestInterview) {
                    count++;
                    bestInterview = current.interview;
                }
            }

            System.out.println(count);
        }
    }
}
