package univ.HotFixStudy.errorDetect;
import java.util.*;

public class Error2 {

//    class Solution {
        static HashMap<String, Integer> map;

    public static void main(String[] args) {
//        String[] want = {"banana", "apple", "rice", "pork", "pot"};
//        int[] number = {3, 2, 2, 2, 1};
//        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        System.out.println(solution(want, number, discount));

    }
        public static int solution(String[] want, int[] number, String[] discount) {
            // 원하는 날 모두 할인 받을 수 있는 경우를 선택해야한다.
            // counting 해서 답변으로 준다.
            int answer = 0;
            map = new HashMap<>();
            for(int i = 0; i < want.length; i++){
                map.put(want[i], number[i]); // banana : 3
            }

            for(int i = 0; i < discount.length; i++){
                String[] temp = new String[10];
                int index = 0;
                while(true){
                    if(i + index >= discount.length) break;
                    temp[index] = discount[index + i];
                    index++;
                    if(index == 10) break;
                }

                if(check(want, temp)) {answer++;
                    System.out.println(i + " " + temp[9]);
                }

                System.out.println("??: " + i);
            }

            return answer;
        }

        public static boolean check(String[] want, String[] temp){
            HashMap<String, Integer> count = new HashMap<>();

            for(int i = 0; i < temp.length; i++){
                count.put(temp[i], count.getOrDefault(temp[i], 0) + 1);
            }

            for(int i = 0; i < want.length; i++){
                if(count.get(want[i]) < map.get(want[i])){
                    return false;
                }
            }

            return true;
        }
//    }
}
