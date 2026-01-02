package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 숫자판 점프
// set을 쓰면 됨, 방문 체크 할 필요 X
public class S2210숫자판점프 {
    static Set<String> caseSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String spot = String.valueOf(grid[i][j]);
                dfs(grid, new int[]{i, j}, 0, spot);
            }
        }
        System.out.println(caseSet.size());
    }

    static void dfs(int[][] grid, int[] current, int depth, String spot) {
        if (depth == 5) {
            caseSet.add(spot);
            return;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nx = current[0] + dx[k];
            int ny = current[1] + dy[k];
            if (nx >= 0 && ny >= 0 && nx < grid[0].length && ny < grid[1].length) {
                dfs(grid, new int[]{nx, ny}, depth + 1,  spot + grid[nx][ny]);
            }
        }
    }
}
