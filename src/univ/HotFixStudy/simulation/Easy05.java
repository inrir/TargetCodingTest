package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy05 {
    /**
     * 백준 11655 ROT13
     * 알파벳 대문자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        String answer = "";
        for(int i = 0; i< input.length(); i++){
            if(input.charAt(i) == ' ' || (input.charAt(i) >= '0' && input.charAt(i) <= '9')){
                answer += input.charAt(i);
            }else {
                if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z' && (char)(input.charAt(i) + 13) > 'z'){
                    answer += (char) ((input.charAt(i) - ('z' - 'a' + 1)) + 13 );
                }else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' && (char)(input.charAt(i) + 13) > 'Z'){
                    answer += (char) ((input.charAt(i) - ('Z' - 'A' + 1)) + 13);
                }else {
                    answer += (char) (input.charAt(i) + 13);
                }
            }
        }
        System.out.println(answer);

    }
}
