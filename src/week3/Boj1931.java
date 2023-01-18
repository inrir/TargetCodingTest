package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Boj 1931
 * input: all count + (start, end)
 *
 * output: min_time
 * 11
 * 1 4: 3 (4)
 * 3 5: 2
 * 0 6: 6
 * 5 7: 2 (3)
 * 3 8: 5
 * 5 9: 4
 * 6 10: 4
 * 8 11: 3 (2)
 * 8 12: 4
 * 2 13: 11
 * 12 14: 2 (1)
 */
public class Boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine()); // test case count
        StringTokenizer st;
        int[][] input = new int[count][2];
        for(int i = 0; i<count; i++){
            st = new StringTokenizer(bf.readLine());
            input[i][0] = Integer.parseInt(st.nextToken()); // start
            input[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        // 2차원 배열 정렬하는 법: https://ifuwanna.tistory.com/328
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1]? o1[0] - o2[0] : o1[1] - o2[1];
            }
        }); // 종료시간이 오름차순 -> 종료 시간 같을 경우 => 시작시간 기준으로 오름차순

        int answer = 0; // 개수 담는 공간
        int end_time = 0;

        for(int i = 0; i < count; i++) { // 왜 같도록 해야되는거지?

            // 종료시간 기준으로 작거나 같을 수 있다.(한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다!!)
            if(end_time <=  input[i][0]) {
                end_time = input[i][1];
                answer++;
            }
        }

        System.out.println(answer);


    }

}
