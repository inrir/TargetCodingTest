import java.util.*;
class Solution {
    // 끝이 없는 0 부분과 끝점이 결합된 형식으로 진행해야한다.
    // 총 길이만큼 진행하면 될거 같다.
    static int answer;
    // static List<Integer> list;
    static Set<Integer> set;
    public int solution(int[] elements) {
        answer = 0;
        // list = new ArrayList<>(); // 중복된 값에 대해서 방지하는 역할
        set = new HashSet<>();
        for(int i = 0; i < elements.length; i++){ // 하나의 cycle을 돌아야한다.
            check(i + 1 , elements);
        }
        return set.size();
    }
    
    public void check(int i, int[] elements){
        int len = elements.length;
        for(int k = 0; k < len; k++){
            int value = 0;
            for(int j = k; j < k + i; j++){
                value += elements[j % len];
            }
            // System.out.println(value + " " + answer + " " + k);
            // if(!list.contains(value)) answer++;
            // list.add(value);
            set.add(value);
        }
        
    }
}