package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP
public class S1149RGB거리_gh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int colorNum = 3;
        int total = 0;

        int[][] dp = new int[N][colorNum];

        int[] colors = new int[colorNum];
        String[] arr = br.readLine().split(" ");
        for(int i=0; i<colorNum; i++){
            colors[i] = Integer.parseInt(arr[i]);
        }
        dp[0][0] = colors[0];
        dp[0][1] = colors[1];
        dp[0][2] = colors[2];

        for(int i=1; i<N; i++){
            colors = new int[colorNum];
            arr = br.readLine().split(" ");

            for(int j=0; j<colorNum; j++){
                colors[j] = Integer.parseInt(arr[j]);
                dp[i][j] += Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + colors[j];
            }
        }
        total = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
        System.out.println(total);
    }
}