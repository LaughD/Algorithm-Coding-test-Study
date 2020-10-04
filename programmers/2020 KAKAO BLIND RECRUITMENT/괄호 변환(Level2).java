/*
    Code written on Oct 4, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 괄호 변환(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/60058
*/
class Solution {
    public String solution(String p) {
        if (p.equals(""))
            return p;
        
        String[] uv = new String[2];
        uv = separateString(p);
        
        if (isCorrect(uv[0])) {
            return uv[0] + solution(uv[1]);
        } else {
            uv[1] = '(' + solution(uv[1]) + ')';
            return uv[1] + reverseString(uv[0].substring(1, uv[0].length()-1));
        }
    }

    public String[] separateString(String p) {
        String[] uv = new String[2];
        int sign = 0;
        
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                sign++;
            else
                sign--;
            if (sign == 0) {
                uv[0] = p.substring(0, i+1);
                uv[1] = p.substring(i+1);
                break;
            }
        }
        return uv;
    }

    public boolean isCorrect(String u) {
        int sign = 0;
        
        for (char character: u.toCharArray()) {
            if (character == '(')
                sign++;
            else
                sign--;
            if (sign < 0)
                return false;
        }
        return true;
    }

    public String reverseString(String u) {
        char[] newStr = new char[u.length()];
        
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == ')')
                newStr[i] = '(';
            else
                newStr[i] = ')';
        }
        return String.valueOf(newStr);
    }
}
