package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 1904 01타일
 * input: N: 1 ~ 1,000,000
 *
 * process: 00, 1로서 조합을 만든다 N의 개수에 맞도록 0은 00을 사용하도록 한다.
 *
 * output: 조합된 개수를 적기 if N = 2 -> 00 11, answer is 2
 *
 * algo: as dp, N = N-1 + N-2 흐름으로 전개되는데 이유가 뭘까?
 * 이유는 모르겠지만, 형식자체가 피보나치 수열을 따라가므로 성립한다.
 *
 *
 */
public class Boj1904 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = 1;
        if(N >= 2){ // N 1~1,000,000 경계값 계산 -> 오류 체크
            dp[2] = 2;
        }
        System.out.println(recur(N));

    }
    static int recur(int N){
        if(dp[N] == null){
            dp[N] = (recur(N-1) + recur(N-2))%15746;
        }
        return dp[N];
    }
}
