/*
    Code written on Dec 18, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    이분탐색: 징검다리(Level4)
    link: https://programmers.co.kr/learn/courses/30/lessons/43236
*/
import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int minDistance = 1;
        int maxDistance = distance;
        int maxOfMinDistance = distance;
        
        Arrays.sort(rocks);
        while (minDistance <= maxDistance) {
            int midDistance = (minDistance + maxDistance) / 2;
            int starting = 0;
            int removed = 0;
            for (int rock: rocks) {
                if (rock - starting < midDistance) {
                    removed++;
                } else {
                    starting = rock;
                }
            }
            if (distance - starting < midDistance) {
                removed++;
            }
            if (removed > n) {
                maxDistance = midDistance - 1;
            } else {
                maxOfMinDistance = midDistance;
                minDistance = midDistance + 1;
            }            
        }
        
        return maxOfMinDistance;
    }
}
