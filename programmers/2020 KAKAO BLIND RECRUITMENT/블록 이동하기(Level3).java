/*
    Code written on Feb 22, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 블록 이동하기(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60063
*/
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    ArrayDeque<Robot> queue = new ArrayDeque<>();
    HashSet<Robot> pastRobots = new HashSet<>();
    Robot arrivedRobotCaseOne;
    Robot arrivedRobotCaseTwo;
    int[][] newBoard;

    public int solution(int[][] board) {
        int movements = 0;
        int boardSize = board.length;
        int boardSizePlusOne = boardSize + 1;

        arrivedRobotCaseOne = new Robot(boardSize, boardSize, 0);
        arrivedRobotCaseTwo = new Robot(boardSize, boardSize, 1);

        newBoard = new int[boardSize + 2][boardSize + 2];
        Arrays.fill(newBoard[0], 1);
        newBoard[boardSizePlusOne] = newBoard[0];
        for (int i = 1; i < boardSizePlusOne; i++)
            newBoard[i][0] = newBoard[i][boardSizePlusOne] = 1;
        for (int i = 0; i < boardSize; i++)
            System.arraycopy(board[i], 0, newBoard[i + 1], 1, boardSize);

        addIfItMeets(new Robot(1, 2, 0));
        mainLoop:
        while (!queue.isEmpty()) {
            movements++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                moveRobot(queue.pollFirst());
                if (isArrived())
                    break mainLoop;
            }
        }
        return movements;
    }

    public void moveRobot(Robot robot) {
        int y = robot.y;
        int x = robot.x;
        if (robot.shape == 0) {
            if (newBoard[y][x - 2] == 0)
                addIfItMeets(new Robot(y, x - 1,0));
            if (newBoard[y][x + 1] == 0)
                addIfItMeets(new Robot(y, x + 1, 0));
            if (newBoard[y - 1][x] == 0 && newBoard[y - 1][x - 1] == 0) {
                addIfItMeets(new Robot(y - 1, x, 0));
                addIfItMeets(new Robot(y, x, 1));
                addIfItMeets(new Robot(y, x - 1, 1));
            }
            if (newBoard[y + 1][x] == 0 && newBoard[y + 1][x - 1] == 0) {
                addIfItMeets(new Robot(y + 1, x, 0));
                addIfItMeets(new Robot(y + 1, x - 1, 1));
                addIfItMeets(new Robot(y + 1, x, 1));
            }
        } else {
            if (newBoard[y - 2][x] == 0)
                addIfItMeets(new Robot(y - 1, x, 1));
            if (newBoard[y + 1][x] == 0)
                addIfItMeets(new Robot(y + 1, x, 1));
            if (newBoard[y][x - 1] == 0 && newBoard[y - 1][x - 1] == 0) {
                addIfItMeets(new Robot(y, x - 1, 1));
                addIfItMeets(new Robot(y, x, 0));
                addIfItMeets(new Robot(y - 1, x, 0));
            }
            if (newBoard[y][x + 1] == 0 && newBoard[y - 1][x + 1] == 0) {
                addIfItMeets(new Robot(y, x + 1, 1));
                addIfItMeets(new Robot(y, x + 1, 0));
                addIfItMeets(new Robot(y - 1, x + 1, 0));
            }
        }
    }

    public void addIfItMeets(Robot robot) {
        if (!pastRobots.contains(robot)) {
            queue.addLast(robot);
            pastRobots.add(robot);
        }
    }

    public boolean isArrived() {
        return pastRobots.contains(arrivedRobotCaseOne) ||
                pastRobots.contains(arrivedRobotCaseTwo);
    }

    static class Robot {
        /*
            if shape is 0:
                The robot is straight in the horizontal.
                y and x are the coordinates of the right wheel.
            if shape is 1:
                The robot is straight in the longitudinal.
                y and x are the coordinates of the lower wheel.
         */
        public int y;
        public int x;
        public int shape;

        public Robot(int y, int x, int shape) {
            this.y = y;
            this.x = x;
            this.shape = shape;
        }

        @Override
        public boolean equals(Object o) {
            Robot robot = (Robot) o;
            if (this.x != robot.x)
                return false;
            if (this.y != robot.y)
                return false;
            return this.shape == robot.shape;
        }

        @Override
        public int hashCode() {
            return 1000000 * shape + 1000 * y + x;
        }
    }
}
