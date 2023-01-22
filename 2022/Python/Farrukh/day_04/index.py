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
    res = 0

    for item in data:
        first, second = item.split(",")

        first_1, first_2 = first.split("-")
        second_1, second_2 = second.split("-")

        first_1, first_2 = int(first_1), int(first_2)
        second_1, second_2 = int(second_1), int(second_2)

        if first_1 <= second_1 and first_2 >= second_2:
            res += 1
        elif second_1 <= first_1 and second_2 >= first_2:
            res += 1

    return res


def part2(data):
    """Solve part 2."""
    res = 0

    for item in data:
        first, second = item.split(",")

        first_1, first_2 = first.split("-")
        second_1, second_2 = second.split("-")

        first_1, first_2 = int(first_1), int(first_2)
        second_1, second_2 = int(second_1), int(second_2)

        # 2-3, 4-5
        # 
        if first_2 >= second_1 and first_2 <= second_2:
            res += 1
        elif second_2 >= first_1 and second_2 <= first_2:
            res += 1

    return res


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
