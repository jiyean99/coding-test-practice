package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//10 20 10 30 20 50
// 1  2  1  3  2  4
// 4 직전은 3이고, 3에다가는 20 달아놓기
// while로 가고, 직전값이 없으면 종료
public class G14002가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int[] arrTemp = new int[n]; // 이전 수열 저장용

        Arrays.fill(dp, 1);
        Arrays.fill(arrTemp, -1);

        // 사이즈 구하기
        int maxSize;
        int maxSizeIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 앞에 애들 중에 나보다 큰 애들이 있으면 어짜피 길이 측정을 고려하는 대상 자체가 안됨
                // 앞 요소에 나보다 작은 애가 있을 때, 나보다 작은애꺼 길이 + 1 vs 기존 저장값 비교
                // 이 때 arrTemp에는 arr 중 나보다 작은 애들의 배열들을 담으면 됨
                // i = 3이라면, dp[]

                //10 20 10 30 20 50
                // 1  2  1  3  2  4
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        arrTemp[i] = j;
                    }
                }
            }
            if (dp[i] > dp[maxSizeIdx]) {
                maxSizeIdx = i;
            }
        }
        maxSize = dp[maxSizeIdx];

        // 수열 구하기
        // i로 끝나는 애들중에 직전 원소의 인덱스가 저장
        // -1일때를 제외하고 list에 순차적으로 담으면 되나?

        List<Integer> maxArrList = new ArrayList<>();
        int idx = maxSizeIdx;

        while (idx != -1) {
            maxArrList.add(arr[idx]);
            idx = arrTemp[idx];
        }
        maxArrList.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxArrList.size(); i++) {
            sb.append(maxArrList.get(i)).append(" ");
        }

        System.out.println(maxSize);
        System.out.println(sb);
    }
}
