package baekjoon;

import java.io.*;
import java.util.*;

// 공유기 설치
// TODO 다시 풀어보기
public class G2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집 수
        int c = Integer.parseInt(st.nextToken()); // 공유기 수

        int[] addressArr = new int[n];
        for (int i = 0; i < n; i++) {
            int address = Integer.parseInt(br.readLine()); // 집 번지
            addressArr[i] = address;
        }
        Arrays.sort(addressArr);
        System.out.println(Arrays.toString(addressArr));
        int left = 1; // 최소거리 하한 (1)
        int right = addressArr[n - 1] - addressArr[0]; // 최대거리 상한
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;  // 최소거리 후보

            // mid 거리로 공유기 몇 개 설치 가능한지 확인
            int count = getCount(addressArr, mid);  // 설치 가능한 공유기 수

            if (count >= c) { // c개 이상 설치 가능
                answer = mid; // 가능한 최대 거리 갱신
                left = mid + 1; // 더 큰 거리 시도
            } else {
                right = mid - 1; // 거리 줄여야 함
            }
        }
        System.out.println(answer);
    }

    // mid 거리로 공유기 몇 개 설치 가능한지 계산
    static int getCount(int[] arr, int dist) {
        int count = 1; // 첫번째 집에 설치
        int last = arr[0]; // 마지막 설치 위치

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) { // dist 이상 떨어졌으면 설치
                count++;
                last = arr[i];
            }
        }
        return count;
    }
}
