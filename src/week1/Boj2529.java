package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 부등호 문제 BOJ 2529
 * input: 몇개의 부등호를 입력 받을지 + 해당 개수의 부등호
 *
 * output: 최대, 최소 부등호
 */
public class Boj2529 {

    static boolean[] check = new boolean[10]; // 0~9까지 check
    static int count;
    static String[] list;
    static ArrayList answer = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bf.readLine()); // "count+1" 개의 부등호 사이의 관계를 만든다.
        String input = bf.readLine();
        list = input.split(" "); // 빈칸으로 부등호 구분

        solution(0, "");
        Collections.sort(answer);

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));


        /*
        about: MAX  >: 9, <: 8 | >>: 9 8, <<: 8 9 |  << >:  7 < 8 < 9 > 6

        897
        021
         */


    }
    static boolean isThat(char op1, char op2, String operator){ // 피연산자1, 피연산자2, 연산자
            if(operator.equals(">"))
                return op1 > op2;
            if(operator.equals("<"))
                return op1 < op2;
            return false;
    }

    static void solution(int index, String result) { // 지속적으로 확인하고 탐색 반복진행
        if (index == count + 1) { // end
            answer.add(result);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (check[i])
                continue;
            if (index == 0 || isThat(result.charAt(index - 1), (char) (i + '0'), list[index - 1])) { // op2의 경우, char로 변환을 위해 '0'
                check[i] = true;
                solution(index + 1, result + Integer.toString(i));
                check[i] = false;
            }
        }
    }
}
