package change;

import javax.swing.*;
import java.awt.*;

public class award extends JFrame{
    JLabel img = new JLabel(new ImageIcon("src/img/award2.jpg"));
    public award(){
        setTitle("真男人！");
        setSize(1000,1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Container container = getContentPane();
        img.setBounds(0,0,300,700);
        container.add(img);
    }


}
