package HotFixStudy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Easy02 {
    /**
     * 백준 17298 오큰수
     * NGE를 배열을 보고 출력해야 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> checkStack = new Stack<>();

        int N = Integer.parseInt(bf.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

//        int first = nums[0]; // 첫번째가 값이 변경된 지 확인하기 위해서
        // for 하나로 끝내야 한다.
        // 후입 선출로서 내용을 끝내야 한다.
        for(int i = 0; i < N; i++){

            while(!checkStack.isEmpty() && nums[checkStack.peek()] < nums[i]){
                nums[checkStack.pop()] = nums[i];
            }

            checkStack.push(i);

        }

        // 첫번째와 마지막 값이 변경된 여부를 확인해준다.
//        nums[nums.length - 1] = -1;
//        if(nums[0] == first) nums[0] = -1;

        while(!checkStack.isEmpty()){
            nums[checkStack.pop()] = -1;
        }
        StringBuilder answer = new StringBuilder();

        for(int i =0 ; i < N; i++){
            answer.append(nums[i]).append(' ');
        }

        System.out.println(answer);



    }
}
