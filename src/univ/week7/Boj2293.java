package univ.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Boj 2293 동전 1
 *
 * input: N, K 1~100, 1~10,000
 *
 * process: 시간제한: 0.5s 메모리 4mb
 * K의 값이 되기 위한 모든 경우의 수
 *
 * output: K원이 되는 모든 경우의 수
 *
 * algo: 시간제한과 메모리 제한을 보면 시간 복잡도 N에 가까운 결과를 내야하는데, 탐색도 힘들고 특정한 자료구조가 ...
 * 오히려 동적계획법 dp로 해결해야할 거 같은데 관계를 파악하기가...
 *
 * 블로그 보고 풀었는데, 1과 2의 동전들을 어떻게 뺄 것인지
 */

public class Boj2293 {
    static int[] coin, dp;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N]; // N가지 동전의 종류의 가격을 가진다.
        dp = new int[K+1];

        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(bf.readLine());
        }

        // dp setting
        dp[0] = 1;

        // 2부터는 값을 통해 책정...
        for(int i = 0; i < N; i++){ // 순차적으로 동전을 사용했을때
            for(int j = coin[i]; j <= K; j++){ // 1로 생기는 경우  2로 생기는 경우 5로 생기는 경우
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[K]);
    }
}
