package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G22115창영이와커피_다시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 커피의 개수
        int K = Integer.parseInt(st.nextToken()); // 섭취해야하는 카페인 양

        int[] caffeiens = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < caffeiens.length; i++) {
            caffeiens[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1]; // 해당 카페인만큼 섭취 시 최소 커피잔수를 출력하는 dp
        int maxCaffeiens = 1000 * 100;
        Arrays.fill(dp, maxCaffeiens);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int caffeien = caffeiens[i];
            if (caffeien <= K) {
                for (int j = K; j >= caffeien; j--) {
                    dp[j]= Math.min(dp[j], dp[j-caffeien] + 1);
                }
            }
        }

        if (dp[K] > maxCaffeiens) {
            maxCaffeiens = dp[K];
        } else {
            maxCaffeiens = -1;
        }

        System.out.println(maxCaffeiens);


    }
}
