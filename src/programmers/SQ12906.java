package programmers;

import java.util.Arrays;
import java.util.Stack;

// 스택/큐 | 같은 숫자는 싫어
public class SQ12906 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
//        int[] solution = {1,3,0,1};

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(st.isEmpty() || st.peek()!=arr[i]){
                st.add(arr[i]);
            }
        }

        int[] answer = new int[st.size()];
        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }

        System.out.println(answer);
    }
}
