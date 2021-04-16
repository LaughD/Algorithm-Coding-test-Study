/*
    Code written on Apr 16, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18311번: 왕복
    link: https://www.acmicpc.net/problem/18311
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfCourses = Integer.parseInt(st.nextToken());
        long travelDistance = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] points = new long[numOfCourses + 1];
        for (int index = 1; index <= numOfCourses; index++)
            points[index] = points[index - 1] + Integer.parseInt(st.nextToken());

        if (travelDistance >= points[numOfCourses])
            travelDistance = 2 * points[numOfCourses] - travelDistance - 1;
        int courseNumber = Arrays.binarySearch(points, travelDistance);
        System.out.print(courseNumber >= 0 ? courseNumber + 1: -courseNumber - 1);
    }
}
