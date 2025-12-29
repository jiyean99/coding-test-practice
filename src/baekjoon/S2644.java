package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 촌수계산
public class S2644 {
    static int node;
    static int line;
    static int nodeA;
    static int nodeB;

    static List<List<Integer>> adjList = new ArrayList<>();

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeA = Integer.parseInt(st.nextToken());
        nodeB = Integer.parseInt(st.nextToken());

        line = Integer.parseInt(br.readLine());

        for (int i = 0; i < node + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(input.nextToken());
            int right = Integer.parseInt(input.nextToken());

            adjList.get(left).add(right);
            adjList.get(right).add(left);
        }
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }

        visited = new boolean[node + 1];
        bfs(nodeA, nodeB);
    }

    static void bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        int distance = -1;

        loop:
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int a : adjList.get(temp[0])) {
                if (!visited[a]) {
                    visited[a] = true;
                    q.add(new int[]{a, temp[1] + 1});
                    if (a == target){
                        distance = temp[1] + 1;
                        break loop;
                    }
                }
            }

        }
        System.out.println(distance);
    }
}
