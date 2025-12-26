package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 최대공약수와 최소공배수
public class B2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sb = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sb.nextToken());
        int m = Integer.parseInt(sb.nextToken());
        int nAnswer = 1; // 최대공약수
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                nAnswer = i;
            }
        }

        int mAnswer = 1;
        for (int i = 0; i < Math.min(n, m); i++) {
            mAnswer = (n / nAnswer) * m;
        }
        System.out.println(nAnswer);
        System.out.println(mAnswer);
    }
}
