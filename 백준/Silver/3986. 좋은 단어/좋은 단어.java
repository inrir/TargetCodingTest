
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /**
     * 백준 3986 좋은 단어
     * 스택식으로 없애면 되지 않나?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int answer = 0;

        for(int i = 0; i < N; i++){ // N 최대 100
            Stack<Character> stack = new Stack<>();
            String input = bf.readLine();

            for(int j = 0; j < input.length(); j++){
                char tmp = input.charAt(j);
                if(!stack.isEmpty() && tmp == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(tmp);
                }
            }
            if(stack.isEmpty()){
                answer++;
            }

        }

        System.out.println(answer);

    }


}
