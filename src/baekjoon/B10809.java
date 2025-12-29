package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳 찾기
public class B10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(s.indexOf(c)).append(' ');
        }

        System.out.println(sb.toString());
    }
}
