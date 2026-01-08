package baekjoon;

import java.io.*;
import java.util.*;

public class S24480알고리즘수업깊이우선탐색2 {
    static int N, M, R;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            adjList.get(i).sort(Collections.reverseOrder());
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n'); // 방문 못한 정점은 기본값 0
        }
        System.out.print(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        order[cur] = cnt++;

        for (int nxt : adjList.get(cur)) {
            if (!visited[nxt]) {
                dfs(nxt);
            }
        }
    }
}
