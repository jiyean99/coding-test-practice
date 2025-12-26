package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1302 {
    public static void main(String[] args) throws IOException {
//        // n : 들어온 책의 개수
//        // input : 책 이름 * 5
//        // output : 가장 많이 팔린 책의 제목 출력
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        Map<String, Integer> my_map = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            String name = br.readLine();
//            if (!my_map.containsKey(name)) {
//                my_map.put(name, 1);
//            } else {
//                my_map.put(name, my_map.get(name) + 1);
//            }
//        }
//
//        int max = Integer.MIN_VALUE;
//
//        List<String> my_list = new ArrayList<>();
//
//        System.out.println(my_map.keySet());
//        for (String a : my_map.keySet()) {
//            if (max < my_map.get(a)){
//                max = my_map.get(a);
//            }
//        }
//        for (String a : my_map.keySet()) {
//            if(my_map.get(a) == max){
//                my_list.add(a);
//            }
//        }
//
//        Collections.sort(my_list);
//
//        System.out.println(my_list.get(0));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> my_map = new TreeMap<>();

        for (int i = 0; i < n; i++){
            String name = br.readLine();
            if (!my_map.containsKey(name)) {
                my_map.put(name, 1);
            }else {
                my_map.put(name, my_map.get(name) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String max_key = "";

        List<String> my_list = new ArrayList<>();

        for (String a : my_map.keySet()) {
            if (max < my_map.get(a)){
                max = my_map.get(a);
                max_key = a;
                break;
            }
        }

        System.out.println(max_key);
    }
}
