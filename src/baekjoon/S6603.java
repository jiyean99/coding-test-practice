package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 로또
public class S6603 {
    public static void main(String[] args) throws IOException {
        // n 1 2 3 4 5 7
        // 0 입력시 종료
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            } else {
                StringTokenizer st = new StringTokenizer(str);
                int k = Integer.parseInt(st.nextToken());
                List<Integer> lottoList = new ArrayList<>();

                for (int i = 0; i < k; i++) {
                    lottoList.add(Integer.parseInt(st.nextToken()));
                }

                List<Integer> temp = new ArrayList<>();
                List<List<Integer>> myList = new ArrayList<>();
                // 조합의 수 = 6(고정), 시작값n, lottoList, temp, myList
                funtion(6, 0, lottoList, temp, myList);

                for (List<Integer> a : myList) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : a) {
                        sb.append(i).append(" ");
                    }
                    System.out.println(sb);
                }
                System.out.println();
            }
        }

    }

    public static void funtion(int count, int n, List<Integer> lottoList, List<Integer> temp, List<List<Integer>> myList) {
        if (temp.size() == count) {
            myList.add(new ArrayList<>(temp));
            return;
        }

        for (int i = n; i < lottoList.size(); i++) {
            temp.add(lottoList.get(i));
            funtion(count, i + 1, lottoList, temp, myList);
            temp.remove(temp.size() - 1);
        }
    }
}
