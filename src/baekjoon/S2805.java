package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기
public class S2805 {
    public static void main(String[] args) throws IOException {
        // 나무의수 : 4, 가져갈 나무의 길이 : 7m
        // 나무들의 높이
        // 20 15 10 17
        // 10 15 17 20 -> 가장 높은나무 높이의 절반을 잘라서 확인(10)
        // 0 5 7 10 -> 7보다 크다, 또 가장 높은 나무의 절반 높이만큼 잘라서 확인(5)
        // 0 0 2 5 -> 딱 7미터가 찾아짐(이 때 7미터보다 작았다면 낮게 잘라서 다시 탐색)


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 가져갈 나무의 길이

        // m=0 특별 처리 (필요한 높이 0이면 0 출력)
        if (m == 0) {
            System.out.println(0);
            return;
        }

        int[] treeArr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            treeArr[i] = Integer.parseInt(st2.nextToken());
            maxHeight = Math.max(maxHeight, treeArr[i]); // 최대 높이 저장
        }

        int startTree = 0;
        int endTree = maxHeight;
        int answer = 0;
        while (startTree <= endTree) {
            int midHeight = (startTree + endTree) / 2;
            long heightSum = 0;
            for (int height : treeArr) {
                if (height > midHeight) { // mid보다 큰 나무만 계산
                    heightSum += (height - midHeight);
                }
            }
            if (heightSum >= m) {
                answer = midHeight; // 가능한 최대 높이 갱신
                startTree = midHeight + 1; // 더 높게 시도
            } else {
                endTree = midHeight - 1; // 낮게 잘라야 함
            }
        }
        System.out.println(answer);
    }
}
