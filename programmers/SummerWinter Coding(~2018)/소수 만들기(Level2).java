/*
    Code written on Oct 30, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 소수 만들기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/12977
*/
class Solution {  
    // In this problem, the sum of combinations is always greater than or equal to 6.
    public int solution(int[] nums) {
        int answer = 0;
        return answer += combinationSum(nums, 3, 0, 0);
    }
    
    public int combinationSum(int[] nums, int remainingCount, int numIdx, int sum) {
        if (remainingCount == 0)
            return isPrimeToInt(sum);

        int answer = 0;
        for (int i = numIdx; i < nums.length; i++) {
            sum += nums[i];
            answer += combinationSum(nums, remainingCount-1, i+1, sum);
            sum -= nums[i];
        }
        return answer;
    }
    
    public int isPrimeToInt(int num) {
        if (num % 2 != 0) {
            for (int divNum = 3; divNum < 1 + (int) Math.sqrt(num); divNum+=2)
                if (num % divNum == 0)
                    return 0;
            return 1;
        }
        return 0;
    }
}
