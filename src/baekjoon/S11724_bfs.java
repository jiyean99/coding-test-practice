package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연결요소의 개수 - bfs 풀이
public class S11724_bfs {
    // 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
    // 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v)
    // 같은 간선은 한 번만 주어진다.

    static int node;
    static int line;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    static int count = 0;

    // 연결 요소의 개수를 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        for (int i = 0; i < node + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            StringTokenizer nodes = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(nodes.nextToken());
            int nodeB = Integer.parseInt(nodes.nextToken());

            adjList.get(nodeA).add(nodeB);
            adjList.get(nodeB).add(nodeA);
        }
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }

        visited = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            if (!visited[i]) {
                count++;
                bfs(i);
            }
        }
        System.out.println(count);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int target= queue.poll();
            for (int a : adjList.get(target)){
                if(!visited[a]){
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}