package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Hashing
public class B15829 {
    public static void main(String[] args) throws IOException {
        // r과 m은 서로소인 숫자로 정해야함
        // r : 26보다 큰 소수인 31
        // m : 1234567891
        // l : 문자열의 길이
        // str : 영문 소문자로만 이루어진 문자열
        // 위 해시함수 입력으로 계산된 해시값 정수로 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());  // 문자열 길이
        String str = br.readLine();               // 문자열 입력

        final long r = 31;
        final long M = 1234567891;
        long h = 0;
        long pow = 1;  // 31^0 = 1

        for(int i = 0; i < L; i++) {
            int a_i = str.charAt(i) - 'a' + 1;  // a→1, b→2, ...
            h = (h + a_i * pow) % M;            // 누적 + 나머지
            pow = (pow * r) % M;                // 다음 거듭제곱
        }

        System.out.println(h);

    }
}
