package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2667단지번호붙이기_DFS {
    static int[][] map;
    static int n;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    sizes.add(bfs(i, j));
                }
            }
        }

        Collections.sort(sizes);
        System.out.println(sizes.size());
        for (int a : sizes) {
            System.out.println(a);
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        map[x][y] = 0; // 방문처리
        int count = 1; // 현재 집

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int xTemp = current[0];
            int yTemp = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = xTemp + dx[i];
                int ny = yTemp + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0; // 방문처리
                        q.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
