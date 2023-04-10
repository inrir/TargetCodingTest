class Solution {
    public int solution(String s) {
        int answer = s.length();
        // 단위별로 자르면 문자열의 개수가 줄어든다. -> 어떤 단위가 제일 압축 정도가 높은지 확인.
        // 2a2ba3c => 7 숫자 포함한 길이 출력.
        // 문자열의 절반 길이까지 단위로 자를 수 있다. 
        for(int i = 1; i <= s.length()/2; i++){
            answer = Math.min(answer, getLength(s, i).length());
        }
        
        
        return answer;
    }
    public String getLength(String s, int size){
        StringBuilder result = new StringBuilder();
        
        String start = s.substring(0, size);
        int count = 1; // 중복된 것이 몇 개 생기는 지 확인하기 위한 용도
        for(int j = size; j <= s.length(); j+= size){
            String next = s.substring(j, Math.min(j+size, s.length())); // 다음 생길 것을 고려
            
            if(start.equals(next)){
                count++; // 동일한게 발생할 때마다 증가
            }else{ // 동일하지 않은 것이 발생한다면
                result.append((count != 1? count : "") + start); // aaa -> 3a
                start = next; // b
                count = 1; // 중복 카운트 다시
            }  
        }
        result.append(start); // 의미 생각하기
        return result.toString();
    }
}