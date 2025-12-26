import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
