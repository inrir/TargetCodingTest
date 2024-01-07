import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 백준 1254 팰린드룸 만들기
     * 시작점과 끝점에서 시작해서 안 맞은 거 위주로 새로 생성할 예정
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int answer = 0;
        int len = input.length();

        for(int i = 0; i < len; i++){
            if(isCheck(input.substring(i)))
                break;
            answer++;
        }


        // aabb -> aabb, abb, bb bb를 제외하고 출력..
        // 왜 위에 같은 방법이 안되는 거지?? abbfsdbbcccbbb (b)가 어디에 상응해야할 지가 애매해진다. 17 vs ??  baabb -> baabbaab(8) 내 프로그램은 baabb + aab 추가... 이렇게 생각함.
        // 즉 재귀적인 탐색이 팰린드룸 만들기 해결책..

        System.out.println(answer + len);
    }
    public static boolean isCheck(String s){
        int start_p = 0;
        int end_p = s.length() - 1;
        while(start_p < end_p){
            if(s.charAt(start_p) != s.charAt(end_p)) return false; // 팰린드 룸이 아닐 걸로.
            start_p++;
            end_p--;
        }

        return true;
    }
}
