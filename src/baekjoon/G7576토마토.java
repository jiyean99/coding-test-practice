package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G7576토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();

        int[][] box = new int[N][M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[j][i] = Integer.parseInt(st.nextToken());
                if (box[j][i] == 1) {
                    q.add(new int[]{j, i});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(box[nx][ny] == 0){
                        box[nx][ny] = box[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

        }

        // 결과 계산: 0 남아있으면 -1, 아니면 최대값-1
        int max = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[j][i] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[j][i]);
            }
        }

        System.out.println(max - 1);
    }
}
