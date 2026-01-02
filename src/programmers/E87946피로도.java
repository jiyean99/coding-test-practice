package programmers;

// TODO
// 완전탐색 | 피로도 https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class E87946피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        solution(k, dungeons);
        System.out.println(solution(k, dungeons));
    }

    static int answer = 0;
    static boolean[] visited;

    static int solution(int k, int[][] dungeons) {
        // answer: 최대 던전 수
        // k: 현재 피로도
        // dungeons: {최소필요 피로도, 소모 피로도}
        // 최소필요 피로도와 현재 피로도를 비교 후 현재 피로도가 더 크면 소모피로도를 차감 후 던전 수를 ++ 한다.
        // 이 때 이차원 배열의 던전을 돌 수 있는 방법을 순열로 구하면 됨
        visited = new boolean[dungeons.length];
        backtrack(k, dungeons, 0);

        return answer;
    }

    static void backtrack(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k >= dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}
