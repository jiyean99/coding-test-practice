package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10 20 10 30 20 50
// dfs로 풀어도 되지 않을까?
// 10에서 20 크네? 담아 -> 30 크네? 담아 -> ... ->
// 근데 이 때 20을 담아버렸는데 11, 12, 13, ... 이 있다면? 담거나/안담거나로 경우의 수 분기를 너무 많이 해줘야함
// 위 로직의 복잡도는 2^n이 되므로 어마어마하게 큼! (n^2랑은 차원이 다른 미친놈임, 거의 무한대)

// 그렇다면 DP를 떠올리게 되는 논리흐름을 봐보면, 50자리에서 최대길이가 얼마일까?를 먼저 생각해보는거임
// 이전의 값들 중 나보다 작은 애들게 있고, 그 중의 가장 긴 수열길이에 내 자리(+1)만 추가하면 그게 최대길이가 됨
// 10의 최대길이는 1, 20은 최대길이 2(20앞에 나보다 작은 값이 있고, 거기에 +1한 것), 10은 1(나보다 작은값이 X), 30은 3(나보다 작은값이 20으로 있고, 거기에 +1), 20은 2, ...
// 결국 위 로직의 복잡도는 n^2이 됨(bfs에 비해 복잡도 향상)
public class S11053가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int maxArrSize = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxArrSize = Math.max(maxArrSize, dp[i]);
        }

        System.out.println(maxArrSize);
    }
}
