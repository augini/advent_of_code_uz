import json

def parse1():
    # Parses the input
    f = open("sample_input.txt", "r")
    _input=[]
    t=[]
    while True:
        val=f.readline()
        if val == "":
            # we have reached end of file
            break
        if val == "\n":
            _input.append(t)
            t=[]
            continue
        val=val[:-1] #removing new line ("\n")
        json.loads(val)
        t.append(val)
    return _input

def parse2():
    f = open("sample_input.txt", "r")
    _input=[]
    t=[]
    while True:
        val=f.readline()
        if val == "":
            # we have reached end of file
            break
        if val == "\n":
            continue
        val=val[:-1] #removing new line ("\n")
        val=eval(val)
        _input.append(val)
    return _input

def part1(inp):
    def check(l, r):
        if type(l)==int:
            if type(r)==int:
                return l-r
            elif type(r)==list:
                return check([l], r)
        elif type(l)==list:
            if type(r)==int:
                return check(l, [r])
            elif type(r)==list:
                for lel, rel in zip(l, r):
                    res=check(lel, rel)
                    if res!=0:
                        return res
                return len(l)-len(r)
    count=0

    for i, el in enumerate(inp):
        if check(eval(el[0]), eval(el[1]))<0:
            count+=i+1

    return count

# Big O analyis; honestly I dont know how to calculate time and spce complexities of recursive funcion :) 
# Time Complexity:
# Space Complexity:

def part2(inp):
    def check(l, r):
        if type(l)==int:
            if type(r)==int:
                return l-r
            elif type(r)==list:
                return check([l], r)
        elif type(l)==list:
            if type(r)==int:
                return check(l, [r])
            elif type(r)==list:
                for lel, rel in zip(l, r):
                    res=check(lel, rel)
                    if res!=0:
                        return res
                return len(l)-len(r)

    divider_p1=[[2]]
    divider_p2=[[6]]

    pos_2=1
    pos_6=2

    for el in inp:
        if check(el, divider_p1)<0:
            pos_2+=1
            pos_6+=1
        elif check(el, divider_p2)<0:
            pos_6+=1

    return pos_2*pos_6

# Big O analyis
# Time Complexity:
# Space Complexity:


def solve():
    # get the solutions for each problem
    solution1 = part1(parse1())
    solution2 = part2(parse2())

    return solution1, solution2


if __name__ == "__main__":
    solutions = solve()
    print(solutions)
