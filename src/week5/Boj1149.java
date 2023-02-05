package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Boj 1149 RGB 거리
 *
 * input: N + RGB 비용
 *
 * process: 양 옆이 동일하지 않도록 조절
 *
 * output: 최소값의 RGB 사용 비용
 *
 * algo:
 * 각 자리의 최소값으로 구한다면, 추후 그리디의 한계점에 도달할 것이다. 1->100->100, 100->1->1 와 같이 후자가 아닌 전자가 되는 불상사가 생긴다.
 *
 * 1번 -> N번으로 향하는 과정에서 최소의 값을 갖도록 하는 것이 관건이다. 계속 값이 최소인 방향으로 더해주는 방법이다.
 *
 * RGB => 012 0에서 최소인 경우, 1에서 최소인 경우, 2에서 최소인 경우
 * 출력시 0,1,2에서 최소인 경우로 출력한다.
 *
 */
public class Boj1149 {
    static Integer[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        arr = new int[N+1][3];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        dp = new Integer[N+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;

        System.out.println(Math.min(recur(N,0), Math.min(recur(N, 1), recur(N, 2))));


    }
    static int recur(int N, int number){
        if(dp[N][number] == null){
            dp[N][0] = Math.min(recur(N-1, 1), recur(N-1, 2)) + arr[N][0];

            dp[N][1] = Math.min(recur(N-1, 0), recur(N-1, 2)) + arr[N][1];

            dp[N][2] = Math.min(recur(N-1, 0), recur(N-1, 1)) + arr[N][2];

        }

        return dp[N][number];
    }
}
