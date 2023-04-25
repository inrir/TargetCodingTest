import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    /**
     * 백준 1620 나는야 포켓몬 마스터 이다솜
     * Name: number
     * 그냥 배출해주면 될 거 같은데?? 해시맵써서
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" "); // N, M

        int N = Integer.parseInt(tmp[0]); // N
        int M = Integer.parseInt(tmp[1]); // M

        HashMap<String, Integer> StringMap = new HashMap<>();
        HashMap<Integer, String> IntegerMap = new HashMap<>();


        for(int i = 0; i < N; i++){
            String input = bf.readLine();
            StringMap.put(input, i+1);
            IntegerMap.put(i+1, input);
        }

        for(int i = 0; i < M; i++){
            String input = bf.readLine();
            if(input.charAt(0) >= '0' && input.charAt(0) <= '9'){ // 이러면 정수가 입력된 경우
                System.out.println(IntegerMap.get(Integer.parseInt(input)));
            }else{
                System.out.println(StringMap.get(input));
            }

        }


    }
}
