import java.util.*;
class Solution {
    static List<Long> OprandList;
    static List<String> OperatorList;
    static StringBuilder tmp; 
    static Long max = 0L;
    static String express; // expression 담아주는 통

    public long solution(String expression) {
        // long answer = 0;
        // expression = expression;
        express = expression;
        permutation(0, 3, new String[]{"+", "-", "*"}, new boolean[3], "");
        
        return max;
    }
    public void permutation(int start, int end, String[] operator, boolean[] check, String result){ // 순열 함수
        if(start == end){
            calc(result);
        }
        
        for(int i = 0; i < 3; i++){
            if(!check[i]){
                check[i] = true;
                
                permutation(start+1, end, operator, check, result + operator[i]);
                
                check[i] = false;
            }
        }
    }
    
    public void calc(String operator){
        
        tmp = new StringBuilder();
        OprandList = new ArrayList<>();
        OperatorList = new ArrayList<>();
        
        for(int i = 0; i < express.length(); i++){ // 문자와 숫자 분리
            if(express.charAt(i) == '+' || express.charAt(i) == '-' || express.charAt(i) == '*'){
                OprandList.add(Long.parseLong(tmp.toString()));
                tmp = new StringBuilder();
                OperatorList.add(String.valueOf(express.charAt(i)));
            }else{
                tmp.append(express.charAt(i));
            }
        }
        
        OprandList.add(Long.parseLong(tmp.toString()));
        
        
        for(int i = 0; i < operator.length(); i++){ // 분리된 형식으로 계싼
            String tmp = String.valueOf(operator.charAt(i));
            
            while(OperatorList.size() != 0){
                int index = OperatorList.indexOf(tmp);
                
                if(index == -1){
                    break;
                }else{
                    switch(tmp){
                        case "+":
                            OprandList.add(index, OprandList.get(index) + OprandList.get(index+1));
                            break;
                        case "-":
                            OprandList.add(index, OprandList.get(index) - OprandList.get(index+1));
                            break;
                        case "*":
                            OprandList.add(index, OprandList.get(index) * OprandList.get(index + 1));
                            break;
                            
                    }
                    OprandList.remove(index + 1);
                    OprandList.remove(index + 1);
                    
                    OperatorList.remove(index);
                    
                }
                
            }
        }
        max = Math.max(max, Math.abs(OprandList.get(0)));
    }
    
}

/*
* +,-,* 연산에 대한 순열로 값 옮기기.
* 순열된 경우에 대해서 하나씩 연산
* 최대 값을 추리기
*/