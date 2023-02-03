package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 2379 계단 오르기
 *
 * input: 계단의 갯수 + 각 계단 간격의 점수
 *
 * process: 1칸 혹은 2칸(3개의 계단 연속불가)
 *
 * output: 점수의 최대값
 *
 * algo: N-2 + N or N-3 + N-1 + N
 */
public class Boj2379 {
    static Integer[] dp; // 메모제이션
    static int[] arr; // data space
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        dp = new Integer[N+1]; // 1,2,3,4,5,6
        arr = new int[N+1];

        for(int i = 1; i<N+1; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        dp[0] = arr[0] = 0;
        dp[1] = arr[1];

        if(N >= 2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recur(N));
    }
    static int recur(int N){ // 공식 => N-2 + N or N-3 + N-1 + N 둘 중 하나로 나뉜다.
        if(dp[N] == null){
            dp[N] = Math.max(recur(N-2), recur(N-3) + arr[N-1]) + arr[N];
        }
        return dp[N];
    }
}
