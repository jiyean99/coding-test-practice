package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// N과 M (5)
public class S15654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수열의 수
        int m = Integer.parseInt(st.nextToken()); // 조합 수

        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        // start : 초기숫자, m : 조합의 수, depth: 조회 깊이, int[] arr : 주어진 숫자 배열, list<Integer> temp: 임시 저장하는 리스트, list<int[]> myList : 순열을 담는 리스트, boolean[] visited : 중복 제거를 위해 방문 체크 배열

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> myList = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        backtrack(m, 0, arr, temp, myList, visited);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : myList) {
            sb.setLength(0);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) sb.append(" ");
            }
            System.out.println(sb.toString());
        }

    }

    public static void backtrack(int m, int depth, int[] arr, List<Integer> temp, List<List<Integer>> myList, boolean[] visited){
        if(depth == m){
            myList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(arr[i]);
            backtrack(m, depth + 1, arr, temp, myList, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
