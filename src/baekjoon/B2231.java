package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분해합
public class B2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int length = String.valueOf(n).length();

        int start = n - length * 9;
        if (start < 1) start = 1;

        int answer = 0;

        for (int i = start; i < n; i++) {
            int sum = i;
            int tmp = i;

            // i의 각 자리수 더하기
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
