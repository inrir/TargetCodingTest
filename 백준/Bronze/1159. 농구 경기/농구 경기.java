import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 백준 1159 농구경기
     * 알파벳 카운팅 후, 5이상인 값을 출력 "" 경우 PREDAJA
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        int[] alpha = new int[26];
        for(int i = 0; i < num; i++){
            char tmp = bf.readLine().charAt(0); // 앞만 중요하기 때문에
            alpha[tmp - 'a']++;
        }

        String answer = "";
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] >= 5){
                answer += (char)('a' + i);
            }
        }

        if(answer.equals("")) System.out.println("PREDAJA");
        else System.out.println(answer);
    }
}
