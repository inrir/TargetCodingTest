import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 백준 9996 한국이 그리울 땐 서버에 접속하지
     * 앞 뒤만 보면 되는거 아닌가?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String[] input = bf.readLine().split("\\*");

        for(int i = 0; i < N; i++){
            String s = bf.readLine();
           // 앞뒤로 패턴과 동일한 게 있는 것을 확인하면 된다. 첫 지점과 끝 지점이 고정이기 때문에 if로 가능

           if(s.length() < input[0].length() + input[1].length()){
               System.out.println("NE");
           }else if(input[0].equals(s.substring(0, input[0].length())) && input[1].equals(s.substring(s.length() - input[1].length(), s.length()))) {
               System.out.println("DA");
           }else{
               System.out.println("NE");
           }

        }

    }
}
