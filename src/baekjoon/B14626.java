package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// ISBN
public class B14626 {
    public static void main(String[] args) throws IOException {
        // m = 10 - (홀수의 합 + 짝수*3의 합) mod 10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] isbn_arr = br.readLine().toCharArray();

        int sum = 0;
        int star_idx = -1;

        for (int i = 0; i < isbn_arr.length; i++) {
            if (isbn_arr[i] == '*') {
                star_idx = i;
                continue;
            }
            int num = isbn_arr[i] - '0';
            int multi_num = (i % 2 == 0) ? 1 : 3;
            sum += num*multi_num;
        }

        int startar_multi = (star_idx % 2 == 0) ? 1 : 3;

        for (int d = 0; d <= 9; d++) {
            if ( (sum + startar_multi * d) % 10 == 0 ) {
                System.out.println(d);
                break;
            }
        }

    }
}
