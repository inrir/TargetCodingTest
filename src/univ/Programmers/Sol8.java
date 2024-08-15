package univ.Programmers;
import java.util.*;

/**
 * 회고 -> 다른 사람 풀이에서 HashSet을 써서 hashset.size()를 통해 추가여부를 판단할 수 있다.(with index)
 * HashMap vs HashSet 둘다 좋은 풀이이며, 내 코드의 경우 if(condition && condition && condition) 으로 해주는 게 좋을 거 같다.
 */
public class Sol8 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            // 1. 한글자인지 확인 2. 중복된 것인지 확인 3. 글자 연결된 것인지 확인.
            HashMap<String, Integer> hashMap = new HashMap<>(); // 중복 조사용
            // 있으면 값 없으면 널.
            int cnt = 1;
            String index;
            index = words[0].substring(words[0].length()-1, words[0].length());
            hashMap.put(words[0], 1);

            for(int i = 1; i < words.length; i++){
                if(((i+1)%n) == 1) cnt++;
                if(words[i].length() == 1){
                    ++i;
                    if(i%n == 0){
                        i = n;
                    }else{
                        i = i%n;
                    }
                    answer[0] = i;
                    answer[1] = cnt;
                    return answer;
                }
                if(hashMap.get(words[i]) != null){
                    ++i;
                    if(i%n == 0){
                        i = n;
                    }else{
                        i = i%n;
                    }
                    answer[0] = i;
                    answer[1] = cnt;
                    return answer;
                }
                if(!index.equals(words[i].substring(0, 1))){
                    ++i;
                    if(i%n == 0){
                        i = n;
                    }else{
                        i = i%n;
                    }
                    answer[0] = i;
                    answer[1] = cnt;
                    return answer;
                }

                index = words[i].substring(words[i].length() - 1, words[i].length());
                hashMap.put(words[i], 1);

            }

            return answer;
        }
    }
}
