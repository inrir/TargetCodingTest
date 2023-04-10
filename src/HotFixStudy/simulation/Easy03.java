package HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy03 {
    /**
     * 백준 10988 펠린드룸인지 확인하기
     * 앞 뒤 확인하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int len = input.length();
        int length = (len%2 == 0)? len/2 : len/2 + 1;

        System.out.println(check(input, length));
    }
    public static int check(String s, int length){
        int len = s.length();
        for(int i = 0; i < length; i++){
            if(s.charAt(i) != s.charAt(len - 1 - i)){
                return 0;
            }
        }
        return 1;
    }
}
