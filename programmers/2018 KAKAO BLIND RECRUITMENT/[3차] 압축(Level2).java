/*
    Code written on Dec 6, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 압축(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17684
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> listForPrint = new ArrayList<>();
        HashMap<String, Integer> dict = initDict();
        String registeredStr = "";
        String searchingStr;
        int searchingHeadIdx = 0;
        int searchingTailIdx = 1;
        int dictIdx = 27;

        while (searchingTailIdx <= msg.length()) {
            searchingStr = msg.substring(searchingHeadIdx, searchingTailIdx);
            if (dict.containsKey(searchingStr)) {
                searchingTailIdx++;
                registeredStr = searchingStr;
            } else {
                dict.put(searchingStr, dictIdx++);
                listForPrint.add(dict.get(registeredStr));
                searchingHeadIdx = searchingTailIdx - 1;
            }
        }
        listForPrint.add(dict.get(registeredStr));

        return listForPrint.stream().mapToInt(Integer::intValue).toArray();
    }

    public HashMap<String, Integer> initDict() {
        HashMap<String, Integer> dict = new HashMap<>();
        for (int dictIdx = 1; dictIdx < 27; dictIdx++) {
            dict.put(String.valueOf((char) (64+dictIdx)), dictIdx);
        }
        return dict;
    }
}
