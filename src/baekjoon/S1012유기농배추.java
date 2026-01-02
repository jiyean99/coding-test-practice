package baekjoon;

import java.io.*;
import java.util.*;

public class S1012유기농배추 {
    static int m, n, k;
    static int[][] grid;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            grid = new int[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[x][y] = 1;
            }

            int worms = 0;

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (grid[x][y] == 1) { // 배추가 있고(아직 미방문)
                        worms++; // 새 덩어리 발견 → 지렁이 1마리 추가
                        dfs(x, y); // 연결된 배추들을 전부 방문 처리
                    }
                }
            }

            System.out.println(worms);
        }
    }

    static void dfs(int x, int y) {
        grid[x][y] = 0; // 방문 처리(배추 제거)

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (grid[nx][ny] == 1) dfs(nx, ny);
            }
        }
    }
}
