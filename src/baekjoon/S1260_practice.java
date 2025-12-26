package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS
public class S1260_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputInfo = new StringTokenizer(br.readLine());
        int node, line, nowNodeIdx;
        node = Integer.parseInt(inputInfo.nextToken());
        line = Integer.parseInt(inputInfo.nextToken());
        nowNodeIdx = Integer.parseInt(inputInfo.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < node + 1; i++) {  // 1~node 인덱스용
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);  // 양방향
            list.get(b).add(a);
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(list.get(i));
        }

        boolean[] visited = new boolean[node + 1];

        dfs(nowNodeIdx, list, visited);
        System.out.println();

        Arrays.fill(visited, false);  // 재사용 시 초기화
        visited[nowNodeIdx] = true;   // 시작점 미리 체크
        bfs(nowNodeIdx, list, visited);

    }

    public static void dfs(int nowNodeIdx, List<List<Integer>> list, boolean[] visited) {
        visited[nowNodeIdx] = true;
        System.out.print(nowNodeIdx + " ");

        for (int i = 0; i < list.get(nowNodeIdx).size(); i++) {
            int nextNodeIdx = list.get(nowNodeIdx).get(i); // 인접 노드 번호
            if (!visited[nextNodeIdx]) {
                dfs(nextNodeIdx, list, visited);
            }
        }
    }

    public static void bfs(int nowNodeIdx, List<List<Integer>> list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nowNodeIdx);
        visited[nowNodeIdx] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < list.get(current).size(); i++) {
                int next = list.get(current).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
