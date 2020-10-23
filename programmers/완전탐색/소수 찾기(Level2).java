/*
    Code written on Oct 23, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    완전탐색: 소수 찾기(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/42839
*/
import java.util.HashSet;

class Solution {
    HashSet<Integer> numberSet = new HashSet<Integer>();
    boolean[] visited;

    public int solution(String numbers) {    
        int answer = 0;
        visited = new boolean[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) {
            char[] selected = new char[i];
            findNumbers(numbers.length(), i, 0, numbers, selected);
        }
        for (int number: numberSet)
            if (isPrime(number))
                answer++;
        return answer;
    }

    public void findNumbers(int n, int r, int s, String numbers, char[] selected) {
        if (r == s) {
            numberSet.add(Integer.parseInt(String.valueOf(selected)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[s] = numbers.charAt(i);
                findNumbers(n, r, s+1, numbers, selected);
                visited[i] = false;
            }
        }        
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i < Math.sqrt(n)+1; i+=2)
                if (n % i == 0)
                    return false;
        }
        return true;
    }
}
