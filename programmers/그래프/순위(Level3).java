/*
    Code written on Dec 19, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    그래프: 순위(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/49191
*/
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] results) {
        // Each key of "higher" is weaker than the players in each HashSet.
        // Each key in "lower" is stronger than the players in each HashSet.
        HashMap<Integer, HashSet<Integer>> higher = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> lower = new HashMap<>();
        int numOpposing = n - 1;
        int ranked = 0;

        for (int i = 1; i <= n; i++ ){
            higher.put(i, new HashSet<>());
            lower.put(i, new HashSet<>());
        }
        
        for (int[] result: results) {
            higher.get(result[1]).add(result[0]);
            lower.get(result[0]).add(result[1]);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int player: higher.get(i)) {
                lower.get(player).addAll(lower.get(i));
            }
            for (int player: lower.get(i)) {
                higher.get(player).addAll(higher.get(i));
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (higher.get(i).size() + lower.get(i).size() == numOpposing) {
                ranked++;
            }
        }
        
        return ranked;
    }
}
