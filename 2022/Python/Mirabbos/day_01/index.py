
def parse():
    # Parses the input
    f = open("input.txt", "r")
    _input=[]
    while True:
        val=f.readline()
        if val == "":
            # we have reached end of file
            break
        val=val[:-2] #removing new line ("\n")
        _input.append(val)
    
    return _input

def part1(data):
    mx = 0
    temp = 0

    for item in data:
        if item == "":
            if temp > mx:
                mx = temp
            temp = 0
        else:
            temp += int(item)
    return mx


# Big O analyis
# Time Complexity: O(n)
# Space Complexity: O(1)


def part2(data):
    mx = [0, 0, 0]
    temp = 0

    for item in data:
        if item == "":
            if temp > mx[0]:
                mx[0]=temp                
                mx.sort()
            temp = 0
        else:
            temp += int(item)

    return sum(mx)


# Big O analyis
# Time Complexity: O(n) -> we have sorting in every loop iteration but
#                          since it only contains constant number of items (3 items) and does not change depending on the input length,
#                          it should be considered a constant operation
# Space Complexity: O(1)


def solve():
    # parse the given input
    data = parse()

    # get the solutions for each problem
    solution1 = part1(data)
    solution2 = part2(data)

    return solution1, solution2


if __name__ == "__main__":
    solutions = solve()
    print(solutions)
