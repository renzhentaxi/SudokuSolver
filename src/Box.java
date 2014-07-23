import java.util.ArrayList;
import java.util.Arrays;

public class Box
{
    private static Integer[] defaultValues = new Integer[]{1,2,3,4,5,6,7,8,9};
    private ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(defaultValues));
    public int x,y;

    public void set(int value)
    {
        values.clear();
        values.add(value);
    }

    public boolean remove(int value)
    {
        values.remove(value);
        return filled();
    }

    public boolean filled()
    {
        return values.size() == 1;
    }

    public int value()
    {
        return values.get(0);
    }

    public String toString()
    {
        return "x: " + x + " y: " + y;
    }
    public Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}