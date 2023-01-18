package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Boj 1202 보석 도둑
 *
 * input: N(보석 개수) K(가방), M(보석 무게) V(가격), C(가방이 담는 무게)
 *
 * output: 담은 총 가격
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] M = new int[N][2];

        for(int i = 0; i < N; i++){
            String[] inp = bf.readLine().split(" ");
            M[i][0] = Integer.parseInt(inp[0]);
            M[i][1] = Integer.parseInt(inp[1]);

        }
        int[] C = new int[K];
        for(int i = 0; i<K; i++){
            C[i] = Integer.parseInt(bf.readLine());
        }

        int answer = 0; // 가격을 담아주는 것

        // C 오름차순 변경
        // M V에서 V를 내림차순으로 하고 동일할 경우 M 오름차순

        Arrays.sort(C); // 기본: 오름차순
        Arrays.sort(M, (o1, o2) -> o1[1] == o2[1]? o1[0] - o2[0] : o2[1] - o1[1]); // lamda

        int i = 0;
        for(int k = 0; k < N; k++){
            if(i == K)
                break;
            if(C[i] >= M[k][0]){
                answer += M[k][1];
                i++;
            }
        }

        System.out.println(answer);

    }
}
