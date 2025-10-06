package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// N과 M (3)
public class S15651_timeover {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        // numList = 1부터 n까지가 담긴 리스트
        // m = 조합의 개수
        // depth = ??
        // temp = 조합을 담을 리스트
        // resultList = 최종 리스트

        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            numList.add(i);
        }

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(m, 0, numList, temp, resultList);

        for (List<Integer> list : resultList) {
            StringBuilder sb = new StringBuilder();
            for (int value : list) {
                sb.append(value).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static void backtrack(int m, int depth, List<Integer> numList, List<Integer> temp, List<List<Integer>> resultList) {
        if (depth == m) {
            resultList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            temp.add(numList.get(i));
            backtrack(m, depth + 1, numList, temp, resultList);
            temp.remove(temp.size() - 1);
        }
    }
}
