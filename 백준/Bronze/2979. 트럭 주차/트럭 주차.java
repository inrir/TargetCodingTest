
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    /**
     * 백준 2979 트럭 주차
     * 브론즈 2
     * A,B,C 동시에 1, 2, 3 대의 경우
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        int[][] num = new int[3][2]; // 해당 시간에 있는 갯수
        int[] check = new int[3];
        StringTokenizer st;
        int min_start = Integer.MAX_VALUE;
        int max_finish = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(bf.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            min_start = Math.min(min_start, num[i][0]);
            num[i][1] = Integer.parseInt(st.nextToken());
            max_finish = Math.max(max_finish, num[i][1]);
        }

        int count = -1;
        for(int i = min_start; i <= max_finish -1; i++){
            if(i >= num[0][0] && i <= num[0][1] && i+1 >= num[0][0] && i+1 <= num[0][1]) count++;
            if(i >= num[1][0] && i <= num[1][1] && i+1 >= num[1][0] && i+1 <= num[1][1]) count++;
            if(i >= num[2][0] && i <= num[2][1] && i+1 >= num[2][0] && i+1 <= num[2][1]) count++;

            if(count == -1) continue; // 상태 없는 것 패스
            check[count]++;
            count = -1;
        }

        System.out.println(check[0] * 1 * Integer.parseInt(tmp[0]) + check[1] * 2 * Integer.parseInt(tmp[1]) + check[2] * 3 * Integer.parseInt(tmp[2]));

    }
}
