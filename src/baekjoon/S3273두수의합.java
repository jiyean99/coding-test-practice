package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S3273두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int target = Integer.parseInt(br.readLine());

        int startIdx = 0;
        int endIdx = arr.length - 1;
        List<int[]> list = new ArrayList<>();
        while (startIdx < endIdx) {
            int sum = arr[startIdx] + arr[endIdx];
            if(sum == target){
                list.add(new int[]{arr[startIdx], arr[endIdx]});
                startIdx++;
            } else if (sum > target) {
                endIdx--;
            } else if (sum < target) {
                startIdx++;
            }
        }

        System.out.println(list.size());
    }
}
