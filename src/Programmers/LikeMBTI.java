package Programmers;

import java.util.*;

public class LikeMBTI {
    class Solution { // 성격유형 검사하기
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            HashMap<String, Integer> hashMap = new HashMap<>();

            hashMap.put("R", 0);
            hashMap.put("T", 0);
            hashMap.put("C", 0);
            hashMap.put("F", 0);
            hashMap.put("J", 0);
            hashMap.put("M", 0);
            hashMap.put("A", 0);
            hashMap.put("N", 0);

            for(int i = 0; i < survey.length; i++){
                String first = survey[i].substring(0,1);
                String second = survey[i].substring(1);
                switch(choices[i]){
                    case 1:
                        hashMap.put(first, hashMap.get(first) + 3);
                        break;
                    case 2:
                        hashMap.put(first, hashMap.get(first) + 2);
                        break;
                    case 3:
                        hashMap.put(first, hashMap.get(first) + 1);
                        break;
                    case 4: // nothing
                        break;
                    case 5:
                        hashMap.put(second, hashMap.get(second) + 1);
                        break;
                    case 6:
                        hashMap.put(second, hashMap.get(second) + 2);
                        break;
                    case 7:
                        hashMap.put(second, hashMap.get(second) + 3);
                        break;
                    default:
                        break;
                }
            }

            if(hashMap.get("R") >= hashMap.get("T")){
                answer += "R";
            }else{
                answer += "T";
            }

            if(hashMap.get("C") >= hashMap.get("F")){
                answer += "C";
            }else{
                answer += "F";
            }
            if(hashMap.get("J") >= hashMap.get("M")){
                answer += "J";
            }else{
                answer += "M";
            }
            if(hashMap.get("A") >= hashMap.get("N")){
                answer += "A";
            }else{
                answer += "N";
            }

            return answer;
        }
    }
}
