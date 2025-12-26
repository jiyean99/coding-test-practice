package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class H42626 {
    public static void main(String[] args) {
//        int[] scoville, int K
//        int answer = 0;
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        int K = 7; // 원하는 최소 스코빌 지수
        int[] scoville = {1, 2, 3, 9, 10, 12};

        Queue<Integer> pq = new PriorityQueue<>();
        for (int a : scoville) {
            pq.add(a);
        }

        int answer = 0;

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
            }
            if(answer==-1)break;
            int min_s = pq.poll() + (pq.poll() * 2);
            pq.add(min_s);
            answer++;
        }

        System.out.println(answer);
    }
}
