/*
    Code written on Dec 26, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2019 KAKAO BLIND RECRUITMENT: 오픈채팅방(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42888
*/
import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        ArrayDeque<String> accessRecord = new ArrayDeque<>();
        ArrayDeque<String> userRecord = new ArrayDeque<>();
        HashMap<String, String> userInfo = new HashMap<>();
        HashMap<String, String> messageInfo = new HashMap<>();

        messageInfo.put("Enter", "님이 들어왔습니다.");
        messageInfo.put("Leave", "님이 나갔습니다.");

        for (String message: record) {
            String[] words = message.split(" ");
            if (words[0].equals("Enter")) {
                accessRecord.addLast(words[0]);
                userRecord.addLast(words[1]);
                userInfo.put(words[1], words[2]);
            } else if (words[0].equals("Leave")) {
                accessRecord.addLast(words[0]);
                userRecord.addLast(words[1]);
            } else {
                userInfo.put(words[1], words[2]);
            }
        }

        String[] messages = new String[userRecord.size()];
        for (int i = 0; i < messages.length; i++) {
            messages[i] = userInfo.get(userRecord.pollFirst()) 
                    + messageInfo.get(accessRecord.pollFirst());
        }

        return messages;
    }
}
