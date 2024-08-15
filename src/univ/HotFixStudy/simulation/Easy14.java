package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy14 {
    /**
     * 백준 1712 손익분기점
     * 그저 비용 계산하면 안되나?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        int A = Integer.parseInt(tmp[0]); // fixed cost
        int B = Integer.parseInt(tmp[1]); // variable cost
        int C = Integer.parseInt(tmp[2]); // price

        int expect = 1;
        // A + B * expect <= C * expect 시점 찾기
        // 언제가 안된다고 말하지??

        if(B >= C){
            System.out.println(-1);
        }else{
            int answer = A / (C - B);
            answer++;
            System.out.println(answer);
        }


    }
}
