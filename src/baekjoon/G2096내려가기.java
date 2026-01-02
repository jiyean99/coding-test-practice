package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2096내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 이전 줄의 최대/최소 DP
        int[] prevMax = new int[3];
        int[] prevMin = new int[3];

        // 첫 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        prevMax[0] = prevMin[0] = Integer.parseInt(st.nextToken());
        prevMax[1] = prevMin[1] = Integer.parseInt(st.nextToken());
        prevMax[2] = prevMin[2] = Integer.parseInt(st.nextToken());

        // 2번째 줄부터 갱신
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] curMax = new int[3];
            int[] curMin = new int[3];

            // max 갱신
            curMax[0] = Math.max(prevMax[0], prevMax[1]) + a;
            curMax[1] = Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2])) + b;
            curMax[2] = Math.max(prevMax[1], prevMax[2]) + c;

            // min 갱신
            curMin[0] = Math.min(prevMin[0], prevMin[1]) + a;
            curMin[1] = Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2])) + b;
            curMin[2] = Math.min(prevMin[1], prevMin[2]) + c;

            // 다음 줄을 위해 갱신
            prevMax = curMax;
            prevMin = curMin;
        }

        int maxScore = Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
        int minScore = Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));

        System.out.println(maxScore + " " + minScore);
    }
}
