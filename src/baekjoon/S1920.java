package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class S1920 {
    public static void main(String[] args) throws IOException {
        // N(1 ≤ N ≤ 100,000), M(1 ≤ M ≤ 100,000)
        // 선형탐색 시 복잡도 약 10억번
        // 이분탐색 시 100~200만번정도
        // 정렬 복잡도 nlog(n) + 이분탐색 복잠도 log(n) * n = 2*n*log(n) (1천만 이하)
        // Set, Map을 써도 되지만 우리는 선형탐색으로 시간초과를 내보고, 이분탐색을 써볼 예정!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] n_arr = new int[n];

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] m_arr = new int[m];

        for (int i = 0; i < n; i++) {
            n_arr[i] = Integer.parseInt(st1.nextToken());
        }
        for (int i = 0; i < m; i++) {
            m_arr[i] = Integer.parseInt(st2.nextToken());
        }
        // TODO 선형탐색 풀이 (시간초과)
//        for (int i = 0; i < m; i++) {
//            boolean isMatch = false;
//            for (int j = 0; j < n; j++) {
//                if (m_arr[i] == n_arr[j]) {
//                    isMatch = true;
//                    break;
//                }
//            }
//            System.out.println(isMatch ? "1" : "0");
//        }

        // TODO 이분탐색 풀이
        Arrays.sort(n_arr); // n*log(n)
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            boolean isMatch = false;
            int target = m_arr[i];
            int target_idx = Arrays.binarySearch(n_arr, target); // m*log(n)
            System.out.println("target: "+ target);
            if (target_idx >= 0) {
                isMatch = true;
            }
            sb.append(isMatch ? "1" : "0");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
