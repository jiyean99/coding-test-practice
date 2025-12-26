package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 올바른 괄호
public class G24552 {
    public static void main(String[] args) throws IOException {
        // String[] s =
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ch = str.toCharArray();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < ch.length; i++) {
            st.add(String.valueOf(ch[i]));
        }

        int count = 0;
        while (!st.isEmpty()) {
            // 마지막 데이터가 ) 일 때
            // 그 전 데이터가 (라면 +1, )라면 마지막데이터만 pop
            // 이 때 스택에는 2 이상이 있을 때만 수행함
            st.pop();
            if (st.peek().equals("(")) {
                st.pop();
                count++;
            }
        }

        System.out.println(count);
    }
}
