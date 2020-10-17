/*
    Code written on Oct 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 최댓값과 최솟값(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12939
*/
class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max, min;
        max = min = Integer.parseInt(nums[0]);
        for (String num: nums) {
            int thisNum = Integer.parseInt(num);
            if (max < thisNum)
                max = thisNum;
            if (min > thisNum)
                min = thisNum;
        }

        return min + " " + max;
    }
}
