
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /**
     * 백준 10814 나이순 정렬
     * 나이순 만 해주면 될 듯 디퐅트가 앞이니깐
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        String[] nums = new String[num];

        for(int i = 0; i < num; i++){
            nums[i] = bf.readLine();
        }
        Arrays.sort(nums, (o1, o2) -> {
            // 나이가 1자리, 10자리, 100자리 고려
            int o1_num = Integer.parseInt(o1.split(" ")[0]);
            int o2_num = Integer.parseInt(o2.split(" ")[0]);
            return o1_num - o2_num;
        });

        for(int i = 0; i < num; i++){
            System.out.println(nums[i]);
        }

    }
}
