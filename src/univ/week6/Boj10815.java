package univ.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * boj 10815 숫자 카드
 *
 * input: N, contents , M, contents
 *
 * process: N, M 1 ~ 500,000
 * contents -10,000,000 ~ 10,000,000
 *
 * output: M개의 값이 N에 존재 여부로 1 or 0
 *
 * algo:
 * N의 값을 M에 넣어서 있는 확인하려면 Map 방식으로 넣고 확인?
 *
 */
public class Boj10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        Map<String, Integer> map = new HashMap<>(); // 명백하게 충돌이 없다면 무조건 O(1)인 시간복잡도 이기에 이게 맞다고 본다

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            // Integer.valueof()으로 한다면, 시간초과가 난다.
            map.put(st.nextToken(), 0);
        }

        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i< M; i++){
            if(map.containsKey(st.nextToken())){
                sb.append("1");
            }else{
                sb.append("0");
            }
            if(i == M-1){
                break;
            }else{
                sb.append(" ");
            }
        }

        System.out.println(sb);


    }
}
