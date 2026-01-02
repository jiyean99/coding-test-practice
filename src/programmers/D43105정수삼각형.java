package programmers;

public class D43105정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        solution(triangle);
    }

    static int solution(int[][] triangle) {
        int answer = 0;
        // dp : 가장 마지막 열의 크기 + 1 : 맨 마지막 줄을 시작점으로 잡고 거기서부터 시작했을 때 각 지점 별 합을 도출
        int[][] dp = new int[triangle.length][triangle.length]; // 현재 노드 높이, 해당 높이에서의 노드 순서
        for (int i = 0; i < triangle.length; i++) {
            dp[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }

        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }

        answer = dp[0][0];
        return answer;
    }
}
