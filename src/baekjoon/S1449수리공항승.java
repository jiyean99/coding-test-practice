package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1449수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 구멍 수
        int l = Integer.parseInt(st.nextToken()); // 테이프 길이


        int[] spotArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            spotArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(spotArr);

        int count = 0;
        int i = 0;

        // 구멍 위치를 정렬해두고, 왼쪽(가장 작은 위치)부터 순서대로 처리한다.
        // 현재 구멍을 테이프 시작점(startSpot)으로 잡고,
        // 그 테이프로 덮을 수 있는 범위(coverEnd) 안에 들어오는 다음 구멍들은 계속 넘어간다(스킵).
        // 다음 구멍이 coverEnd를 넘는 순간, 새 테이프가 필요하므로 count를 1 증가시키고
        // 그 구멍을 새로운 startSpot으로 갱신해서 같은 과정을 반복한다.
        // 모든 구멍을 처리(i가 끝까지 감)하면 종료한다.

        while (i < n) {
            int startSpot = spotArr[i];
            int coverEnd = startSpot + l - 1;

            count++;
            i++;

            while (i < n && spotArr[i] <= coverEnd) {
                i++;
            }
        }
        System.out.println(count);

    }

}
