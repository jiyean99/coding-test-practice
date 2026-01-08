package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2606바이러스 {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        adjList = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (List<Integer> a : adjList) {
            a.sort(Comparator.naturalOrder());
        }

        visited = new boolean[n + 1];
        dfs(1);

        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int next : adjList[start]) {
            if (!visited[next]){
                count++;
                dfs(next);
            }
        }

    }
}
