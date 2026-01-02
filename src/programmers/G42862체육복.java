package programmers;

import java.util.Arrays;

public class G42862체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 5, 3};

        System.out.println(solution(n, lost, reserve));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        // return: 체육수업을 들을 수 있는 학생의 최대값
        // 여벌 체육복이 있는 학생은 이전 학생이 체육복이 없을 경우 하나를 넘겨준다.
        // 이 때 여벌체육복이 있는 학생이 도난당할 시 본인이 먼저 취한다.

        int answer = 0;
        int[] studentByCloth = new int[n];

        Arrays.fill(studentByCloth, 1);

        for (int lostStudent : lost) {
            studentByCloth[lostStudent - 1]--;
        }
        for (int reserveStudent : reserve) {
            studentByCloth[reserveStudent - 1]++;
        }

        for (int i = 0; i < n; i++) {
            // 없는 학생을 기준으로 실행
            if (studentByCloth[i] == 0) {
                // 옷이 2장 이상인 학생은 왼쪽학생이 옷이 0장이면 하나 나눠줌 (왼쪽에서 빌리기)
                if (i > 0 && studentByCloth[i - 1] >= 2) {
                    studentByCloth[i - 1]--;
                    studentByCloth[i]++;
                } else if (i + 1 < n && studentByCloth[i + 1] >= 2) { // 옷이 2장 이상인 학생이 있고, 오른쪽 학생도 옷이 0장이면 하나 나눠줌 (오른쪽에서 빌리기)
                    studentByCloth[i + 1]--;
                    studentByCloth[i]++;
                }
            }
        }

        for (int a : studentByCloth) {
            if (a >= 1) {
                answer++;
            }
        }

        return answer;
    }
}
