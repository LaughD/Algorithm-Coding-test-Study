/*
    Code written on Dec 7, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2018 KAKAO BLIND RECRUITMENT: [3차] 방금그곡(Level2)
    link: https://programmers.co.kr/learn/courses/30/lessons/17683
*/
class Solution {
    public String solution(String m, String[] musicinfos) {
        StringBuilder sb = new StringBuilder();
        String findingMelody = convertMelody(m);
        String findingTitle = "(None)";
        String[] musicDetails;
        String musicMelody;
        int musicPlayTime;
        int longestPlayTime = 0;

        for (String musicinfo: musicinfos) {
            musicDetails = musicinfo.split(",");
            musicPlayTime = convertTimeToSec(musicDetails[0], musicDetails[1]);
            if (longestPlayTime < musicPlayTime) {
                musicMelody = melodyExtend(
                        convertMelody(musicDetails[3]), musicPlayTime, sb);
                sb.delete(0, sb.length());
                if (musicMelody.contains(findingMelody)) {
                    findingTitle = musicDetails[2];
                    longestPlayTime = musicPlayTime;
                }
            }
        }

        return findingTitle;
    }

    public String melodyExtend(String melody, int musicPlayTime, StringBuilder sb) {
        int repetition = musicPlayTime / melody.length();
        int remainder = musicPlayTime % melody.length();

        sb.append(melody.repeat(Math.max(0, repetition)));
        if (remainder != 0) {
            sb.append(melody, 0, remainder);
        }

        return sb.toString();
    }

    public int convertTimeToSec(String start, String end) {
        return 60 * (Integer.parseInt(end.substring(0, 2)) -
                Integer.parseInt(start.substring(0, 2)))
                +
                (Integer.parseInt(end.substring(3, 5)) -
                        Integer.parseInt(start.substring(3, 5)));
    }

    public String convertMelody(String melody) {
        melody = melody.replace("A#", "H");
        melody = melody.replace("C#", "I");
        melody = melody.replace("D#", "J");
        melody = melody.replace("F#", "K");
        melody = melody.replace("G#", "L");

        return melody;
    }
}
