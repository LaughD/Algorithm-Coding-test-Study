"""
    Code written on Mar 19, 2021
    출처: Baekjoon OJ, https://www.acmicpc.net
    01826번: 연료 채우기
    link: https://www.acmicpc.net/problem/1826
"""
import heapq
from sys import stdin


def main():
    num_gas_stations = int(stdin.readline())
    gas_station_info = {}    # gas_station_information
    gas_station_locs = []    # gas_station_locations
    fuels = []
    for _ in range(num_gas_stations):
        gas_station_loc, fuel = map(int, stdin.readline().split())
        gas_station_info[gas_station_loc] = fuel
        gas_station_locs.append(gas_station_loc)
    gas_station_locs.sort(reverse=True)

    town_location, movable_distance = map(int, stdin.readline().split())
    num_visited = 0
    while movable_distance < town_location:
        while gas_station_locs and movable_distance >= gas_station_locs[-1]:
            gas_station_loc = gas_station_locs.pop()
            heapq.heappush(fuels, -gas_station_info[gas_station_loc])
        if not fuels:
            num_visited = -1
            break
        movable_distance += -heapq.heappop(fuels)
        num_visited += 1
    print(num_visited)


main()
