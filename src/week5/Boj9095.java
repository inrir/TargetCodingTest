package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 9095 1,2,3 더하기
 *
 * input: testcase_number + N (양수, <= 11)
 *
 * process: 덧셈 형식으로 만들기
 *
 * output: 조합의 갯수 ( 1, 2, 3)
 *
 * algo:
 * 4 = 1+3
 *     2+2
 *     3+1 -> 3, 2, 1
 *
 * 5 = 1+4
 *     2+3
 *     3+2 -> 4, 3, 2
 *
 */
public class Boj9095 {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        dp = new Integer[12]; // 입력의 최대값 (1 ~ 11)

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i<12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0; i<count; i++){
            int tmp = Integer.parseInt(bf.readLine());

            System.out.println(dp[tmp]);
        }

    }
}
