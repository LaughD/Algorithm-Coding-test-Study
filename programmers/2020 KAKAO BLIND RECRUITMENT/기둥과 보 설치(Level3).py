'''
    Code written on Sep 9, 2020
    출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
    2020 KAKAO BLIND RECRUITMENT: 기둥과 보 설치(Level3)
    link: https://programmers.co.kr/learn/courses/30/lessons/60061
'''
'''
    개선된 코드(삭제할 때만 반복 시행)
'''
def check_condition(x, y, kind, building):
    if kind:    # beam
        if (x,y-1,0) not in building and (x+1,y-1,0) not in building and \
                ((x-1,y,1) not in building or (x+1,y,1) not in building):
            return False
    else:       # column
        if y and (x-1,y,1) not in building and \
                (x,y,1) not in building and (x,y-1,0) not in building:
            return False
    return True

def solution(n, build_frame):
    building = set()
    for x, y, kind, construction in build_frame:
        if construction:    
            if check_condition(x, y, kind, building):
                building.add((x, y, kind))
        else:
            building.remove((x, y, kind))
            for x_, y_, kind_ in building:
                if not check_condition(x_, y_, kind_, building):
                    building.add((x, y, kind))
                    break
    building = map(list, building)
    return sorted(building)


'''
    첫 번째 코드(추가할 때에는 반복할 필요가 없음. 개선이 필요)
'''
'''
def check_condition(building):
    for x, y, kind in building:
        if kind:    # beam
            if (x,y-1,0) not in building and (x+1,y-1,0) not in building and \
                    ((x-1,y,1) not in building or (x+1,y,1) not in building):
                break
        else:       # column
            if y and (x-1,y,1) not in building and \
                    (x,y,1) not in building and (x,y-1,0) not in building:
                break
    else:
        return True
    return False

def solution(n, build_frame):
    building = set()
    for x, y, kind, construction in build_frame:
        if construction:    
            building.add((x, y, kind))
            if not check_condition(building):
                building.remove((x, y, kind))
        else:
            building.remove((x, y, kind))
            if not check_condition(building):
                building.add((x, y, kind))
    building = map(list, building)
    return sorted(building)
'''