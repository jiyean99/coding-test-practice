package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2230수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수열의 수
        int m = Integer.parseInt(st.nextToken()); // 차이 기준값

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        int startIdx = 0;

        for (int i = 0; i < n; i++) {
            while (startIdx <= i){
                if(arr[i]- arr[startIdx] < m) break;
                minDiff = Math.min(arr[i] - arr[startIdx], minDiff);
                startIdx++;
            }
        }

        System.out.println(minDiff);
    }
}
