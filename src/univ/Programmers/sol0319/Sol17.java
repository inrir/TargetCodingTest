package univ.Programmers.sol0319;

import java.util.*;
public class Sol17 {
// [3차] 압축

    class Solution {
        public int[] solution(String msg) {
            ArrayList<Integer> array = new ArrayList<>();
            HashMap<String, Integer> hashMap = new HashMap<>();
            // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
            // 처음 A-Z까지 초기화 시킴.
            char ch = 'A';
            for(int i = 1; i<27; i++){
                hashMap.put(ch+"", i);
                ch++;
            }
            int index = 27;

            // 2. 사전에 내용을 넣으면서 가장 긴 문자열을 탐색하도록 한다.
            boolean endPoint = false;
            for(int i = 0; i < msg.length(); i++){
                String word = msg.charAt(i) + "";

                while(hashMap.containsKey(word)){ // 끝에 도달한 경우
                    i++;
                    if(i == msg.length()){
                        endPoint = true;
                        break;
                    }
                    word += msg.charAt(i);
                }
                if(endPoint){
                    array.add(hashMap.get(word));
                    break;
                }

                // 현재 word에는 지금 사전에 넣을 단어이므로 뒤에서 문자 하나를 제거해야 사전에 넣을 수 있다.

                array.add(hashMap.get(word.substring(0, word.length() - 1)));
                // 지속적으로 나온 값을 넣는 것
                hashMap.put(word, index++);
                // 단어를 만들면서 다음 문자를 가리키고 있기에 -1 해준다.
                i--;

            }


            int[] answer = new int[array.size()];

            for(int i = 0; i < array.size(); i++){
                answer[i] = array.get(i);
            }

            return answer;
        }
    }
}
