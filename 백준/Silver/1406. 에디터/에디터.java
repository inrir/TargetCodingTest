
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    /**
     * 백준 1406 에디터
     * 영어 소문자만 기록 최대 600,000
     * 시간 제한 0.3 초
     * L: 왼쪽으로 옮김
     * D: 오른쪽으로 옮김
     * B: 왼쪽 문자를 삭제
     * P$: 문자를 커서 왼쪽에 추가
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = bf.readLine();
        int M = Integer.parseInt(bf.readLine());

        Stack<String> leftSt = new Stack<>();
        Stack<String> rightSt = new Stack<>();

        // 처음 커서는 문장의 맨 뒤에서 시작 왼쪽 초기 문장 + 오른쪽 새로운 것
        String[] arr = N.split("");
        for(String a : arr){
            leftSt.push(a); // leftSt으로 옮기기
        }



        for(int i = 0; i < M; i++){
            String tmp = bf.readLine();
            char target = tmp.charAt(0);

            switch (target) {
                case 'L':
//                    if(index == 0) break;
//                    index--; // 왼쪽으로 옮김
                    if(!leftSt.isEmpty()){ // 스택 전환으로 인덱스 옮기기
                        rightSt.push(leftSt.pop());
                    }
                    break;

                case 'D':
//                    if(index == bt.length()) break;
//                    index++;
                    if(!rightSt.isEmpty()){
                        leftSt.push(rightSt.pop());
                    }
                    break;
                case 'B':
//                    if(index == 0) break;
//                    bt.delete(index - 1, index);
//                    index--;
                    if(!leftSt.isEmpty()){
                        leftSt.pop(); // 삭제
                    }
                    break;
                case 'P':
//                    if(index == 0){
//                        bt.insert(0, tmp.charAt(2));
//                        index++;
//                    }else{
//                        bt.insert(index, tmp.charAt(2));
//                        index++;
//                    }
                    char t = tmp.charAt(2);
                    leftSt.push(String.valueOf(t)); // 바로 왼쪽에 넣기
                    break;
                default:
                    break;
            }


        }

//        bw.write(bt.toString());
        while(!leftSt.isEmpty())
            rightSt.push(leftSt.pop());
        while(!rightSt.isEmpty())
            bw.write(rightSt.pop());

        bw.flush();
        bw.close();
    }

}
