/*
    Code written on Sep 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    해시: 전화번호 목록(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42577
*/
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i=1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1]))
                return false;
        }
        return true;
    }
}
