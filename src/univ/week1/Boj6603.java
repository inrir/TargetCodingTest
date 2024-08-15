package univ.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 로또 6603 BOJ
 * input: sum_count + S(집합)
 *
 * output: 가능한 모든 경우
 */
public class Boj6603 {
    static boolean[] isCheck;
    static int count; // 변수들의 총 갯수
    static int[] nums; // 변수를 담는 그릇
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input = bf.readLine().split(" ");
            count = Integer.parseInt(input[0]);
            if(count == 0)
                break;
            nums = new int[count];
            isCheck = new boolean[count];
            for(int i = 0; i < count; i++){
                nums[i] = Integer.parseInt(input[i+1]);
            }
            solution(0, 0);

            System.out.println(); // 끝나고 칸 띄움
        }
    }

    static void solution(int start, int depth){ // 앞서 푼 동일한 유형으로 dfs 반복
        // 끝 부분을 낮추면서 어떻게 모든 배열을 반복하게 할까? -> 재귀적으로 모든 경로를 탐색하도록 한다.

        if(depth == 6){ // 해당할 때 출력하도록 한다.
            for(int i = 0; i<count; i++){
                if(isCheck[i]){
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        }

        for(int i = start; i < count; i++){ // depth 6인 모든 경우를 경유한다
            isCheck[i] = true;
            solution(i+1, depth+1);
            isCheck[i] = false;
        }

    }

}
