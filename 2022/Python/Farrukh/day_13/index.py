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


def check(left, right):
    if isinstance(left, int) and isinstance(right, int):
        if left < right:
            return 1
        elif left == right:
            return 0
        else:
            return -1
    elif isinstance(left, int) and isinstance(right, list):
        return check([left], right)
    elif isinstance(left, list) and isinstance(right, int):
        return check(left, [right])
    else:
        l1, l2 = len(left), len(right)
        count = 0
        while count < l1 and count < l2:
            result = check(left[count], right[count])
            if result == 1:
                return 1
            elif result == -1:
                return -1
            count += 1

        if count >= l1 and count < l2:
            return 1
        elif count >= l2 and count < l1:
            return -1


def part1(data):
    """Solve part 1."""
    l = len(data)
    count = 0

    for i in range(0, l, 3):
        left, right = eval(data[i]), eval(data[i + 1])
        res = check(left, right)
        if res == 1:
            count += (i // 3) + 1
    return count


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
