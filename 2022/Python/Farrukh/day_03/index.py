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
    _sum = 0

    for item in data:
        mid = len(item) // 2
        part_1, part_2 = item[:mid], item[mid:]

        for char in part_1:
            if char in part_2:
                _ascii = ord(char)

                if _ascii <= 122 and _ascii >= 97:
                    temp = _ascii - 96
                else:
                    temp = (_ascii - 64) + 26

                _sum += temp

                break
    return _sum


def part2(data):
    """Solve part 2."""
    _sum = 0

    for i in range(0, len(data), 3):
        first, second, third = data[i], data[i + 1], data[i + 2]

        for char in first:
            if char in second and char in third:
                _ascii = ord(char)

                if _ascii <= 122 and _ascii >= 97:
                    temp = _ascii - 96
                else:
                    temp = (_ascii - 64) + 26

                _sum += temp

                break
    return _sum


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
