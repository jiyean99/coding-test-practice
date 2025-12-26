package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 괄호
public class S9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // t : 테스트 케이스 수
        int t = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < t; i++) {
            char[] chArr = br.readLine().toCharArray();
            for (int j = 0; j < chArr.length; j++) {
                if (chArr[j] == '(') {
                    stack.add(chArr[j]);
                } else {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else{
                            stack.add(')');
                        }
                    }
                }
            }
            System.out.println(dq);
        }
    }
}
