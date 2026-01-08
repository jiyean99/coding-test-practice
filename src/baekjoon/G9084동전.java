package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G9084동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 동전 종류 수

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N]; // 동전 종류 배열
            for (int j = 0; j < coins.length; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int value = Integer.parseInt(br.readLine()); // 목표 금액

            int[] dp = new int[value + 1]; // 해당 금액에서 동전의 최대 수
            // dp[value] = value에서의 동전의 최대 수를 list에 담고, 각 리스트를 순회하여 사이즈를 출력하면 되나?
            dp[0] = 1;

            for (int j = 0; j < N; j++) {
                int coin = coins[j];
                if (coin <= value){
                    for (int k = coin; k < dp.length; k++) {
                        dp[k] = dp[j];
                    }
                }
            }

            System.out.println(dp[value]);
        }
    }
}
