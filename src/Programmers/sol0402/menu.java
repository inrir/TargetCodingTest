package Programmers.sol0402;
import java.util.*;

public class menu {
    public static void main(String[] args) {
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2,3,4};
        int[] course = {2,3,4};
        /**
         * 문자열 성분 확인하기?? => 성분 순서 문제로 다르다.
         */

        System.out.println(solution(orders, course));
    }
    static HashMap<String, Integer> hashmap; // 단품의 조합을 만든다.
    // static int[] arr; // 가진 n개의 배열
    static HashMap<Integer, Integer> maxmap; // 2: max = 길이 : 최고 숫자
    static String[] result; // 추출된 r개를 말한다.
    static int n, r; // n개에서 r개를 추출한다.
    public static String[] solution(String[] orders, int[] course) {

        // 각 손님의 조합을 만들고 담아야할 거 같다.
        String[] answer = {};
        hashmap = new HashMap<>(); // 선언의 중요성
        maxmap = new HashMap<>();

        int index = 0; // orders를 뽑아내는 인덱스
        while(index != orders.length){ // hashmap에 모두 넣어버리기
            if(index == orders.length){
                break;
            }
            for(int i = 2; i <= orders.length; i++){
                n = orders[index].length();
                result = new String[i];
                r = i;
                // 문자열 정리하는 기법 암기!!!!
                char[] pass = orders[index].toCharArray();
                Arrays.sort(pass);
                String input = String.valueOf(pass);
                combination(input, 0, 0);

            }
            index++;

        }
        System.out.println("???");

        List<String> list = new ArrayList<>();
        Set<String> keySet = hashmap.keySet();
        for(int i = 0; i < course.length; i++){ // 2, 3, 4
            for(String key : keySet){
                if(key.length() == course[i] && hashmap.get(key) == maxmap.get(course[i]) && hashmap.get(key) >= 2){ // 최소 규칙보다 높아진다.
//                        System.out.println(maxmap.get(course[i]));
                    list.add(key);
//                        System.out.println(key + " !! " + hashmap.get(key));

                }
            }
        }
        Collections.sort(list);
        answer = new String[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }


        return answer;
    }

    private static void combination(String input, int cnt, int idx) {
        // 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == r) {
            String tmp = "";
            for(String i : result){
                tmp += i;
            }
            System.out.println(tmp + "!!");
            hashmap.put(tmp, hashmap.getOrDefault(tmp, 0) + 1); // 값 넣어주기
            maxmap.put(tmp.length(), Math.max(hashmap.get(tmp), maxmap.getOrDefault(tmp.length(), 0)));
            return;
        }
        // 대상 집합을 주어진 인덱스부터 순회하며 숫자를 하나 선택한다.
        for (int i = idx; i < n; i++) {
            // 숫자를 담는다.
            result[cnt] = input.charAt(i) + "";
            // 자신을 재귀 호출한다(자신 이전의 수를 중복 선택하지 않도록 인덱스를 +1하여 재귀를 호출한다).
            combination(input, cnt + 1, i + 1);
        }
    }
}
