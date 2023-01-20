package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 1541 잃어버린 괄호
 *
 * input: 피연산자 + 연산자 + 피연산자 구조 // 입력으로 주어진 길이가 50 이하
 *
 * output: 해당 연산에서 괄호를 추가해서 더 높은 값을 받을 수 있는 경우
 *
 * algo:
 * "+"를 먼저하고 이후에 연산을 한다면 제일 최소의 값을 받을 것이다.
 */
public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("-"); // 55-50+40 => 55 50+40

        int answer = -1; // 초기 시작을 0 + 11 일수도 있기 때문에
        for(int i = 0; i<input.length; i++){

            int tmp = 0;

            String[] check = input[i].split("\\+"); // 특별한 의미를 담고있는 메타문자라서 그렇다

            for(int j = 0; j < check.length; j++){
                tmp += Integer.parseInt(check[j]);
            }

            if(answer == -1 && i == 0){
                answer = tmp;
            }else{
                answer -= tmp;
            }
        }
        System.out.println(answer);



    }
}
