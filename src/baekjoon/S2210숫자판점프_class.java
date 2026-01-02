package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 숫자판 점프 - 강사님 풀이
// set을 쓰면 됨, 방문 체크 할 필요 X
public class S2210숫자판점프_class {
    static Set<String> caseSet = new HashSet<>();
    static int[][] grid = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String temp = String.valueOf(grid[i][j]);
                dfs(i, j, "");
            }
        }

        System.out.println(caseSet.size());
    }

    static void dfs(int x, int y, String temp) {
        if (temp.length() == 6) {
            caseSet.add(temp);
            return;
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, temp + grid[x][y]);
            }
        }
    }
}
