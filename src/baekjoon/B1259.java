package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팰린드롬수
public class B1259 {
    public static void main(String[] args) throws IOException {
        // 팰린드롬 : 앞에서 읽으나 뒤에서 읽으나 같은 문자열
        // ex) radar, sees 등
        // 팰린드롬수 : 숫자로 구성된 팰린드롬
        // ex) 1991, 252 등

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            boolean isPalindrome;
            int len = input.length();

            if (len % 2 == 0) {  // 문자열 길이가 짝수일 때
                String left = input.substring(0, len / 2);
                String right = input.substring(len / 2);
                String reversedLeft = new StringBuilder(left).reverse().toString();

                isPalindrome = reversedLeft.equals(right);
            } else {  // 문자열 길이가 홀수일 때
                String left = input.substring(0, len / 2);
                String right = input.substring(len / 2 + 1);
                String reversedLeft = new StringBuilder(left).reverse().toString();

                isPalindrome = reversedLeft.equals(right);
            }

            System.out.println(isPalindrome ? "yes" : "no");
        }
    }
}
