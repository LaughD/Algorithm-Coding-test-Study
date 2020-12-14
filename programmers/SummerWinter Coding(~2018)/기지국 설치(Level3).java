/*
    Code written on Dec 14, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    Summer/Winter Coding(~2018): 기지국 설치(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/12979
*/
class Solution {
    public int solution(int n, int[] stations, int w) {
        int spreadRange = w*2 + 1;
        int necessaryStations = 0;
        int areaLeftEnd = 1;

        for (int station: stations) {
            necessaryStations += calcDemand(station-w-areaLeftEnd, spreadRange);
            areaLeftEnd = station + w + 1;
        }
        necessaryStations += calcDemand(n+1-areaLeftEnd, spreadRange);

        return necessaryStations;
    }

    public int calcDemand(int areaWidth, int spreadRange) {
        if (areaWidth > 0) {
            return (areaWidth % spreadRange) == 0 ?
                    (areaWidth / spreadRange) : (1 + (areaWidth / spreadRange));
        }
        return 0;
    }
}
