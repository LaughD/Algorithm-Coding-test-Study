/*
    Code written on Dec 5, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 스킬트리(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/49993
*/
class Solution {
    public int solution(String skill, String[] skill_trees) {
        String pattern = "[^" + skill + ']';
        int possibleCase = 0;
        
        for (String skill_tree: skill_trees) {
            if (skill.startsWith(skill_tree.replaceAll(pattern, ""))) {
                possibleCase++;
            }
        }
        
        return possibleCase;
    }
}
