var inputLines = File.ReadAllLines("Input.txt");

int highesScenicScore = 0;

int visibleTreesCount = 0;

for (int i = 1; i < inputLines.Length - 1; i++)
{
    for (int j = 1; j < inputLines[0].Length - 1; j++)
    {
        bool isVisibleFromLeft = true;
        bool isVisibleFromTop = true;
        bool isVisibleFromRight = true;
        bool isVisibleFromBottom = true;

        int visibleTreesFromLeftCount = 0;
        int visibleTreesFromRightCount = 0;
        int visibleTreesFromTopCount = 0;
        int visibleTreesFromBottomCount = 0;

        // checking left side of the current tree
        for (int k = j - 1; k >= 0; k--)
        {
            visibleTreesFromLeftCount++;

            if (inputLines[i][k] >= inputLines[i][j])
            {
                isVisibleFromLeft = false;
                break;
            }
        }

        // checking right side of the current tree
        for (int k = j + 1; k < inputLines[0].Length; k++)
        {
            visibleTreesFromRightCount++;

            if (inputLines[i][k] >= inputLines[i][j])
            {
                isVisibleFromRight = false;
                break;
            }
        }

        // checking top side of the current tree
        for (int k = i - 1; k >= 0; k--)
        {
            visibleTreesFromTopCount++;

            if (inputLines[k][j] >= inputLines[i][j])
            {
                isVisibleFromTop = false;
                break;
            }
        }

        // checking bottom side of the current tree
        for (int k = i + 1; k < inputLines.Length; k++)
        {
            visibleTreesFromBottomCount++;

            if (inputLines[k][j] >= inputLines[i][j])
            {
                isVisibleFromBottom = false;
                break;
            }
        }

        if (isVisibleFromTop || isVisibleFromRight || isVisibleFromBottom || isVisibleFromLeft)
        {
            visibleTreesCount++;
        }

        highesScenicScore = Math.Max(highesScenicScore, visibleTreesFromLeftCount * visibleTreesFromRightCount * visibleTreesFromTopCount * visibleTreesFromBottomCount);
    }
}

visibleTreesCount += 2 * (inputLines.Length + inputLines[0].Length) - 4;

Console.WriteLine("Part one answer: " + visibleTreesCount);
Console.WriteLine("Part two answer: " + highesScenicScore);