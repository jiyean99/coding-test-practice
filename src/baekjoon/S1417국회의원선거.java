package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1417국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int myNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.valueOf(br.readLine()));
        }

        int count = 0; // 매수한 사람의 수

        while (!pq.isEmpty() && pq.peek() >= myNum) {
            int temp = pq.peek();
            pq.poll();
            pq.add(temp - 1);
            myNum++;
            count++;
        }

        System.out.println(count);
    }
}
