import java.util.ArrayList;

/**
 * Created by Tashi on 7/14/2014.
 */
public class Box
{
    private static ArrayList<Integer> defaultCandidates = new ArrayList<Integer>();
    private ArrayList<Integer> candidates = new ArrayList<Integer>();
    public int x,y;

    public Box()
    {
        candidates.addAll(defaultCandidates);
    }

    public static void setDefaultCandidates(int... candidates)
    {
       for( int c : candidates)
       {
           defaultCandidates.add(c);
       }
    }

    public String toString()
    {
        return "x: " + x + " y: " + y;
    }
}
