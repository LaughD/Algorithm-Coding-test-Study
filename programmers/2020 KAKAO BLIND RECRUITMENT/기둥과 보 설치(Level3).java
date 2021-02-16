/*
    Code written on Feb 16, 2021
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 기둥과 보 설치(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60061
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        HashSet<Building> buildings = new HashSet<>();

        for (int[] buildingPlan : build_frame) {
            Building building = new Building(buildingPlan[0], buildingPlan[1], buildingPlan[2]);
            if (buildingPlan[3] == 0) {
                buildings.remove(building);
                if (!canBuild(buildings))
                    buildings.add(building);
            } else {
                buildings.add(building);
                if (!canBuild(buildings))
                    buildings.remove(building);
            }
        }

        return toSortedArray(buildings);
    }

    public boolean canBuild(HashSet<Building> buildings) {
        for (Building building: buildings) {
            Building tempBuilding;
            if (building.type == 0) {
                if (building.y == 0)
                    continue;
                tempBuilding = new Building(building.x, building.y, 1);
                if (buildings.contains(tempBuilding))
                    continue;
                tempBuilding = new Building(building.x - 1, building.y, 1);
                if (buildings.contains(tempBuilding))
                    continue;
                tempBuilding = new Building(building.x, building.y - 1, building.type);
                if (!buildings.contains(tempBuilding))
                    return false;
            } else {
                tempBuilding = new Building(building.x, building.y - 1, 0);
                if (buildings.contains(tempBuilding))
                    continue;
                tempBuilding = new Building(building.x + 1, building.y - 1, 0);
                if (buildings.contains(tempBuilding))
                    continue;;
                tempBuilding = new Building(building.x - 1, building.y, building.type);
                Building tempBuilding2 = new Building(building.x + 1, building.y, building.type);
                if (!(buildings.contains(tempBuilding)) || !(buildings.contains(tempBuilding2)))
                    return false;
            }
        }

        return true;
    }

    public int[][] toSortedArray(HashSet<Building> buildings) {
        Iterator<Building> iterator = buildings.iterator();
        int[][] array = new int[buildings.size()][3];

        for (int i = 0; i < array.length; i++) {
            Building building = iterator.next();
            array[i][0] = building.x;
            array[i][1] = building.y;
            array[i][2] = building.type;
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            if (o1[1] != o2[1])
                return o1[1] - o2[1];
            return o1[2] - o2[2];
        });

        return array;
    }
}

class Building {
    int x;
    int y;
    int type;

    public Building(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        Building building = (Building) o;
        if (x != building.x)
            return false;
        if (y != building.y)
            return false;
        return type == building.type;
    }

    @Override
    public int hashCode() {
        return 100000000 * type + 10000 * x + y;
    }
}
