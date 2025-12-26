package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이는 올라가고 싶다
public class B2869 {
    public static void main(String[] args) throws IOException {
        // 낮에A미터 올라가고, 밤에 B미터 미끄러짐
        // 정상에 올라가면 미끄러지지 않음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int day = (v - b + a - b - 1) / (a - b);
        System.out.println(day);
    }
}
