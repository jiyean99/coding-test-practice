package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// OX퀴즈
public class B8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String quiz = br.readLine();
            int[] scores = new int[quiz.length()];

            int relay = 0;
            int totalScore = 0;

            for (int i = 0; i < quiz.length(); i++) {
                if (quiz.charAt(i) == 'O') {
                    relay++;
                    scores[i] = relay;
                } else {
                    relay = 0;
                    scores[i] = 0;
                }
                totalScore += scores[i];
            }

            System.out.println(totalScore);
        }
    }
}
