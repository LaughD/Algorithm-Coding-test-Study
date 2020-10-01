/*
    Code written on Oct 1, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 문자열 압축(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/60057
*/
class Solution {
    public int solution(String s) {
        int halfSize = s.length() / 2;
        int minLength = s.length();

        for (int i = 1; i <= halfSize; i++) {
            String previousString = s.substring(0, i);
            int thisLength = previousString.length();
            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                if (j + i <= s.length()) {
                    String thisString = s.substring(j, j + i);
                    if (previousString.equals(thisString)) {
                        count++;
                    } else if (count != 1) {
                        thisLength += Integer.toString(count).length() + thisString.length();
                        previousString = thisString;
                        count = 1;
                    } else {
                        thisLength += thisString.length();
                        previousString = thisString;
                    }                    
                } else {
                    thisLength += s.substring(j).length();                    
                }
            }
            if (count != 1)
                thisLength += Integer.toString(count).length();
            minLength = Math.min(minLength, thisLength);
        }

        return minLength;
    }
}
