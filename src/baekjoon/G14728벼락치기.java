package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G14728벼락치기 {
    public static void main(String[] args) throws IOException {
        // n: 단원 개수, t:시험까지 공부 가능 시간
        // k: 예상공부시간, s: 단원 배점
        // 준석이가 얻을 수 있는 최대 점수 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] timeWithScore = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeWithScore[i][0] = Integer.parseInt(st.nextToken());
            timeWithScore[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1시간공부, 2시간공부, ... k시간 공부 배열을 만든다
        // 이 때 k시간에는 현재 공부한 효율(점수)랑 이전에 공부한 효율 중 뭐가 더 효율이 좋은지 따진 후 해당 값은 담으면 최대 효율을 알 수 있다.
        int[] dp = new int[t + 1];
        for (int i = 0; i < timeWithScore.length; i++) {
            int time = timeWithScore[i][0];
            int score = timeWithScore[i][1];
            for (int j = t; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j-time] + score);
            }
        }

        System.out.println(dp[t]);

    }
}
