/*
    Code written on Apr 8, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    19583번: 싸이버개강총회
    link: https://www.acmicpc.net/problem/19583
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> attendance = new HashMap<>();
        String generalAssemblyStart = st.nextToken();
        String generalAssemblyEnd = st.nextToken();
        String streamingEnd = st.nextToken();
        String log;
        int attendees = 0;

        while ((log = br.readLine()) != null) {
            st = new StringTokenizer(log);
            String time = st.nextToken();
            String name = st.nextToken();
            if (time.compareTo(streamingEnd) > 0) {
                break;
            } else if (time.compareTo(generalAssemblyStart) <= 0) {
                attendance.put(name, time);
            } else if (time.compareTo(generalAssemblyEnd) >= 0 
                    && time.compareTo(streamingEnd) <= 0) {
                if (attendance.containsKey(name)) {
                    attendance.remove(name);
                    attendees++;
                }
            }
        }
        System.out.print(attendees);
    }
}
