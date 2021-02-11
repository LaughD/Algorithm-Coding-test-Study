/*
    Code written on Feb 11, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    10825번: 국영수
    link: https://www.acmicpc.net/problem/10825
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Student> reportCards = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            reportCards.add(new Student(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        for (int i = 0; i < n; i++)
            sb.append(reportCards.poll().name).append("\n");
        System.out.print(sb);
    }

    private static class Student implements Comparable<Student> {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            if (this.koreanScore != o.koreanScore) {
                return o.koreanScore - this.koreanScore;
            } else if (this.englishScore != o.englishScore) {
                return this.englishScore - o.englishScore;
            } else if (this.mathScore != o.mathScore) {
                return o.mathScore - this.mathScore;
            }
            return this.name.compareTo(o.name);
        }
    }
}
