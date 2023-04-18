import java.util.*;
class Solution {
    // 얼굴, 상의, 하의, 겉옷
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1); // 의상 종류별로 갯수 0, 1, 2
            if(!list.contains(clothes[i][1])){ // 의상의 종류
                list.add(clothes[i][1]);
            }
        }
        
//         if(list.size() == 1){
//             answer = map.get(list.get(0));
//         }else{
//             int sum = 1;
            
//             for(int i = 0; i < list.size(); i++){
//                 answer += map.get(list.get(i));
//                 sum *= map.get(list.get(i));
//             }
//             answer += sum;
//         }
        // case 1의 경우, 2개의 헤드기어와 1개의 헤드기어 0 1 2 * 0 1 => 3 * 2 - 1(모두 안 입는 경우)
        
//         for(int i = 0; i < list.size(); i++){
//             answer *= map.get(list.get(i));
//         }
        
        // list가 아닌 keySet으로 key 출력 가능
        for(String a : map.keySet()){
            answer *= map.get(a);
            
        }
        
        
        return answer - 1;
    }
}