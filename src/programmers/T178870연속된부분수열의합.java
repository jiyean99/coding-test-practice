package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T178870연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(solution(sequence, k));
    }

    static int[] solution(int[] sequence, int k) {
        int startIdx = 0;
        int endIdx = 0;
        int sum = sequence[startIdx];

        List<int[]> list = new ArrayList<>();

        while (startIdx <= endIdx && endIdx < sequence.length) {
            if (sum == k) {
                list.add(new int[]{startIdx, endIdx});
                sum -= sequence[startIdx];
                startIdx++;
            } else if (sum > k) { // 수열의 합이 k보다 클 때
                sum -= sequence[startIdx]; // 우선 시작인덱스의 값만큼 빼주고
                startIdx++; // 시작인덱스를 늘려준다
                if (startIdx > endIdx) { // 시작인덱스가 끝인덱스를 역전해버릴 경우
                    endIdx++; // 일단 끝인덱스를 더함
                    if (sequence.length == endIdx) break; // 당연히 끝인덱스가 길이 초과하면 종료
                    sum += sequence[endIdx];
                }
            } else if (sum < k) { // 수열의 합이 k보다 작을 때
                endIdx++; // 우선 끝인덱스를 늘려주고
                if (sequence.length == endIdx) break;// 이 때 끝인덱스가 길이 초과하면 종료
                sum += sequence[endIdx]; // 늘려준값을 추가해준다.
            }
        }

        int[] answer = new int[2];
        int arrMinLength = Integer.MAX_VALUE;

        for (int[] a : list) {
            int arrLength = a[1] - a[0] + 1;
            if (arrMinLength > arrLength) {
                arrMinLength = arrLength;
                answer = a;
                System.out.println(Arrays.toString(a));
            }
        }


        return answer;
    }
}
