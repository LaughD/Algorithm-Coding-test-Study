/*
    Code written on Apr 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    18429번: 근손실
    link: https://www.acmicpc.net/problem/18429
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] kits;
    private static boolean[] isUsed;
    private static int numOfDays;
    private static int lossPerDay;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfDays = Integer.parseInt(st.nextToken());
        lossPerDay = Integer.parseInt(st.nextToken());

        isUsed = new boolean[numOfDays];
        kits = new int[numOfDays];
        st = new StringTokenizer(br.readLine());
        for (int kitIndex = 0; kitIndex < numOfDays; kitIndex++)
            kits[kitIndex] = Integer.parseInt(st.nextToken());

        System.out.print(calcCases(500, 0));
    }

    public static int calcCases(int currentMuscleMass, int days) {
        if (days == numOfDays)
            return 1;

        int cases = 0;
        days += 1;
        for (int index = 0; index < numOfDays; index++) {
            if (isUsed[index])
                continue;
            int nextMuscleMass = currentMuscleMass - lossPerDay + kits[index];
            if (nextMuscleMass < 500)
                continue;
            isUsed[index] = true;
            cases += calcCases(nextMuscleMass, days);
            isUsed[index] = false;
        }
        return cases;
    }
}
