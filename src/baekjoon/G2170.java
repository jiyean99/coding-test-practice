package baekjoon;

import java.io.*;
import java.util.*;

//선 긋기
public class G2170 {
    public static void main(String[] args) throws IOException {
        // n : 선을 그은 횟수
        // x, y : 선을 그을 때 선택한 두 점의 위치
        // 1-3, 2-5, 3-5, 6-7
        // 1과 3 사이의 거리는 2, 2와 5는 x가 3미만이므로, 거리 3에서 x와 2의 값을 빼기때문에 3-1=2, 3과 5사이는 ..
        // 즉, 연속되는 범위 안에 있을 때 최소값과 최대값만 가지고 길이를 구하고, 이런 구간들을 합친다
        // 현재 보고 있는 선분이 이전 선분들과 겹치면 구간을 늘리고, 안 겹치면 이전 구간 길이를 결과에 더하고 새 구간을 시작

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Line> lineList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lineList.add(new Line(x, y));
        }

        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line a, Line b) {
                if (a.x == b.x) {
                    return Integer.compare(a.y, b.y);
                }
                return Integer.compare(a.x, b.x);
            }
        });

        int total = 0;

        int currentStart = lineList.get(0).x;
        int currentEnd = lineList.get(0).y;

        for (int i = 1; i < n; i++) { // 0번째는 current에 설정 후 시작
            Line line = lineList.get(i);

            if(line.x > currentEnd){
                // 완전히 분리된 구간 -> 이전 구간 길이 추가 후 새 구간 시작
                total += currentEnd - currentStart;
                currentStart = line.x;
                currentEnd = line.y;
            } else if(line.y > currentEnd){
                // 겹치는 구간 -> 끝점만 확장
                currentEnd = line.y;
            }
            // line.y <= currentEnd인 경우는 무시 (완전 포함됨)
        }
        // 마지막 구간 길이 추가
        total += currentEnd - currentStart;

        System.out.println(total);
    }
}

class Line {
    int x, y;

    // Line클래스의 기본생성자 -> Line 클래스의 인스턴스(객체) 생성시 반드시 두개의 파라미터를 가져가도록 오버라이드?오버라이딩?
    Line(int x, int y) {
        this.x = x;
        this.y = y;
    }
}