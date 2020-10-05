/*
    Code written on Oct 5, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 타겟 넘버(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/43165
*/
class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int sum, int count) {
        if (count == numbers.length) {
            if (sum == target)
                return 1;
            return 0;
        }
        return dfs(numbers, target, sum+numbers[count], count+1) + dfs(numbers, target, sum-numbers[count], count+1);
    }
}
