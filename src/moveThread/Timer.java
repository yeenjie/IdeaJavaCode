package moveThread;

import windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Timer implements Runnable{
    public static int time = 0;
    private Container container;
    public Timer(Container container) {
        this.container = container;
    }
    @Override
    public void run() {
        //初始的label
        JLabel jlbTime = new JLabel("00:00");
        jlbTime.setBounds(350,0,50,20);
        jlbTime.setForeground(Color.yellow);
        container.add(jlbTime);
        jlbTime.updateUI();
        //获得当前时间
        long start =System.currentTimeMillis();
        //刷新
        DecimalFormat decimalFormat = new DecimalFormat("00");
        while(MainWindow.isRun){
            long x = System.currentTimeMillis()-start;
            int second = (int)(x/1000);
            time = second;
            int ms = (int)(x%1000/10);
            jlbTime.setText(decimalFormat.format(second)+":"+decimalFormat.format(ms));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

