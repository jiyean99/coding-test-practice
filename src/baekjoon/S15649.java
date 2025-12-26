package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// N과 M (1)
public class S15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1부터 n까지의 수 중 m개 고르기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> inputList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            inputList.add(i);
        }

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> numList = new ArrayList<>();
        boolean[] checked = new boolean[inputList.size()];
        // m : 고르는 수, inputList: 수들의 집합리스트, temp: 순열을 저장하는 리스트, numList : 모든 순열을 담은 리스트 , checked[] : 중복을 제거하기 위한 확인 배열

        function(m, inputList, temp, numList, checked);

        for (List<Integer> a : numList){
            StringBuilder sb = new StringBuilder();
            for (int i : a) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        }
    }

    public static void function(int m, List<Integer> inputList, List<Integer> temp, List<List<Integer>> numList, boolean[] checked) {
        if (temp.size() == m) {
            numList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < inputList.size(); i++) {
            if (checked[i]) continue;
            temp.add(inputList.get(i));
            checked[i] = true;
            function(m, inputList, temp, numList, checked);
            temp.remove(temp.size() - 1);
            checked[i] = false;
        }
    }
}
