/*
    Code written on Sep 22, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    정렬: 가장 큰 수(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42746
*/
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(Integer::toString).toArray(String[]::new);
        
        Arrays.sort(stringNumbers, (num1, num2) -> -(num1 + num2).compareTo(num2 + num1));

        return stringNumbers[0].equals("0") ? "0" : String.join("", stringNumbers);
    }
}
