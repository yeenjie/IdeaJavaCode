package moveThread;

import windows.End;
import windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Explosion implements Runnable {
    //爆炸位置
    private int x;
    private int y;
    private Container container;
    private JLabel plane;

    public Explosion(int x, int y, Container container, JLabel plane) {
        this.x = x;
        this.y = y;
        this.container = container;
        this.plane = plane;
    }

    @Override
    public void run() {
        System.out.println("爆炸开始！");
        //引爆
        JLabel jlbExplosion = new JLabel(new ImageIcon("src/img/explosion2-1.png"));
        jlbExplosion.setBounds(x, y, 128, 128);
        container.add(jlbExplosion);
        plane.setVisible(false);
        //爆炸动画
        for (int i = 1;i<72;i++ ){
            jlbExplosion.setIcon(new ImageIcon("src/img/explosion2-"+i+".png"));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        End.Endgame(container);

    }
}
