package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2470두용액_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int startIdx = 0;
        int endIdx = n - 1;
        int minValue = Integer.MAX_VALUE;

        int[] temp = new int[2];
        while (startIdx < endIdx) {
            int value = Math.abs(arr[startIdx] + arr[endIdx]);

            if (minValue > value) {
                minValue = value;
                temp[0] = arr[startIdx];
                temp[1] = arr[endIdx];
            }
            if (arr[startIdx] + arr[endIdx] > 0) {
                endIdx--;
            } else {
                startIdx++;
            }
            if (value == 0) break;
        }

        System.out.println(temp[0] + " " + temp[1]);
    }
}
