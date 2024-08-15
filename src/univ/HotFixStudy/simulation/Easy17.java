package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Easy17 {
    /**
     * 백준 1181 단어정렬
     * 조건: 중복 제거, 짧은 길이, 길이 같으면 알파벳 순
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine()); // 갯수

        Set<String> set = new HashSet<>();

        for(int i = 0; i < num; i++){
            set.add(bf.readLine()); // 일단 중복 제거
        }

        String[] nums = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        int index = 0;
        while(iterator.hasNext()){
            nums[index] = iterator.next();
            index++;
        }

        Arrays.sort(nums); // 알파벳 정렬 디폴트
        Arrays.sort(nums, (o1, o2) -> {
//            return o1.compareTo(o2); // 이게 그 알파벳 순으로 조정가능함. 오름차순
            return o1.length() - o2.length();
        });

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }




    }
}
