/*
    Code written on Dec 2, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 다트 게임(Level1)
    link: https://programmers.co.kr/learn/courses/30/lessons/17682
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
        Matcher matcher = Pattern.compile("[0-9]+|[SDT]|[*#]").matcher(dartResult);
        HashMap<String, Integer> exp = new HashMap<>() {{
            put("S", 1);
            put("D", 2);
            put("T", 3);
        }};
        String str;
        int[] scores = new int[4];
        int round = 0;
        
        while (matcher.find()) {
            str = matcher.group();
            if (exp.containsKey(str)) {
                scores[round] = (int) Math.pow(scores[round], exp.get(str));
            } else if (str.equals("*")){
                scores[round-1] *= 2;
                scores[round] *= 2;
            } else if (str.equals("#")) {
                scores[round] *= -1;
            } else {
                scores[++round] = Integer.parseInt(str);
            }
        }
        return Arrays.stream(scores).sum();
    }
}
