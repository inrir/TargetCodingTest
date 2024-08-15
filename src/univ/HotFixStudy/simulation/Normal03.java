package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Normal03 {
    /**
     * 백준 2910 빈도정렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] nums = new String[N];

        // Hashmap으로 값 다 넣고.
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N; i++){
            nums[i] = st.nextToken();
            hashMap.put(Integer.parseInt(nums[i]), hashMap.getOrDefault(Integer.parseInt(nums[i]), 0) + 1);
        }


        // Arrays.sort 정렬시 사용하면 될거 같은데?

        Arrays.sort(nums, (O1, O2) -> {
            return hashMap.get(Integer.parseInt(O2)) - hashMap.get(Integer.parseInt(O1));
        }); // 순서는 맞다.!!

        // 33 25 25 33 -> 33 33 25 25로 바꿔줘야 한다.

        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++){ // 중복을 제외한 형태로 넣고 hashMap 개수대로 넣기
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }


        for(int i = 0; i < list.size(); i++){
            for(int j = 0 ; j < hashMap.get(Integer.parseInt(list.get(i))); j++){
                System.out.print(list.get(i) + " ");
            }
        }



    }
}
