/*
    Code written on Oct 11, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    깊이/너비 우선 탐색(DFS/BFS): 단어 변환(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/43163
*/
import java.util.ArrayDeque;

class Solution {
    public int solution(String begin, String target, String[] words) {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        boolean[] visited = new boolean[words.length];
        int count = 0;
        
        queue.addLast(begin);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String word = queue.pollFirst();
                if (target.equals(word))
                    return count;
                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && isConvertible(word, words[j])) {
                        visited[j] = true;
                        queue.addLast(words[j]);
                    }
                }
            }
            count++;
        }
        return 0;
    }
    
    public boolean isConvertible(String word1, String word2) {
        int differCount = 0;
        for (int i = 0; i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i))
                differCount++;
        return differCount == 1;
    }
}
