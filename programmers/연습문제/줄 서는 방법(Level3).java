/*
    Code written on Mar 29, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    연습문제: 줄 서는 방법(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12936
*/
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> array = new ArrayList<>();
        long[] factorial = getFactorial(n);
        int[] result = new int[n];
        int resultIndex = 0;

        for (int i = 1; i <= n; i++)
            array.add(i);

        k--;
        while (k != 0) {
            int arrayIndex = (int) (k / factorial[--n]);
            result[resultIndex++] = array.get(arrayIndex);
            array.remove(arrayIndex);
            k %= factorial[n];
        }

        for (int i = resultIndex; i < result.length; i++)
            result[i] = array.get(i - resultIndex);

        return result;
    }

    public long[] getFactorial(int n) {
        long[] factorial = new long[n + 1];

        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < factorial.length; i++)
            factorial[i] = factorial[i - 1] * i;

        return factorial;
    }
}
