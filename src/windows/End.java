package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moveThread.Timer;
import change.award;
public class End {
    public End(){ }
    public static void Endgame(Container container){
        //结束画面
        JLabel jlbEnd = new JLabel("Game Over！");
        jlbEnd.setForeground(Color.red);
        jlbEnd.setBounds(160,200,100,50);
        container.add(jlbEnd);
        System.out.println("结束了！");
        JButton btnAgain = new JButton("再来一局");
        btnAgain.setBounds(150,250,100,50);
        container.add(btnAgain);
        jlbEnd.updateUI();
        btnAgain.updateUI();
        //奖励
        if(Timer.time>=20){
            new award();
        }
        //再来一局事件
        btnAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run.runWindow.dispose();
                run.runWindow=new MainWindow();

            }
        });
    }

}
