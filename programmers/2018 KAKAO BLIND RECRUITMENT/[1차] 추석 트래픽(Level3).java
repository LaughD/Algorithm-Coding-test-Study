/*
    Code written on Apr 1, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [1차] 추석 트래픽(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/17676
*/
import java.util.Arrays;

class Solution {
    public int solution(String[] lines) {
        TimeLog[] timeLogs = new TimeLog[lines.length * 2];
        int maxThroughput = 0;
        int currentThroughput = 0;
        int index = 0;

        for (String line: lines) {
            setTimeLog(timeLogs, line, index);
            index += 2;
        }

        Arrays.sort(timeLogs);
        for (TimeLog timeLog: timeLogs) {
            if (timeLog.isStartTime()) {
                currentThroughput++;
                if (maxThroughput < currentThroughput)
                    maxThroughput = currentThroughput;
            } else {
                currentThroughput--;
            }
        }

        return maxThroughput;
    }

    public void setTimeLog(TimeLog[] timeLogs, String line, int index) {
        String[] dateTimeLog = line.split(" ");
        String[] timeLog = dateTimeLog[1].split(":");
        float responseTime = 3600 * Float.parseFloat(timeLog[0])
                + 60 * Float.parseFloat(timeLog[1])
                + Float.parseFloat(timeLog[2]);
        float ThroughputTime = Float.parseFloat(
                dateTimeLog[2].substring(0, dateTimeLog[2].length() - 1)
        );
        timeLogs[index] = new TimeLog(responseTime - ThroughputTime + 0.001f, true);
        timeLogs[index + 1] = new TimeLog(responseTime + 0.999f, false);
    }
}

class TimeLog implements Comparable<TimeLog> {
    private final float time;
    private final boolean isStartTime;

    public TimeLog(float time, boolean isStartTime) {
        this.time = time;
        this.isStartTime = isStartTime;
    }

    public boolean isStartTime() { return isStartTime; }

    @Override
    public int compareTo(TimeLog o) {
        if (this.time != o.time) {
            return (int) ((this.time - o.time) * 1000);
        } else {
            return this.isStartTime ? -1 : 1;
        }
    }
}
