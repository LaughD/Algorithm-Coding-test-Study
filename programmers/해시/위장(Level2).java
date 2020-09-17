/*
    Code written on Sep 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 위장(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42578
*/
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
        
        for (String[] cloth: clothes)
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0)+1);
        
        for (Integer value: clothesMap.values())
            answer *= (value+1);
        
        return answer-1;
    }
}
