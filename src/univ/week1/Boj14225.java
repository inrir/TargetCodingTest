package univ.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부분수열의 합 BOJ 14225
 *
 * 입력: 갯수 + 부분 수열들
 *
 * 출력: 최소의 형성 안되는 것
 */
public class Boj14225 {

    static int count;
    static int[] nums;
    static boolean[] checkpoint; // 입력된 부분수열의 모든 경우를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bf.readLine());
        String[] fake_nums = (bf.readLine()).split(" ");
        nums = new int[fake_nums.length];
        checkpoint = new boolean[100000*20 + 1]; // 값을 담을 수 있는 크기: 최대 값 100,000 * 20 + 1(0 특수값)
        for(int i = 0; i< fake_nums.length; i++){
            nums[i] = Integer.parseInt(fake_nums[i]);
        }

        // 부분 수열 알아내는 법 - key algorithm: 모두 탐색하기
        dfs(0,0); // 시작

        // checkpoint에 없는 최소의 수를 탐색
        for(int i = 0; i<checkpoint.length; i++){
            if(!checkpoint[i]){
                System.out.println(i);
                break;
            }
        }

    }

    static void dfs(int depth, int result){ // 모든 경우를 만든다.
        if(depth == count){ // 모든 탐색을 마친 줄기
            checkpoint[result] = true; // 줄기의 값은 존재한다.
            return; // 종료
        }
        // 해당 부분수열이 사용된 경우와 아닌 경우를 모두 포함하도록 한다.
        dfs(depth + 1, result + nums[depth]);
        dfs(depth + 1, result);


    }
}
