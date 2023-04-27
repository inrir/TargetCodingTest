package HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy12 {
    /**
     * 백준 10709 기상캐스터
     * 구름의 움직임은 오른쪽만 가능하므로,
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        int H = Integer.parseInt(tmp[0]); // 행
        int W = Integer.parseInt(tmp[1]); // 열
        int[][] answer = new int[H][W];

        for(int i = 0; i < H; i++){
            String input = bf.readLine();
            int value = (input.charAt(0) == 'c')? 0 : -1;
            answer[i][0] = value;
            for(int j = 1; j < W; j++){
                if(input.charAt(j) == 'c'){
                    value = 0;
                }else if(value == -1){
                    value = -1;
                }else{
                    value++;
                }
                answer[i][j] = value;
            }
        }
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}
