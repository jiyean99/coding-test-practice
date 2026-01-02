package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class D138477명예의전당 {
    public static void main(String[] args) {
        // 명예의 전당 : 프로그래머스
        // https://school.programmers.co.kr/learn/courses/30/lessons/138477
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution138477(k, score)));

    }


    // TODO pq를 쓰는게 왜 유리한지(복잡도 측면에서) 생각해보아라
    // 명예의 전당
    public static int[] solution138477(int k, int[] score) {
        // 명예의 전당 인원 수 : k
        // 일수 : score.length
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (pq.size() > k) {
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }

}

