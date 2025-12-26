package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (!dq.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                dq.addLast(dq.removeFirst());
            }

            result.append(dq.removeFirst());

            if (!dq.isEmpty()) {
                result.append(", ");
            }
        }

        result.append(">");
        System.out.println(result);
    }
}
