/*
    Code written on Dec 21, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(2019): 멀쩡한 사각형(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/62048
*/
class Solution {
    public long solution(int w, int h) {
        return (long) w * (long) h - (w+h) + getGCD(w, h);
    }
    
    public int getGCD(int w, int h) {
        while (h != 0) {
            int temp = h;
            h = w % h;
            w = temp;
        }
        
        return w;
    }
}
