package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기 - 이분탐색(이진탐색) 풀이
public class S1920_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(nArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = mArr[i];
            int start = 0;
            int end = n - 1;
            boolean isExist = false;
            // 정렬된 배열의 중간값과 target 비교
            while (start <= end) {
                int mid = (start + end) / 2;

                if (nArr[mid] == target) {
                    isExist = true;
                    break;
                } else if (nArr[mid] > target) { // 중간값이 더 크면 왼쪽으로 탐색
                    end = mid - 1;
                } else { // 중간값이 더 작으면 오른쪽으로 탐색
                    start = mid + 1;
                }
            }

            sb.append(isExist ? 1 : 0).append('\n');
        }

        System.out.print(sb.toString());
    }
}
