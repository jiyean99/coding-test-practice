package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G7569토마토 {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로(x)
        N = Integer.parseInt(st.nextToken()); // 세로(y)
        H = Integer.parseInt(st.nextToken()); // 높이(z)

        box = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                    if (box[z][y][x] == 1) q.add(new int[]{z, y, x}); // 멀티 시작점
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], y = cur[1], x = cur[2];

            for (int dir = 0; dir < 6; dir++) {
                int nz = z + dz[dir];
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (box[nz][ny][nx] != 0) continue;

                box[nz][ny][nx] = box[z][y][x] + 1;
                q.add(new int[]{nz, ny, nx});
            }
        }

        int max = 1;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 0) { // 끝까지 안 익음
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, box[z][y][x]);
                }
            }
        }

        System.out.println(max - 1);
    }
}
