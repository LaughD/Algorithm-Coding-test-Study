/*
    Code written on Sep 25, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    탐욕법(Greedy): 구명보트(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42885
*/
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0, frontIdx = 0, backIdx = people.length-1;
        Arrays.sort(people);

        while (frontIdx <= backIdx) {
            if (people[frontIdx] + people[backIdx] <= limit)
                frontIdx++;
            backIdx--;
            boat++;
        }

        return boat;
    }
}
