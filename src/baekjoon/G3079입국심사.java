package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3079입국심사 {
    public static void main(String[] args) throws IOException {
        // n: 심사대 수 ,m : 심사를 받는 인원
        // 각 심사대별 소요시간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(times);

        long start = 1;
        long end = (long)m * times[times.length - 1]; // 입국심사 총 시간이 가장 긴 경우

        long min = end;
        while (start <= end) {
            long mid = (start + end) / 2;
            long totalPeople = 0;
            for (int time : times) {
                totalPeople += mid / time;
                if (totalPeople >= m) break;
            }

            if (totalPeople >= m) {
                min = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(min);
    }
}
