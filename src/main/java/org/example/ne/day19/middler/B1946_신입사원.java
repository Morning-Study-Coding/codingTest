package org.example.ne.day19.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B1946_신입사원 {
    // 서류/면접 중 적어도 하나는 누군가보다 나아야 함. -> 앞선 것들과 비교
    // 이렇게 뽑을 수 있는 최대 인원 수?
    static class Recruit {
        int resume, interview;

        public Recruit(int resume, int interview) {
            this.resume = resume;
            this.interview = interview;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            int people = Integer.parseInt(br.readLine());
            List<Recruit> recruits = new ArrayList<>();
            for (int j = 0; j < people; j++) {
                String[] data = br.readLine().split(" ");
                recruits.add(new Recruit(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
            }

            recruits.sort(Comparator.comparingInt(o -> o.resume));
            int minInterviewRank = recruits.get(0).interview;
            int cnt = 1;
            for (int j = 1; j < people; j++) {
                int interviewRank = recruits.get(j).interview;
                if (minInterviewRank < interviewRank) continue;
                cnt++;
                minInterviewRank = interviewRank;
            }
            System.out.println(cnt);
        }
    }
}
