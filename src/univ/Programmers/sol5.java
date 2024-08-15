package univ.Programmers;


import java.util.*;
public class sol5 {
    class Solution {
        public int[] solution(String s) {
            int[] answer;
            // solution: a1 a1,a2 a1,a2,a3 a1,a2,a3,a4 => (a1, a2, a3, a4): 개수를 유의해서 본다면
            Set<String> set = new LinkedHashSet<>(); // 중복없이 담아주는 역할.

            String[] tmp = s.substring(1, s.length()-1).split("},");

            for(int i = 0; i < tmp.length; i++){
                tmp[i] = tmp[i].replaceAll("[{}]", ""); // {2 -> 2 or {2, 1 -> 2, 1 or {2,1,3,4} -> 2,1,3,4
            }
            Arrays.sort(tmp,(a,b) -> (a.length() - b.length())); // 길이가 짧은 순서대로 a1 부터

            // 분별작업: 1,2,3,4 -> 1 2 3 4 -> 각자 input
            for(String a : tmp){
                String[] check = a.split(",");
                for(String fin : check){
                    set.add(fin);
                }
            }

            answer = new int[set.size()];
            Iterator<String> iter = set.iterator();
            int index = 0;
            while(iter.hasNext()){ // set을 하나씩 내놓는 역할
                answer[index++] = Integer.parseInt(iter.next());
            }

            return answer;

        }
    }
}
