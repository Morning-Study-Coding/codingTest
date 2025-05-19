package org.example.jr.day11;

public class P_Network {

    public static void main(String[] args) {
        int result = solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(result);

    }


        static int[] parents;

        public static int solution(int n, int[][] computers) {
            int answer = 0;

            parents = new int[n];
            for (int i = 0; i < n ; i++) parents[i] = i;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (computers[i][j] == 1) {
                        union(i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (parents[i] == i) answer++;
            }

            return answer;
        }



        public static void union(int from, int to){

            int px = find(from);
            int py = find(to);

            if (px != py) {
                parents[py] = px;
            }

        }

        public static int find(int x){
            if(parents[x]!=x){
                parents[x] = find(parents[x]);
            }
            return parents[x];

        }


}
