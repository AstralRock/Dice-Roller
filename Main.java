import javax.swing.*;
import java.awt.*;

class frame extends JFrame
{
    public frame()
    {
        super("My First Frame");
        setSize(300, (int)(getMonitorHeight()*0.9));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getMonitorHeight()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    public
}

public class Main 
{
    public static void main(String[] args) 
    {
        frame f = new frame();
    }
}
