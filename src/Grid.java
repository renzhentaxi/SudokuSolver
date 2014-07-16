import java.util.Arrays;

public class Grid
{
    private Box[][] GRID;

    public Grid( int columnCount, int rowCount)
    {
        GRID = new Box[columnCount][rowCount];
    }

    public Box get(int x, int y)
    {
        return GRID[x][y];
    }

    public void set(int x, int y, Box b)
    {
        GRID[x][y] = b;
    }

    public Grid getSubGrid(int x, int y, int length, int height)
    {
        Grid subGrid = new Grid(length, height);
        int x2 = x + length;
        int y2 = y + height;
        for (;x < x2; x += 1)
        {
            for(; y < y2; y += 1)
            {
                subGrid.set(x,y,get(x,y));
            }
        }
        return subGrid;
    }

    public String toString()
    {
       return Arrays.deepToString(GRID);
    }
}
