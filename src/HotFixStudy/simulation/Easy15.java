package HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Easy15 {
    /**
     * 백준 1547번 공
     * 진짜 공을 옮기는 거... 이런 문제도 있구나 싶으면서 신박?
     * 해당하는 위치만 알아두기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        int space = 1; // 공의 현재 위치
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == space) {
                space = second;
                continue;
            }
            if (second == space) {
                space = first;
                continue;
            }
        }

        System.out.println(space);
    }
}
