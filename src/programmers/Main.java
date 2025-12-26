package programmers;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int answer = 0; // 가장 작은 지갑너비의 값
//        int a = 0; // 가로
//        int b = 0; // 세로
//        int size = 0; // 너비
//        int minSize = 1;
//        for (int i = 0; i < sizes.length; i++) {
//            a = sizes[i][0];
//            b = sizes[i][1];
//            size = a * b;
//            System.out.println(size);
//            if (minSize < size) {
//                minSize = size;
//                System.out.println(minSize);
//            }
//            System.out.println("==== 한 사이클 끝 ====");
//        }
//        answer = minSize;
//
//        System.out.println(answer);


        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Map<String, Integer> my_map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!my_map.containsKey(clothes[i][1])) {
                my_map.put(clothes[i][1], 1);
            } else {
                my_map.put(clothes[i][1], my_map.get(clothes[i][1]) + 1);
            }
        }
        int answer = 1;

        for (String a : my_map.keySet()) {
            answer*=(my_map.get(a) + 1);
        }

        answer -= 1;
//        System.out.println(my_map);
        System.out.println(answer - 1);
    }
}
