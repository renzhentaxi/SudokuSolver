import java.util.ArrayList;

public class Boxes extends ArrayList<ArrayList<Box>>
{
    public Boxes(int columnCount, int rowCount)
    {
        for( int x = 0; x < columnCount; x += 1)
        {
            ArrayList<Box> xBoxes = new ArrayList<Box>();
            add(xBoxes);
            for ( int y = 0; y < rowCount; y += 1 )
            {
                Box box = new Box();
                xBoxes.add(box);
                box.x = x;
                box.y = y;
            }
        }
    }

    public Box getBox(int x, int y)
    {
        return get(x).get(y);
    }
}