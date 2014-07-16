import java.util.Arrays;
import java.util.Iterator;

public class Grid
{
    private Box[][] GRID;
    private int Width,Height;
    public Grid( int columnCount, int rowCount)
    {
        GRID   = new Box[columnCount][rowCount];
        Width  = columnCount;
        Height = rowCount;
    }

    public Box get(int x, int y)
    {
        return GRID[x][y];
    }

    public void set(int x, int y, Box b)
    {
        GRID[x][y] = b;
    }

    public Grid getSubGrid(int x, int y, int width, int height)
    {
        Grid subGrid = new Grid(width, height);
        int x2 = x + width;
        for (;x < x2; x += 1)
        {   
            int y2 = y + height;
            for(; y < y2; y += 1)
            {
                subGrid.set(x,y,get(x,y));
            }
        }
        return subGrid;
    }
    
    public int getWidth()
    {
        return Width;
    }
    
    public int getHeight()
    {
        return Height;
    }
    
    public void replaceGridPart(int x, int y, Grid replacement)
    {
        int sx = 0;
        int sy = 0;
        int width  = replacement.getWidth();
        int height = replacement.getHeight();
        int sx2 = sx + width;
        int sy2 = sy + height;
        for(;sx < sx2; sx += 1)
        {
            for(; sy < sy2; sy += 1)
            {
                System.out.println(get(sx + x, sy + y));
                set(sx + x, sy + y, replacement.get(sx,sy));
                System.out.println(get(sx + x, sy + y));
            }
        }
    }

    public String toString()
    {
       return Arrays.deepToString(GRID);
    }
}
