package univ.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Boj 9184 신나는 함수 실행
 *
 * input: w(a, b, c) 형태
 *
 * process: 제한 범위 -50 ~ 50, -1 -1 -1로 끝내기
 *
 * output: w(a, b, c) = value
 *
 * algo: 그저 따라한다면 매우 오랜 시간이 걸린다고 하는데 음... 함수를 어떻게 수정할지가 중요할 것이라고 본다.
 * 0 ~ 20 경계에서 단순화 시켜야 한다..
 * 값을 미리 저장해두고 그 값을 꺼내는 방식이 어떨까? -> 메모제이션을 잘 활용해야한다.
 */
public class Boj9184 {
    static int a, b, c;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new int[51][51][51];
        while(true){
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1)
                break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c)); // 소문자로 계속 "틀렸습니다" 뜸...

        }
    }
    static int w(int a, int b, int c){

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return dp[a][b][c] = 1048576; // 동일한 결과값이 나올 수 밖에 없음 w(20, 20, 20) = 1048576
        }
        if(dp[a][b][c] != 0){ // 메모제이션된 값 이용하기
            return dp[a][b][c];
        }
        if(a < b && b < c){
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return dp[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);

    }

}
