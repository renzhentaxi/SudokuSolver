
public class Main
{
    public static void main(String[] args)
    {
        Grid board = new Grid( 9, 9);
        board.set(0,0,new Box(3));
        board.set(0,1,new Box(5));
        Grid replacement = new Grid(2,2);
        replacement.set(0,0, new Box(1));
        replacement.set(0,1, new Box(3));
        replacement.set(1,0, new Box(2));
        replacement.set(1,1, new Box(4));
        board.replaceGridPart(0,0,replacement);
        System.out.println(board);
    }

}