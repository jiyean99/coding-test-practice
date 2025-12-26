package programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 스택/큐 | 프로세스
public class SQ42587 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 중요도
        Queue<Integer> queue = new LinkedList<>(); // 문서 순서(인덱스)
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(i);
        }

        int answer = 0;
        while (!pq.isEmpty()){
            int max_prio = pq.peek();
            if(pq.peek()!=priorities[location]) {
                answer++;
                pq.poll();
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}
