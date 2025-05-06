package org.example.ne.day04.middler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class B1260_DFS와BFS {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);


        for (int i = 1; i < N + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (List<Integer> nodeList : graph.values()) {
            Collections.sort(nodeList);
        }

        // dfs
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println(dfsResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        // bfs
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(bfsResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void dfs(int node) {
        visited[node] = true;
        dfsResult.add(node);

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    public static void bfs(int node) {
        visited[node] = true;
        bfsResult.add(node);
        Deque<Integer> dq = new LinkedList<>(graph.get(node));

        while (!dq.isEmpty()) {
            int nextNode = dq.poll();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                bfsResult.add(nextNode);
                dq.addAll(graph.get(nextNode));
            }
        }
    }
}
