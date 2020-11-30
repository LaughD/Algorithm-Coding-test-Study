/*
    Code written on Nov 30, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 캐시(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17680
*/
import java.util.ArrayDeque;

class Solution {
    public int solution(int cacheSize, String[] cities) {        
        if (cacheSize == 0)
            return 5 * cities.length;

        ArrayDeque<String> deque = new ArrayDeque<>();
        int runTime = 0;
        for (String city: cities) {
            city = city.toUpperCase();
            if (deque.contains(city)) {
                deque.remove(city);
                deque.addLast(city);
                runTime++;
            } else {
                if (deque.size() == cacheSize)
                    deque.pollFirst();
                deque.addLast(city);
                runTime += 5;
            }
        }
        return runTime;
    }
}
