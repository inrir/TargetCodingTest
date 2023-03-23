package Programmers.sol0326;

import java.util.*;
public class Sol23 {
    class Solution {
        public String[] solution(String[] files) {
            // 영문 대소문자, 숫자, 공백(" "), 마침표("."),  빼기("-")
            // 영문으로 시작, 숫자를 하나 이상 포함. => HEAD, NUMBER, TAIL
            // HEAD 정렬 후, TAIL..

            // String[] answer = {};
            int start = 0;
            int size = 0;

            // HEAD, NUMBER, TAIL로 분리
//         Arrays.sort(files, new Comparator<String>() {
//             @Override
//             public int compare(String s1, String s2){
//                 String[] file1 = seperate(s1);
//                 String[] file2 = seperate(s2);

//                 int head = file1[0].compareTo(file2[0]);
//                 if(head == 0){
//                     int num1 = Integer.parseInt(file1[1]);
//                     int num2 = Integer.parseInt(file2[1]);

//                     return num1 - num2;
//                 }else{
//                     return head;
//                 }
//             }
//         });

            Arrays.sort(files, (o1, o2) -> {
                String[] file1 = seperate(o1);
                String[] file2 = seperate(o2);

                if(file1[0].compareTo(file2[0]) > 0){
                    return 1;
                }else if(file1[0].compareTo(file2[0]) < 0){
                    return -1;
                }else{
                    return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
                }
            });


            return files;
        }

        public String[] seperate(String input){
            String[] answer = new String[3]; // head, number, tail
            int start = 0;
            int size = 0;
            boolean check = true;

            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                    if(check){
                        start = i; // 첫 시작을 담는다.
                        check = false;
                    }
                    size++;
                }else{
                    if(!check) break;
                }
            }
            answer[0] = input.substring(0, start).toLowerCase();
            answer[1] = input.substring(start, start + size);
            answer[2] = input.substring(start + size, input.length());

            return answer;

        }
    }
}
