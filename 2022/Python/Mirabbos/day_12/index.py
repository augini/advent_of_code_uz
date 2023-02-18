from collections import deque

def parse():
    # Parses the input
    f = open("sample_input.txt", "r")
    _input=[]
    t=[]
    while True:
        val=f.readline()
        if val == "":
            # we have reached end of file
            break
        val=val[:-1] #removing new line ("\n")
        for i in val:
            t.append(i)
        _input.append(t)
        t=[]
    return _input

def part1(inp):
    def adjacent(r, c):
        return [[r, c+1], [r-1, c], [r, c-1], [r+1, c]]
    sr=0
    sc=0
    
    fr=0
    fc=0
    
    for i in range(len(inp)):
        for j in range(len(inp[i])):
            if inp[i][j]=='S':
                sr=i
                sc=j
                inp[i][j]='a'
            if inp[i][j]=='E':
                fr=i
                fc=j
                inp[i][j]='z'
            inp[i][j]=ord(inp[i][j])
    
    q=deque()
    q.append([0, sr, sc])
    
    visited={}
    visited[(sr, sc)]=True
    
    while q:
        count, r, c = q.popleft()
        
        for ar, ac in adjacent(r, c):
            if ar>=len(inp) or ac>=len(inp[0]) or ar<0 or ac<0:
                continue
            if (ar, ac) in visited or inp[ar][ac]-inp[r][c]>1:
                continue
            if ar==fr and ac ==fc:
                return count+1
            visited[(ar, ac)]=True
            q.append([count+1, ar, ac])

# Big O analyis
# Time Complexity: O(n)+ O(n) = 2*O(n) = O(n)
# Space Complexity: O(n)+ O(n) = 2*O(n) = O(n)


def part2(data):
    return data

# Big O analyis
# Time Complexity:
# Space Complexity:


def solve():
    # parse the given input
    data = parse()

    # get the solutions for each problem
    solution1 = part1(data)
    # solution2 = part2(data)

    return solution1


if __name__ == "__main__":
    solutions = solve()
    print(solutions)
