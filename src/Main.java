import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Grid board = new Grid( 9, 9);
        board.set(0,0,new Box(3));
        board.set(0,1,new Box(5));
        Grid newBoard =  board.getSubGrid(0,0,1,2);
        System.out.println(newBoard);
    }

}