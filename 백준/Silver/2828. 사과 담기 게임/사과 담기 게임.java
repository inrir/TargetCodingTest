import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 백준 2828번 사과담기 게임
     * M, N, J 사과의 위치가 나온다
     * 첫 시작 위치인 M에 대해서 이동
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]); // 스크린 개수
        int M = Integer.parseInt(tmp[1]); // 바구니 위치

        int J = Integer.parseInt(bf.readLine()); // 사과의 개수

        // issue M 칸을 차지한다는 개념으로 생각해야 한다.
        int left = 0; // 시작하는 점
        int right = M - 1; // 차지하는 면적대비 오른쪽

        int answer = 0; // 이동거리 표시
        int gap;
        for(int i = 0; i < J; i++){ // 위치 조정
            int place = Integer.parseInt(bf.readLine()) - 1; // 어디서 내릴지 위치 받기

            if(place < left){
                gap = left - place;
                answer += gap; // 해당 부분을 이동해야 한다.
                left -= gap;
                right -= gap;
            }else if(place > right){
                gap = place - right;
                answer += gap;
                left += gap;
                right += gap;
            }
            // 면적 안에 해당하는 사과가 내린다.
        }

        System.out.println(answer);

    }

}
