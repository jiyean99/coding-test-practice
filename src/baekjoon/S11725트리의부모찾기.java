package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 부모찾기 : 백준 https://www.acmicpc.net/problem/11725
public class S11725트리의부모찾기 {
    static int node;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] parent;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        visited = new boolean[node + 1];

        for (int i = 0; i < node + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < node - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            adjList.get(nodeA).add(nodeB);
            adjList.get(nodeB).add(nodeA);
        }
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }

        parent = new int[node + 1];

        dfs(1);

        for (int i = 2; i <= node; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int target : adjList.get(start)) {
            if(!visited[target]){
                visited[target] = true;
                parent[target] = start;
                dfs(target);
            }
        }
    }
}
