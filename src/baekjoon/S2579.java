package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기
public class S2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 초기값
        dp[1] = score[1];
        if (n >= 2) dp[2] = score[1] + score[2];

        // 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + score[i], // i-1 스킵 (2계단)
                    dp[i - 3] + score[i - 1] + score[i] // i-2, i-1, i (1계단씩, 3연속 피함)
            );
        }

        System.out.println(dp[n]);
    }

}
