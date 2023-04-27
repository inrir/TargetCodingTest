package HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy11 {
    /**
     * 백준 4659 비밀번호 발음하기
     * 1, 2, 3 조건을 검사하도록하는 절차를 만들고 검증하면 되지 않을까?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String tmp = bf.readLine();
            if(tmp.equals("end")) break; // 멈춤 사인

            // 1. 모음 검증
            boolean check = false;
            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == 'a' || tmp.charAt(i) == 'e' || tmp.charAt(i) == 'i' || tmp.charAt(i) == 'o' || tmp.charAt(i) == 'u') check = true;
            }
            if(!check){
                System.out.println("<" + tmp + "> is not acceptable.");
                continue;
            }

            // 2. 모음, 자음 3개 연속 검증
            int A_count = 0; // 모음 카운터
            int B_count = 0; // 자음 카운터

            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == 'a' || tmp.charAt(i) == 'e' || tmp.charAt(i) == 'i' || tmp.charAt(i) == 'o' || tmp.charAt(i) == 'u'){
                    A_count++;
                    B_count = 0; // 초기화
                }else{
                    B_count++;
                    A_count = 0;
                }
                if(A_count == 3 || B_count == 3){
                    check = false;
                    break;
                }
            }

            if(!check){
                System.out.println("<" + tmp + "> is not acceptable.");
                continue;
            }
            // 3. 같은 글자 연속 검증
            char before_char = tmp.charAt(0);
            for(int i = 1; i < tmp.length(); i++){
                if(before_char == tmp.charAt(i) && before_char != 'o' && before_char != 'e') {
                    check = false;
                    break;
                }
                before_char = tmp.charAt(i);
            }

            if(!check){
                System.out.println("<" + tmp + "> is not acceptable.");
                continue;
            }

            System.out.println("<" + tmp + "> is acceptable.");
        }

    }
}
