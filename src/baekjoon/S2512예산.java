package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2512예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시수(지방수)

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n]; // 도시(지방)별 예산 요청

        int maxByCity = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxByCity < arr[i]) {
                maxByCity = arr[i];
            }
        }

        Arrays.sort(arr);

        int limit = Integer.parseInt(br.readLine()); // 총예산

        int startIdx = 1;
        int endIdx = maxByCity;

        int answer = 0;
        while (startIdx <= endIdx) {
            int mid = (startIdx + endIdx) / 2;
            // mid값이 정해질 때 마다, 예산총액과 비교해줘야함
            // 금액은 for문을 통해 구해야하고, 이 금액을 예산총액과 비교해야함
            // mid값은 상한금액, 상한금액으로 총예산값을 구한뒤 총예산값과 예산상한을 비교한다

            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                total += (Math.min(mid, arr[i]));
            }

            if (total > limit) {
                endIdx = mid - 1;
            } else if (total < limit) {
                startIdx = mid + 1;
                answer = mid;
            } else {
                answer = mid;
                break;
            }
        }

        System.out.println(answer);

    }
}
