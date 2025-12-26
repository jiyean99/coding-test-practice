package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 프린터 큐
public class S1966 {
    public static void main(String[] args) throws IOException {
        // t : 테스트케이스 수
        // n : 문서의 개수
        // M : 문서의 위치(index)

        // TODO
        //  1. 문서를 뽑는다.
        //  2. 문서의 중요도를 확인한다.
        //  3. 남은 큐의 중요도를 확인한다.(남은 큐의 크기만큼)
        //  4. 중요도가 높은것이 있다면 큐의 뒤에 넣어주고, 아니라면 출력한다.
        //  사전 환경 : 큐에 중요도를 따로 저장
        //  위치값을 큐에 넣어줌
        // 1 1 9 1 1 1 : 문서의 중요도 배열 (큐)
        // 0 1 2 3 4 5 : 위치값을 넣은 배열 (큐)(중요도를 참조)

        // 1 1 9 1 1 1 : false
        // 0 1 2 3 4 5

        // 1 9 1 1 1 1 : false
        // 1 2 3 4 5 0

        // 9 1 1 1 1 1 : false
        // 2 3 4 5 1 0
        // count +1

        // 1 1 1 1 1
        // 3 4 5 1 0
        // count +1

        // 1 1 1 1
        // 4 5 1 0
        // count +1

        // 1 1 1
        // 5 1 0
        // count +1

        // 1 1
        // 1 0
        // count +1

        // 1
        // 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<int[]> dq = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dq.offer(new int[]{Integer.parseInt(st.nextToken()), j});
            }

            int count = 0;
            while (!dq.isEmpty()) {
                int[] now = dq.pollFirst();

                boolean isPrint = true;
                int size = dq.size();
                for (int j = 0; j < size; j++) {
                    int[] check = dq.pollFirst();
                    if (check[0] > now[0]) {
                        isPrint = false;
                    }
                    dq.offerLast(check);
                }

                if (isPrint) {
                    count++;
                    if (now[1] == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    dq.offerLast(now);
                }
            }
        }
    }
}
