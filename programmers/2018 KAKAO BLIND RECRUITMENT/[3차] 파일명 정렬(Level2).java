/*
    Code written on Dec 12, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 파일명 정렬(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17686
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([^0-9]+)([0-9]{1,5}).*");
        HashMap<String, Integer> eachStrIndex = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            eachStrIndex.put(files[i], i);
        }

        Arrays.sort(files, (prevStr, curStr) -> {
            Matcher prevMatcher = pattern.matcher(prevStr);
            Matcher curMatcher = pattern.matcher(curStr);
            prevMatcher.find();
            curMatcher.find();
            String[] heads = {prevMatcher.group(1), curMatcher.group(1)};
            int[] bodies = {Integer.parseInt(prevMatcher.group(2)), 
                            Integer.parseInt(curMatcher.group(2))};
            int[] indexes = {eachStrIndex.get(prevStr), eachStrIndex.get(curStr)};
            if (!heads[0].equalsIgnoreCase(heads[1])) {
                return heads[0].compareToIgnoreCase(heads[1]);
            } else if (bodies[0] != bodies[1]) {
                return bodies[0] - bodies[1];
            } else {
                return indexes[0] - indexes[1];
            }
        });

        return files;
    }
}
