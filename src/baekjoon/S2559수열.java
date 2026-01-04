package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2559수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 측정한 날짜 수
        int k = Integer.parseInt(st.nextToken()); // 연속적인 날짜 수

        int[] dayTemp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dayTemp[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += dayTemp[i];
        }
        maxSum = currentSum;

        for (int i = 1; i <= n - k; i++) {
            currentSum += dayTemp[i + k - 1] - dayTemp[i - 1];
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);

    }
}
