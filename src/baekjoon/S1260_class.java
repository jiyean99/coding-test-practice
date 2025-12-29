package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS
public class S1260_class {
    static int n;
    static int m;
    static int v;

    static List<List<Integer>> adjList;

    static boolean[] visited;


    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수
        n = Integer.parseInt(st.nextToken());
        // 간선 개수
        m = Integer.parseInt(st.nextToken());
        // 시작정점 번호
        v = Integer.parseInt(st.nextToken());

        // 1. 인접리스트 생성(0번노드는 없지만 그냥 나중에 get할 때 편의성을 위해 0부터 노드갯수+1만큼 깡통으로 만들어준다)
        adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // 2. 각 노드별 인접노드들을 인접리스트에 담아줌
        for (int i = 0; i < m; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(input.nextToken());
            int nodeB = Integer.parseInt(input.nextToken());
            adjList.get(nodeA).add(nodeB);
            adjList.get(nodeB).add(nodeA);
        }

        // 3. 인접리스의 내부 리스트 오름차순 정렬
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }

        // 4. 노드별 방문여부 확인 배열 생성
        visited = new boolean[n + 1];

        dfs(v);
        System.out.println(dfsSb);

        // bfs를 위한 방문여부 확인 배열 초기화
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(bfsSb);
    }


    static void dfs(int start) {
        dfsSb.append(start).append(" ");
        visited[start] = true;
        for (int target : adjList.get(start)) {
            if (!visited[target]) {
                dfs(target);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int target = queue.poll();
            bfsSb.append(target).append(" ");
            for(int a : adjList.get(target)){
                if(!visited[a]){
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}