package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj 11726 2*n 타일링
 *
 * input: N _ 1 ~ 1,000
 *
 * process: 2*N에 대해서 2*1과 1*2을 넣기
 *
 * output: 사각형을 채울 수 있는 방법
 *
 * algo: 앞선 시나리오라면 어떤 형식의 값을 메모라이징 방식으로 담을지가 관건이다.
 * 2*1 = 1
 * 2*2 = 2
 * 2*3 = 3 = 1 + 2 = dp[N-2] + dp[N-1]
 * 2*4 = 5 = 2 + 3
 * 2*5 = 8 = 3 + 5
 *
 * 그렇다면 왜 이런 형식이 가능한 것일까?
 */

public class Boj11726 {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // N의 값

        dp = new Integer[N + 1];
        dp[1] = 1;

        if(N >= 2){
            dp[2] = 2;
            System.out.println(recur(N));
        }else{
            System.out.println(dp[N]%10007);
        }

    }
    static int recur(int N){
        if(dp[N] == null){
            dp[N] = (recur(N-1) + recur(N-2)) % 10007; // 내부에서 처리해주면서 값이 옮겨간다.
        }
        return dp[N];
    }


}
