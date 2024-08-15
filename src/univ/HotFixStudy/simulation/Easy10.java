package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Easy10 {
    /**
     * 백준 13458 시험 감독
     * 총감독관 먼저 감시할 인원 빼고 나머지에 부감독관 투입해서 인원 환산하면 될 듯.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(bf.readLine()); // 시험장 개수
        int[] nums = new int[num];
        long answer = num; // 투입된 감독관의 수를 의미하는데, 우선 총감독관은 각 시험장에 모두 투입된다.

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < num; i++){ // 고사장의 인원을 정리해준다.
            nums[i] = Integer.parseInt(st.nextToken());
        }

        String[] tmp = bf.readLine().split(" ");
        int all = Integer.parseInt(tmp[0]); // 총감독관이 확인할 수 있는 인원
        int sub = Integer.parseInt(tmp[1]); // 부감독관이 확인할 수 있는 인원

        for(int i = 0; i < num; i++){
            nums[i] -= all;
        }

        for(int i = 0; i < num; i++){
            if(nums[i] <= 0) continue;

            answer += nums[i] / sub;
            if(nums[i] % sub != 0) answer++;
        }

        System.out.println(answer);

    }
}
