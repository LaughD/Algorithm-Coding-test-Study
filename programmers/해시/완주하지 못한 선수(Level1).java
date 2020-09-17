/*
    Code written on Sep 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 완주하지 못한 선수(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/42576
*/
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participants = new HashMap<String, Integer>();
        
        for (String player: participant)
            participants.put(player, participants.getOrDefault(player, 0)+1);
        
        for (String player: completion) {
            participants.put(player, participants.get(player)-1);
            if (participants.get(player) == 0) {
                participants.remove(player);
            }
        }
        
        Iterator<String> iterator = participants.keySet().iterator();
        return iterator.next();
    }
}
