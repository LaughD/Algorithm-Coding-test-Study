/*
    Code written on Nov 17, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    동적계획법(Dynamic Programming): N으로 표현(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/42895
*/
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] memo = new HashSet[9];
        int answer = -1;
        int num = 0;
        for (int i = 1; i < memo.length; i++) {
            memo[i] = new HashSet<Integer>();
            num = num*10 + N;
            memo[i].add(num);
            for (int j = 1; j <= (int)i/2; j++) {
                for (int a: memo[j]) {
                    for (int b: memo[i-j]) {
                        memo[i].add(a + b);
                        memo[i].add(a * b);
                        memo[i].add(a - b);
                        memo[i].add(b - a);
                        if (b != 0)
                            memo[i].add(a / b);
                        if (a != 0)
                          memo[i].add(b / a);
                    }
                }
            }
            if (memo[i].contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
