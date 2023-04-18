class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] tmp = s.split(" ");
        for(int i = 0; i < tmp.length; i++){
            int value = Integer.parseInt(tmp[i]);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        
        answer += min + " " + max;
        return answer;
    }
}