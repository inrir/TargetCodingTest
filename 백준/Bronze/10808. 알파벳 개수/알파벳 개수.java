
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 백준 10808 알파벳 개수
     * 브론즈 4
     * 알파벳 배열 => 알파벳마다 넣어주는 형식으로 개수 세기
     * 소문자만 받음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int[] alpha = new int[26];

        for(int i = 0; i < input.length(); i++){
            alpha[(int)(input.charAt(i) - 'a')]++;
        }

        for(int i = 0; i < alpha.length - 1; i++){
            System.out.print(alpha[i] + " ");
        }
        System.out.print(alpha[alpha.length - 1]);
    }
}
