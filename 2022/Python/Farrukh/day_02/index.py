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

    mapping = {
        "A": "Rock",
        "B": "Paper",
        "C": "Scissors",
        "X": "Rock",
        "Y": "Paper",
        "Z": "Scissors",
    }

    game = {"Rock": "Scissors", "Scissors": "Paper", "Paper": "Rock"}
    scores = {"X": 1, "Y": 2, "Z": 3}

    total = 0

    for item in data:
        items = item.split(" ")

        if game[mapping[items[0]]] == mapping[items[1]]:
            total = total + scores[items[1]]

        elif game[mapping[items[1]]] == mapping[items[0]]:
            total = total + 6 + scores[items[1]]
        else:
            total = total + 3 + scores[items[1]]

    return total


def part2(data):
    """Solve part 2."""

    lose = {"A": "Z", "C": "Y", "B": "X"}
    win = {"A": "Y", "B": "Z", "C": "X"}

    scores = {"X": 1, "Y": 2, "Z": 3, "A": 1, "B": 2, "C": 3}
    total = 0

    for item in data:
        items = item.split(" ")
        if items[1] == "X":
            total = total + scores[lose[items[0]]]

        elif items[1] == "Z":
            total = total + 6 + scores[win[items[0]]]
        else:
            total = total + 3 + scores[items[0]]
    return total


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
