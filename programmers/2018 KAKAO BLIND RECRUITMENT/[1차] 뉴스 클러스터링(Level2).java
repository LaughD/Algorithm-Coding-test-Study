/*
    Code written on Dec 1, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 뉴스 클러스터링(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17677
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        String[] setOne = makeMultiset(str1);
        String[] setTwo = makeMultiset(str2);
        int unionLength = 0;
        int interLength = 0;
        int idxOne = 0;
        int idxTwo = 0;
        
        Arrays.sort(setOne);
        Arrays.sort(setTwo);
        while (idxOne != setOne.length && idxTwo != setTwo.length) {
            if (setOne[idxOne].compareTo(setTwo[idxTwo]) < 0) {
                idxOne++;
            } else if (setOne[idxOne].compareTo(setTwo[idxTwo]) > 0) {
                idxTwo++;
            } else {
                idxOne++;
                idxTwo++;
                interLength++;
            }
            unionLength++;
        }
        unionLength += setOne.length - idxOne;
        unionLength += setTwo.length - idxTwo;
        
        return unionLength == 0 ? 65536 : 65536*interLength/unionLength;
    }

    public String[] makeMultiset(String str) {
        ArrayList<String> multiset = new ArrayList<>();
        String pattern = "[A-Z]{2}";
        String subString;
        str = str.toUpperCase();
        for (int i = 1; i < str.length(); i++) {
            subString = str.substring(i-1, i+1);
            if (Pattern.matches(pattern, subString))
                multiset.add(subString);
        }
        return multiset.toArray(new String[0]);
    }
}
