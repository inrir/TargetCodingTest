
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 백준 2292 벌집
     * 패턴에 대한 이해 => 몇으로 가는가??
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Integer num = Integer.parseInt(bf.readLine());

        // 무슨 패턴일까??? 6배수로 커진다.
        int i = 1;
        int sum = 1;
        int answer = 0;

        while(true){
            if(num <= sum){
                answer++;
                break;
            }
            sum += i * 6;
            i++;
            answer++;
        }

        System.out.println(answer);


    }
}
