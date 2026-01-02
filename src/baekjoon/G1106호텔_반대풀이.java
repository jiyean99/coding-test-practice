package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1106호텔_반대풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 유치해야하는 인원수
        int n = Integer.parseInt(st.nextToken()); // 도시수

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            arr[i][0] = c2; // 도시 유치 가격
            arr[i][1] = c1; // 도시 유치시 고객수
        }
        int max = c + 100; // 유치해야하는 인원수 + 100(도시 유치시 고객수 최대) : ??
        int[] dp = new int[max + 1];
        int INF = 1000000;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j <= max; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i][0]] + arr[i][1]);
            }
        }
        int rs = INF;
        for (int i = c; i <= max; i++) {
            rs = Math.min(rs, dp[i]);
        }
        System.out.println(rs);
    }
}
