/*
    Code written on Jan 12, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    찾아라 프로그래밍 마에스터: 폰켓몬(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/1845
*/
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> species = new HashSet<>();
        
        for (int num: nums)
            species.add(num);
        
        return Math.min(species.size(), nums.length/2);
    }
}
