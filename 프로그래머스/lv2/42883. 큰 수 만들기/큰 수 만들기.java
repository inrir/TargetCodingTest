class Solution {
    static int max; // 해당 범위의 가장 큰 수를 뽑아내기 위한 방법
    public String solution(String number, int k) {
        // String answer = "";
        StringBuilder st = new StringBuilder();
        // 가장 큰 숫자를 출력하기 위해서는 문자열에서 가장 큰 수 들만 뽑아야 한다. 
        
        int start = 0;
        for(int i = 0; i < number.length() - k; i++){ // number.length() - k 이므로 해당 answer 문자열 길이도 정해진다.
            int max = 0;
            for(int j = start; j <= k + i; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0'; // 해당하는 범위의 최댓값을 담는다.
                    start = j + 1; // 최댓값 이후의 범위를 정하여 다시 탐색한다.
                }
            }
            // answer += max;
            st.append(max);
            
        }
        
        
        
        return st.toString();
    }
    
    
}