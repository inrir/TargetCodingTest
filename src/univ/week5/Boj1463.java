package univ.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 1463 1로 만들기
 *
 * input:
 * 1. %3 => /3
 * 2. %2 => /2
 * 3. -1
 *
 * output: 1이 되는 최소 갯수
 *
 * algo:
 * 1. N%6 -> 3
 * 2. N%3 -> 2
 * 3. N%2 -> 2
 * 4. N-1 -> 1
 *
 * 모든 경우를 순회하는 법
 *
 *
 */
public class Boj1463 {
    static Integer[] dp; // int 형을 담을 수 잇는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        dp = new Integer[input+1];
        dp[0] = dp[1] = 0; // 최소값 0인 경우. 최소 반례 제거


        System.out.println(recur(input));
    }

    static int recur(int input) { // input is target

        if (dp[input] == null) { //  no search
            if (input % 6 == 0) {
                dp[input] = Math.min(recur(input / 3), Math.min(recur(input / 2), recur(input - 1))) + 1; // min 대상이 only 2
            } else if (input % 3 == 0) {
                dp[input] = Math.min(recur(input / 3), recur(input - 1)) + 1;
            } else if (input % 2 == 0) {
                dp[input] = Math.min(recur(input / 2), recur(input - 1)) + 1;
            } else {
                dp[input] = recur(input - 1) + 1;
            }
        }
            return dp[input];
    }
}
