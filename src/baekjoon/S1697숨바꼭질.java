package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO
// 숨바꼭질 https://www.acmicpc.net/problem/1697
public class S1697숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        if (n == k) {
            System.out.println(0);
            return;
        }

        // 간선의 이동 : +1, -1, +2
        // 이 때 큐에는 다음 방문할 위치와 거리를 달고 다닌다.

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        boolean[] visited = new boolean[100000 + 1];

        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int time = temp[1];

            if (x == k) {
                System.out.println(time);
                return;
            }

            int[] next = {x - 1, x + 1, x * 2};
            for (int nx : next) {
                if (nx >= 0 && nx <= 100000) {
                    if (!visited[nx]) {
                        visited[nx] = true;
                        queue.add(new int[]{nx, time + 1});
                    }
                }
            }
        }

    }
}
