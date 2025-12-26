package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// N과 M (4)
public class S15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1부터 n까지의 수 중 m개 고르기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> myList = new ArrayList<>();

        backtrack(0, 0, m, numbers, temp, myList); // 시작인덱스, 깊이 전달
        // 시작인덱스, 깊이 전달, m : 고르는 수, numbers: 수들의 집합리스트, temp: 중복조합을 저장하는 리스트, myList: 최종 담긴 리스트

        for (List<Integer> a : myList){
            StringBuilder sb = new StringBuilder();
            for (int i : a) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        }
    }

    public static void backtrack(int start, int depth, int m, int[] numbers, List<Integer> temp, List<List<Integer>> myList) {
        if (depth == m) {
            myList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            temp.add(numbers[i]);
            backtrack(i, depth + 1, m, numbers, temp, myList);
            temp.remove(temp.size() - 1);
        }
    }
}
