# aoc_template.py

import pathlib
import sys


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
    _max = 0
    temp = 0

    for item in data:
        if item == "":
            if temp > _max:
                _max = temp
            temp = 0
        else:
            temp += int(item)
    return _max


# Big O analyis
# Time Complexity: O(n)
# Space Complexity: O(1)


def part2(data):
    """Solve part 2."""
    _max = [0, 0, 0]
    temp = 0

    for item in data:
        if item == "":
            if temp > _max[-1]:
                _max.pop()
                _max.append(temp)
                _max.sort(reverse=True)
            temp = 0
        else:
            temp += int(item)

    return sum(_max)


# Big O analyis
# Time Complexity: O(n) -> we have sorting in every loop iteration but
#                          since it only contains constant number of items and does not change depending on the input length,
#                          it seems to be considered a constant operation
# Space Complexity: O(1)


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
