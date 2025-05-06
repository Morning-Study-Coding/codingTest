package org.example.jr.day06.midder;

import java.io.*;
import java.util.*;
public class BJN_1697{

    static final int MAX = 100000;

    static boolean[] visited;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int sibling = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];
        time = new int[MAX+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        visited[subin] = true;

        bfs(queue);

        System.out.println(time[sibling]);



    }
    public static void bfs(Queue<Integer> queue){
        while (!queue.isEmpty()) {
            int now = queue.poll();

            int[] move = new int[]{now + 1,now-1,now*2};

            for (int next : move) {
                if (next >= 0 && next < MAX+1 && !visited[next]) {
                    visited[next] = true;
                    time[next] = time[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
