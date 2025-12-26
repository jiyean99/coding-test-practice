package baekjoon;

import java.io.*;
import java.util.*;

// 단어 정렬
public class S1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Set<String> stSet = new TreeSet<>();
        for (int i = 0; i < t; i++) {
            stSet.add(br.readLine());
        }


        List<String> stList = new LinkedList<>();
        stList.addAll(stSet);

        Collections.sort(stList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();

                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String a : stList) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }
}
