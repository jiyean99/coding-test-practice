package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// HINT: 모든 경우의 수를 담는것은 DFS의 조합인데 무조건 터짐(경우의수 개많아),
// 가방이 일곱개라고 생각해보자 -> 넣었을 때 효용이 최대치가 되는
// 1 2 3 4 5 6 7 짜리 가방들이 있다고 생각해보자
// 1) 6을 넣을까 말까 고민하게 됨
// 1짜리 가방에 6을 넣었을 때 7 효용이 꽉 차게 됨 (1은 0 이니까 7짜리에는 결국 6의 효용인 13 차게 됨)
// 2) 4를 넣을까 말까 고민하게 됨
// 3짜리 가방에 4를 넣었을 때 MAX 효용 + 내 효용(가치) 더하게 되고, 이 때 이전에 담아놓은 효용과 비교해서 더 크면 담음
// dp[i] = max[dp[i], dp[i-x] + v]
// 근데 문제점 발생!!!! 이 때 이전 효용이 안담기고 있다
// 그럼 앞에서부터 채워야할까 뒤에서부터 채워야할까?
// 6을 담으려고할 때, 7만 보면 안되고
// 앞쪽부터 채운다고 생각해보자 : 3을 채우려면 일단 효용이 6이다. 4짜리는 효용이 6, 5짜리에도 6... 근데 6짜리에는 마치 짐이 무한대인것마냥 12가 담기게 됨
// 뒤쪽부터 채운다고 생각해보자: 7을 채우려면 6이 채워지고, 6짜리/5짜리/4짜리에 다 6이 채워지게 됨
// 즉 뒤에서부터 채울 때 는 한번밖에 못쓸때이고, 여러번 쓸 수 있으면 앞에서부터 채워야한다.

public class G12865평범한배낭 {
    public static void main(String[] args) throws IOException {
        // n: 물건의 개수, w: 물건의 무게, v: 가치, k: 배낭 최대무게
        // 배낭에 넣을 수 있는 물건들의 가치합의 최대 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 물건 무게 = 번호
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        int[] dp = new int[k + 1]; // 가방을 k개 만들고, 편의성을 위해 각 가방 번호와 kg이 일치하도록 +1 시켜줌
        for (int i = 0; i < arr.length; i++) {
            // 현재 가방의 효용이 이전 가방의 효용 + 내 효용과 비교했을 때 큰 값으로 세팅
            // 최대 효용무게를 계속해서 갱신해줘야함..............
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        // [0, 0, 0, 0, 0, 0, 13, 13]
        // [0, 0, 0, 0, 8, 8, 13, 13]
        // [0, 0, 0, 6, 8, 8, 13, 14]
        // [0, 0, 0, 6, 8, 12, 13, 14]

        System.out.println(dp[k]);
    }
}
