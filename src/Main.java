import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Box.setDefaultCandidates(1,2,3,4,5,6,7,8,9);
        Boxes box = new Boxes(9,9);
        int count = 0;
        for(ArrayList<Box> a : box)
        {
            for(Box b : a)
            {
                count += 1;
            }
        }
        System.out.println(box.getBox(9,9));
    }
}