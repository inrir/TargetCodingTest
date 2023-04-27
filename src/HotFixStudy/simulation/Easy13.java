package HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy13 {
    /**
     * 백준 1193 분수 찾기
     * 효율성을 따질 0.5초라서 전체를 다 생성해서 넣는거는 시간 초과
     * 각 번째에 맞는 거를 찾아줘야 할 거 같은데..?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(bf.readLine());
        int A_index = 1; // 대각선 인덱스
        int B_index = 0; // 내부 값 인덱스

        while(true){ // 인덱스의 값을 정확하게 타겟팅해야 한다.

            if(target <= A_index + B_index){
                int index = target - B_index; // 대각선에서 몆 번째 값을 알고 싶은지 안다.
                if(A_index % 2 != 0){// 홀수번째 대각선이면, 큰 수가 먼저 분자에 자리한다.
                    System.out.println((A_index + 1 - index)+"/"+ (index));
                    break;
                }else{ // 짝수번째 대각선이면, 작은 수가 먼저 분자에 자리한다.
                    System.out.println((index)+"/"+(A_index + 1 - index));
                    break;
                }

            }else{
                // 아직 아니면 누적합 조정.
                B_index += A_index;
                A_index++;
            }


        }


    }
}
