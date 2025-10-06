package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3) - 시간초과 개선
public class S15651 {
    static int[] selected;
    static int n, m;
    static StringBuilder sb = new StringBuilder();  // 단일 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m];
        backtrack(0);
        System.out.println(sb);  // 한 번만 출력
    }

    public static void backtrack(int depth) {
        if (depth == m) {
            // StringBuilder에 추가만 (println 제거)
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            selected[depth] = i;
            backtrack(depth + 1);
        }
    }
}
