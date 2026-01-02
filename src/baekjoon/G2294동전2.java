package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2294동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 수
        int k = Integer.parseInt(st.nextToken()); // 만들어야하는 값

        // n: 3, k: 15
        // 1 / 5 / 12원짜리 동전이 있을 때
        // k원까지 만들 때 동전의 수를 담는 dp
        // dp = new int[k+1];
        // 1원 : 1(1개), 2원: 1+1(2개), 3원: 1+1+1(3개), 4원: 1+1+1+1(4개), ..., 15원: 14를 만드는 경우 + 1, 10을 만드는 경우 +1, 3을 만드는 경우 +1

        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int max = 100_001;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int c = coin[i];
            for (int j = c; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - c] + 1);
            }
        }

        System.out.println(dp[k] == max ? -1 : dp[k]);
    }
}
