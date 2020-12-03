/*
    Code written on Dec 3, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 셔틀버스(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/17678
*/
import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        int numberOfCrew = timetable.length;
        for (int i = timetable.length-1; i > -1; i--) {
            if (timetable[i].equals("24:00")) {
                numberOfCrew--;
            } else {
                break;
            }
        }

        LocalTime[] crewArrTimes = IntStream.range(0, numberOfCrew).
                mapToObj(i -> LocalTime.of(
                        Integer.parseInt(timetable[i].substring(0, 2)),
                        Integer.parseInt(timetable[i].substring(3, 5)))).
                toArray(LocalTime[]::new);
        LocalTime busDepTime;
        LocalTime conArrTime;
        int order = 0;
        int spareSeat = 0;

        MainLoop:
        for (int i = 0; i < n; i++) {
            busDepTime = LocalTime.of(9, 0).plusMinutes((long) t*i);
            spareSeat = m;
            for (int j = 0; j < m; j++) {
                if (order == crewArrTimes.length) {
                    break MainLoop;
                } else if (busDepTime.isBefore(crewArrTimes[order])) {
                    break;
                }
                order++;
                spareSeat--;
            }
        }
        if (spareSeat == 0) {
            conArrTime = crewArrTimes[order-1].minusMinutes(1);
        } else {
            conArrTime = LocalTime.of(9, 0).plusMinutes((long) t*(n-1));
        }

        return conArrTime.toString();
    }
}
