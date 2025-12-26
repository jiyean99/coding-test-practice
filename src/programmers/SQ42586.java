package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

// 스택/큐 | 기능개발
public class SQ42586 {
    public static void main(String[] args) {
        // 기능a, 기능b, 기능c ...
        // output : 각 배포마다 몇번의 기능이 배포되는 지
        int[] progresses = {93, 30, 55}; // 작업의 우선순위
        int[] speeds = {1, 30, 5}; // 각 작업의 속도(%)

        Deque<Integer> p_q = new ArrayDeque<>();

        for(int i = 0; i < progresses.length; i++){
            double value = (double)(100 - progresses[i]) /  speeds[i];
            p_q.add((int) Math.ceil(value));
        }
        // temp에 첫번째 요소 담음 -> 뒤에 값이랑 비교하고, 작으면 poll & count++ 크면 temp값 변경&&count 1 리스트에 add -> 그 다음꺼랑 또 비교

        System.out.println(p_q);
    }
}
