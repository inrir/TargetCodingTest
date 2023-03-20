package Programmers.sol0326;

import java.util.*;
public class sol20 {
    class Solution {
        public String[] solution(String[] record) {
            /* HashMap을 통해 key와 이름을 저장한다.
             * int[] 두개로 0: enter, 1: leave 의 경우로 넣고
             * 나머지는 해당하는 인덱스의 이름을 받는다.
             */

            int index = 0; // 배열 2개를 위한 인덱스
            int[] isEnter = new int[record.length];
            String[] isName = new String[record.length];

            HashMap<String, String> hashMap = new HashMap<>(); // uid 1234, Muzi

            for(int i = 0; i < record.length; i++){
                String[] tmp = record[i].split(" ");

                if(tmp[0].equals("Enter")){
                    hashMap.put(tmp[1], tmp[2]); // 실제 아이디와 닉네임을 초기화한다.
                    isEnter[index] = 0;
                    isName[index] = tmp[1];
                    index++;
                }
                else if(tmp[0].equals("Leave")){
                    isEnter[index] = 1;
                    isName[index] = tmp[1];
                    index++;
                }else{
                    hashMap.put(tmp[1], tmp[2]);
                }
            }

            String[] answer = new String[index];

            for(int i = 0; i < index; i++){
                if(isEnter[i] == 0){ // enter
                    answer[i] = hashMap.get(isName[i]) + "님이 들어왔습니다.";
                }else{ // leave
                    answer[i] = hashMap.get(isName[i]) + "님이 나갔습니다.";
                }
            }



            return answer;
        }
    }
}
