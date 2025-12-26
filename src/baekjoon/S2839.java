package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 설탕 배달
public class S2839 {
    public static void main(String[] args) throws IOException {
        // n : 배달해야하는 설탕 킬로그램
        // 봉지는 3키로짜리랑 5키로짜리가 있음
        // 출력 : 봉지가 몇개 필요한지 계산 (정확하게 계산 불가하면 -1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 3; i <= n; i++) {
            if (i >= 3 && dp[i - 3] != -1) {
                // 조건1: i >= 3 (3kg 봉지 사용 가능)
                // 조건2: dp[i-3] != -1 ((i-3) 무게를 채울 방법 존재)
                dp[i] = dp[i - 3] + 1; // 3kg 방식 저장
            }
            if (i >= 5 && dp[i - 5] != -1) {
                // 조건1: i >= 5 (5kg 봉지 사용 가능)
                // 조건2: dp[i-5] != -1 ((i-5) 무게를 채울 방법 존재)
                if (dp[i] == -1) { // 아직 방법 없음
                    dp[i] = dp[i - 5] + 1; // 5kg 방식 저장
                } else { // 3kg 방식 이미 있음
                    dp[i] = Math.min(dp[i], dp[i - 5] + 1); // 둘 중 작은 값
                }
            }
        }

        System.out.println(dp[n]);

    }
}
