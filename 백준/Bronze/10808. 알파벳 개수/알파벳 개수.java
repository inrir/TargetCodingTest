import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // input: string only 소문자
        // output: split alphabet.?
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        int[] a = new int[26];

        for(int i = 0; i < input.length(); i++){
            int tmp = input.charAt(i) - 'a';
            a[tmp]++;
        }

        for(int i = 0; i < 26; i++){ // 알파벳 총 길이 26개
            System.out.print(a[i] + " ");
        }

    }
}
