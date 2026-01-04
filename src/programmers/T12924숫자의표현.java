package programmers;

public class T12924숫자의표현 {
    public static void main(String[] args) {
        int n = 15;

        System.out.println(solution(n));
    }

    static int solution(int n) {
        int answer = 0;

        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while (endIdx <= n) {
            if (sum == n) {
                answer++;
                sum -= startIdx;
                startIdx++;
            } else if (sum < n) {
                endIdx++;
                sum += endIdx;
            } else {
                sum -= startIdx;
                startIdx++;
            }
        }

        return answer;
    }
}
