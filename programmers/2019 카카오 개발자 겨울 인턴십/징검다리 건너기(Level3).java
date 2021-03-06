/*
    Code written on Mar 6, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 카카오 개발자 겨울 인턴십: 징검다리 건너기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/64062
*/
class Solution {
    public int solution(int[] stones, int k) {
        int min = 200000000;
        int max = 0;
        
        for (int stone: stones) {
            if (stone > max)
                max = stone;
            if (stone < min)
                min = stone;
        }
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int distance = 1;
            for (int stone: stones) {
                if (stone < mid)
                    distance++;
                else
                    distance = 1;
                if (distance > k) {
                    max = mid - 1;
                    break;
                }
            }
            if (distance <= k)
                min = mid + 1;
        }
        
        return max;
    }
}
