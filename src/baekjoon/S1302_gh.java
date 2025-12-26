package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S1302_gh {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            books.put(str, books.getOrDefault(str, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String bestSeller = "";
        for (String book : books.keySet()) {
            int count = books.get(book);
            if (count > max) {
                max = count;
                bestSeller = book;
            } else if (count == max) {
                // book이 bestSeller보다 먼저오면
                if (bestSeller.compareTo(book) > 0) bestSeller = book;
            }
        }
        System.out.println(bestSeller);

    }
}
