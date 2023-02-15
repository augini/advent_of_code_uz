# aoc_template.py

import pathlib
import sys
from collections import deque


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
    grid = []

    for line in data:
        temp = []
        for char in line:
            temp.append(char)
        grid.append(temp)

    q = deque([[(0, 0), "a"]])
    sides = [(0, 1), (1, 0), (-1, 0), (0, -1)]

    len_x = len(grid[0])
    len_y = len(grid)
    visited = set()

    while q:
        curr = q.popleft()
        index, path = curr
        visited.add(index)

        valid = []

        for side in sides:
            y, x = index[0] + side[0], index[1] + side[1]
            if x >= 0 and y >= 0 and x < len_x and y < len_y and (y, x) not in visited:
                valid.append((y, x))

        for indices in valid:
            curr = grid[index[0]][index[1]]
            new = grid[indices[0]][indices[1]]

            if ord(new) - ord(curr) == 1 and curr == "z":
                return len(path) + 1

            if ord(new) - ord(curr) <= 1:
                q.append([indices, path + new])


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
