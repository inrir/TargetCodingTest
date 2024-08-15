package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Easy16 {
    /**
     * 백준 11399 ATM
     * 정렬 후 구현하면 될 거 같은 느낌?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine()); // 인원 수

        int[] nums = new int[num];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < num; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        int value = 0;
        int sum = 0;
        for(int i = 0; i < num; i++){
            value += nums[i];
            sum += value;
        }

        System.out.println(sum);
    }
}
