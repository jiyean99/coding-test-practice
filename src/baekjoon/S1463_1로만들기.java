package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        // 연산횟수의 최소값 출력
        // 3으로 나누어 떨어지면 나누기 3, 2로 나누어 떨어지면 나누기 2, 그 외 빼기 1
        // n = 3a + 2b + 1c

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 10 -> /3(X), /2(O) = 5
        // 5 -> /3(X), /2(X), -1 = 4
        // 4 -> /3(X), /2(O) = 2
        // 2 -> /3(X), /2(O) = 1
        // count = 4

        // dp[n] : n을 만드는 데 필요한 최소 연산 횟수
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
