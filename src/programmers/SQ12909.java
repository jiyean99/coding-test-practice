package programmers;

import java.util.Stack;

// 스택/큐 | 올바른 괄호
public class SQ12909 {
    public static void main(String[] args) {
        String s = "(()(";
        boolean answer = true;

        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                st.add(ch[i]);
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }
        if (!st.isEmpty()) {
            answer = false;
        }
        System.out.println(answer);
    }
}
