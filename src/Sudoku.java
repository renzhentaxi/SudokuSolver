import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Sudoku extends JPanel
{
    HashMap<Point,Box> board = new HashMap<Point,Box>();
    int currentX = 0;
    int currentY = 0;
    public Sudoku()
    {
        super();
        for(int x = 0; x < 9; x++)
        {
            for(int y = 0; y < 9; y++)
            {
                board.put(new Point(x,y),new Box(x,y));
            }
        }

        setPreferredSize(new Dimension( 900,900));
        setFocusable(true);
        requestFocusInWindow();
        addMouseListener(new sMouseListener());
        addKeyListener(new sKeyListener());
    }

    public void set(int x , int y, int value)
    {
        Box b = board.get(new Point(x,y));
        b.set(value);
        repaint();
        System.out.println(getAffected(currentX, currentY));
        System.out.println(getAffected(currentX,currentY).size());
        solve(x, y, value);
    }

    public void solve(int x, int y,int value)
    {
       ArrayList<Box> affected = getAffected(x,y);

    }

    public HashMap<Point,Box> getNotFilled()
    {
        HashMap<Point,Box> bs = new HashMap<Point,Box>();
        for(int x = 0; x < 9; x++)
        {
            for(int y = 0; y < 9; y++)
            {
                Box b = board.get(new Point(x,y));
                if (!b.filled())
                {
                    bs.put(new Point(x,y),b);
                }
            }
        }
        return bs;
    }

    public ArrayList<Box> getAffected(int x, int y)
    {
        HashMap<Point,Box> notFilled = getNotFilled();
        ArrayList<Box> affected = new ArrayList<Box>();
        for ( int i = 0; i < 9; i++)
        {
            add(affected, notFilled.get(new Point(i, y)));
            add(affected, notFilled.get(new Point(x, i)));
            add(affected, notFilled.get(new Point(x - x % 3 + i % 3, y - y % 3 + (i - i % 3) / 3)));
        }
        return affected;
    }

    public void add(ArrayList<Box> boxes, Box b)
    {
        if ( b != null)
        {
            for(Box box: boxes)
            {
                if ( box ==b)
                {
                    return;
                }
            }

            boxes.add(b);
        }
    }

    public void paintComponent( Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman",Font.PLAIN,50));
        for(int x = 0; x < 9; x +=1)
        {
            for(int y = 0; y < 9; y +=1)
            {
                int gx = x*100;
                int gy = y*100;
                g.drawRect(gx,gy,100,100);
                Box b = board.get(new Point(x,y));
                if( b.filled())
                {
                    g.drawString( Integer.toString(b.value()),gx+37,gy+70);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        Sudoku sudoku = new Sudoku();
        window.getContentPane().add(sudoku);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    class sMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            currentX = (e.getX() - e.getX() % 100) /100;
            currentY = (e.getY() - e.getY() % 100)/ 100;
        }
    }

    class sKeyListener extends KeyAdapter
    {
        public void keyPressed (KeyEvent e)
        {
            char key = e.getKeyChar();
            if (Character.isDigit(key))
            {
                String a = Character.toString(key);
                int value = Integer.parseInt(a);
                set(currentX,currentY,value);
                next();
            }
            else
            {
                if (key == ' ')
                {
                    next();
                }
            }
        }

        public void next()
        {
            int nextX = currentX +1;
            int nextY = currentY;
            if( nextX == 9)
            {
                nextX = 0;
                nextY += 1;
            }
            if ( nextY == 9)
            {
                nextY = 0;
                nextX = 0;
            }
            currentX = nextX;
            currentY = nextY;
        }
    }
}