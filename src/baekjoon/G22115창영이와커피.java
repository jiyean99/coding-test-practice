package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G22115창영이와커피 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 커피의 개수
        int K = Integer.parseInt(st.nextToken()); // 섭취해야하는 카페인 양
        // 최소 몇개의 커피를 섭취해야하는가?

        int[] caffeineArr = new int[N]; // 커피별 카페인 모음 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            caffeineArr[i] = Integer.parseInt(st.nextToken());
        }

        int minCaffein = 100 * 1000;
        // dp[j] = 카페인 합을 정확히 j로 만들 때 필요한 최소 커피 개수 (불가능하면 최대 경우의 수)
        int[] dp = new int[K + 1];
        Arrays.fill(dp, minCaffein);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            // 우선 커피 수 만큼 순회 -> 목적 :
            int caffein = caffeineArr[i]; // 개별 카페인
            for (int j = K; j >= caffein; j--) {
                // 현재 커피(caffein)를 고려할 때,
                // - 안 마시면: dp[j] 그대로
                // - 마시면: 직전 합이 (j - c)여야 하므로 dp[j - c]에서 커피 1개를 추가 → dp[j - c] + 1
                // 두 경우 중 최소를 택한다.
                // j를 큰 값부터 내려오게 도는 이유: 같은 커피를 한 번만 쓰는(0/1) 상태를 유지하기 위해서
                dp[j] = Math.min(dp[j], dp[j - caffein] + 1);
            }
        }

        System.out.println(dp[K] >= minCaffein ? -1 : dp[K]);
    }
}
