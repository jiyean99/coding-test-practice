package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기
public class S1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n+1];
        for(int i = 2; i <= n; i++) {
            isPrime[i] = true;  // 2~n은 처음에 소수로 가정
        }
        isPrime[0] = isPrime[1] = false;  // 0,1은 소수 아님

        for (int i = 2; i * i <= n; i++) {  // i*i <= n 까지만
            if (isPrime[i]) {  // i가 소수면
                for (int j = i*i; j <= n; j += i) {  // i의 배수 제거
                    isPrime[j] = false;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
