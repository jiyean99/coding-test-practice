package programmers;

import java.util.*;

// 그래프 | 가장 먼 노드 : 프로그래머스 https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class G49189가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static int solution(int n, int[][] edge) {
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int nodeA = edge[i][0];
            int nodeB = edge[i][1];
            adjList.get(nodeA).add(nodeB);
            adjList.get(nodeB).add(nodeA);
        }
        for (List<Integer> list : adjList) {
            list.sort(Comparator.naturalOrder());
        }
        int[] distance = bfs(n);

        int maxDistance = -1;
        int answer = 0;
        for (int a : distance) {
            if (a >= maxDistance) {
                maxDistance = a;
            }
            if(a == answer){
                answer++;
            }
        }

        return answer;
    }

    public static int[] bfs(int start) {
        int[] distance = new int[start + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        distance[1] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : adjList.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    q.add(next);
                }
            }
        }
        return distance;
    }
}
