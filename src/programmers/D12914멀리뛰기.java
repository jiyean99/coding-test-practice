package programmers;

// 멀리뛰기 (https://school.programmers.co.kr/learn/courses/30/lessons/12914)
public class D12914멀리뛰기 {
    public static void main(String[] args) {
        // n번째 자리의 경우의 수는 n-1번째의 경우의 수와 n-2번째 경우의 수의 합
        int n = 4;
        System.out.println(solution(4));
    }

    static long solution(int n) {
        int[] arr = new int[n + 1];

        if(n == 1)return 1;
        if(n == 2)return 2;

        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i-1] % 1234567 + arr[i-2] % 1234567) % 1234567;
        }
        long answer = arr[n] ;
        return answer;
    }
}
