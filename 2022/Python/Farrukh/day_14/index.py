# aoc_template.py

import pathlib
import sys
from collections import defaultdict

def parse(puzzle_input, type=1, seperator="\n"):
    # Parses the input

    #  print(puzzle_input)
    if type == 1:
        return list(puzzle_input.split())
    elif type == 2:
        return list(puzzle_input.split(seperator))
    elif type == 3:
        return list(puzzle_input.strip().split(seperator))


def part1(data):
    """Solve part 1."""
    # create the lines that include rocks
    rocks = defaultdict(set)

    for item in data:
        parts = item.split("->")
        prev = parts[0]
        
        for i in range(1, len(parts)):
            prev, curr = prev.strip().split(","), parts[i].strip().split(",")     
            
            for x in range(2):
                prev[x], curr[x] = int(prev[x]), int(curr[x])
            
            x1, y1 = prev
            x2, y2 = curr

            if x1 == x2:
                _min = min(y1, y2)
                _max = max(y1, y2)
                
                for y in range(_min, _max+1):
                    rocks[x1].add(y)

            if y1 == y2:
                _min = min(x1, x2)
                _max = max(x1, x2)
                
                for y in range(_min , _max):    
                    rocks[y].add(y1) 
            prev = parts[i]
    # print(rocks)
    count = 0
    sands = defaultdict(set)

    while count < 23:
        count+=1
        sx, sy = 500, 0

        while True:
            if not sy+1 in rocks[sx] and not sy+1 in sands[sx]:
                sy+=1
                continue
            elif not sy+1 in rocks[sx-1] and not sy+1 in sands[sx-1]:
                sx-=1
                sy+=1
                print(sx, sy)
                continue
            elif not sy+1 in rocks[sx+1] and not sy+1 in sands[sx+1]:
                sx+=1
                sy+=1
                continue
            else:
                sands[sx].add(sy)
                break
        if (sx, sy) == (500, 0):
            break

    sm = 0
    for v in sands.values():
        sm+=len(v)
    return sm


def part2(data):
    """Solve part 2."""


def solve(puzzle_input):
    # Solve the puzzle for the given input.
    # parse the given input
    data = parse(puzzle_input, 2)

    # get the solutions for each problem
    solution1 = part1(data)
    solution2 = part2(data)

    return solution1, solution2


if __name__ == "__main__":
    #  print(sys.argv)
    for path in sys.argv[1:]:
        #   print(f"{path}:")
        puzzle_input = pathlib.Path(path).read_text()
        solutions = solve(puzzle_input)
        print("\n".join(str(solution) for solution in solutions))
