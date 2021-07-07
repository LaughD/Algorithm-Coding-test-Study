/*
    Java Version: Java 8
    Online Judge: Baekjoon OJ, https://www.acmicpc.net
    01713 - 후보 추천하기, https://www.acmicpc.net/problem/1713
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder string = new StringBuilder();
        ArrayList<Student> postedStudents = new ArrayList<>();
        Student[] students = new Student[101];
        boolean[] isPosted = new boolean[101];
        int numOfPhotoFrames = Integer.parseInt(reader.readLine());
        int time = 0;
        reader.readLine();

        for (int studentNumber = 1; studentNumber <= 100; studentNumber++)
            students[studentNumber] = new Student(studentNumber);

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (postedStudents.size() < numOfPhotoFrames) {
            int recommendedStudent = Integer.parseInt(tokenizer.nextToken());
            students[recommendedStudent].numOfRecommendations++;
            if (!isPosted[recommendedStudent]) {
                students[recommendedStudent].postTime = time++;
                isPosted[recommendedStudent] = true;
                postedStudents.add(students[recommendedStudent]);
            }
        }
        Collections.sort(postedStudents);

        numOfPhotoFrames--;
        while (tokenizer.hasMoreTokens()) {
            int recommendedStudent = Integer.parseInt(tokenizer.nextToken());
            students[recommendedStudent].numOfRecommendations++;
            if (!isPosted[recommendedStudent]) {
                Student downedStudent = postedStudents.get(numOfPhotoFrames);
                downedStudent.numOfRecommendations = 0;
                isPosted[downedStudent.studentNumber] = false;
                postedStudents.remove(numOfPhotoFrames);
                students[recommendedStudent].postTime = time++;
                isPosted[recommendedStudent] = true;
                postedStudents.add(students[recommendedStudent]);
            }
            Collections.sort(postedStudents);
        }

        for (int studentNumber = 1; studentNumber <= 100; studentNumber++) {
            if (isPosted[studentNumber]) {
                string.append(studentNumber).append(' ');
                numOfPhotoFrames--;
            }
            if (numOfPhotoFrames < 0)
                break;
        }
        System.out.print(string);
    }
}

class Student implements Comparable<Student> {
    final int studentNumber;
    int numOfRecommendations;
    int postTime;

    public Student(int studentNumber) {
        this.studentNumber = studentNumber;
        this.numOfRecommendations = 0;
    }

    @Override
    public int compareTo(Student student) {
        return this.numOfRecommendations != student.numOfRecommendations ?
                student.numOfRecommendations - this.numOfRecommendations :
                student.postTime - this.postTime;
    }
}
