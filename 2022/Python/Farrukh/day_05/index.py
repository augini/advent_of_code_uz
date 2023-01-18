# aoc_template.py

import pathlib
import sys
from collections import defaultdict
import math
from typing import List


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
    stacks = defaultdict(list)
    inst = []

    length = len(data)

    # parse the input, the stack number as the dict key and the stack itself as dict values
    for i in range(length):
        # store the instructions into inst variable
        if data[i] == "":
            inst.extend(data[i + 1 :])
            break

        length = len(data[i])
        for y in range(length):
            curr: str = data[i][y]

            if curr != "" and curr != " " and curr != "[" and curr != "]":

                # check if the current char denotes the number of the stack
                if curr.isdigit():
                    # if it is, reverse the already existin stack and append it to that key in stacks dictionary
                    temp = stacks[y]
                    del stacks[y]
                    stacks[int(curr)] = list(reversed(temp))
                else:
                    stacks[y].append(curr)

    # follow the instructions and move the boxes
    for item in inst:
        items = item.split(" ")
        one, two, three = int(items[1]), int(items[3]), int(items[5])

        for i in range(one):
            temp = stacks[two].pop()
            stacks[three].append(temp)

    result = ""
    l = len(stacks)

    for key in range(1, l + 1):
        temp = stacks[key].pop()
        result += temp

    return result


def part2(data):
    """Solve part 2."""
    stacks = defaultdict(list)
    inst = []

    length = len(data)

    # parse the input, the stack number as the dict key and the stack itself as dict values
    for i in range(length):
        # store the instructions into inst variable
        if data[i] == "":
            inst.extend(data[i + 1 :])
            break

        length = len(data[i])
        for y in range(length):
            curr: str = data[i][y]

            if curr != "" and curr != " " and curr != "[" and curr != "]":

                # check if the current char denotes the number of the stack
                if curr.isdigit():
                    # if it is, reverse the already existin stack and append it to that key in stacks dictionary
                    temp = stacks[y]
                    del stacks[y]
                    stacks[int(curr)] = list(reversed(temp))
                else:
                    stacks[y].append(curr)

    # follow the instructions and move the boxes
    for item in inst:
        items = item.split(" ")
        one, two, three = int(items[1]), int(items[3]), int(items[5])

        mv = []
        for i in range(one):
            temp = stacks[two].pop()
            mv.append(temp)
        mv.reverse()
        stacks[three].extend(mv)

    result = ""
    l = len(stacks)

    for key in range(1, l + 1):
        temp = stacks[key].pop()
        result += temp

    return result


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
