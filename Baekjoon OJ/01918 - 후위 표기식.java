/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01918 - 후위 표기식, https://www.acmicpc.net/problem/1918
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder string = new StringBuilder();
        HashMap<Character, Integer> operatorPriority = new HashMap<>();
        char[] stack = new char[50];
        int stackHead = -1;

        operatorPriority.put('(', 0);
        operatorPriority.put('-', 1);
        operatorPriority.put('+', 1);
        operatorPriority.put('*', 2);
        operatorPriority.put('/', 2);

        for (char character: reader.readLine().toCharArray()) {
            if (Character.isAlphabetic(character)) {
                string.append(character);
            } else if (character == ')') {
                while (stack[stackHead] != '(')
                    string.append(stack[stackHead--]);
                stackHead--;
            } else if (character == '(') {
                stack[++stackHead] = character;
            } else {
                int priority = operatorPriority.get(character);
                while (stackHead >= 0 && operatorPriority.get(stack[stackHead]) >= priority)
                    string.append(stack[stackHead--]);
                stack[++stackHead] = character;
            }
        }
        while (stackHead >= 0)
            string.append(stack[stackHead--]);

        System.out.print(string);
    }
}
