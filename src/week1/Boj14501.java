package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사 문제: 14501
 *
 * 입력: 퇴사일 => T, P 해당 일자별로 N: 1~15
 * 출력: 최대 sum(P)
 */
public class Boj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());

        int[] t = new int[count+1]; // N일차 되는 점을 고려
        int[] p = new int[count+1]; // N일차 되는 점을 고려
        int[] dp = new int[count+15]; // 입력의 최대한 값을 넣어주기 막말로 15일차에 15일 기간의 일이 있을수도 있으니깐
        int max = 0;
        for(int i = 0; i<count; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<=count; i++){
            dp[i] = Math.max(dp[i],max);

            dp[t[i]+i] = Math.max(dp[t[i]+i], p[i]+dp[i]);

            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }


}
