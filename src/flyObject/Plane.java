package flyObject;

import windows.MainWindow;
import javax.swing.*;
import java.awt.*;

/**
 * 飞机
 */
public class Plane implements Runnable{
    // speed
    private int speed = 5;
    // 飞机
    private JLabel plane;
    // 内容面板
    private Container container;

    public Plane(Container container, JLabel plane ){
        this.container=container;
        this.plane=plane;
    }

    /**
     * 飞机的移动线程实现
     */
    @Override
    public void run() {
        System.out.println("飞机线程已启动！");
        while (MainWindow.isRun){
            if(MainWindow.left){
//                System.out.println("飞机左飞！");
                //设置左飞机
                plane.setIcon(new ImageIcon("src/img/planeLeft.png"));
                //飞机位置和界面大小判断
                if(plane.getX()-speed<0){
                    plane.setLocation(0,plane.getY());
                }else{
                    plane.setLocation(plane.getX()-speed,plane.getY());
                }
            }else if(MainWindow.right){
                //设置右飞机
                plane.setIcon(new ImageIcon("src/img/planeRight.png"));
                //飞机位置和界面大小判断
                if(plane.getX()+speed>container.getWidth()){
                    plane.setLocation(container.getWidth(),plane.getY());
                }else{
                    plane.setLocation(plane.getX()+speed,plane.getY());
                }

            }else if(MainWindow.up){
                //设置正飞机，想上飞
                plane.setIcon(new ImageIcon("src/img/plane.png"));
                //飞机位置和界面大小判断
                if(plane.getY()-speed<0){
                    plane.setLocation(plane.getX(),plane.getY());
                }else{
                    plane.setLocation(plane.getX(),plane.getY()-speed);
                }

            }else if(MainWindow.down){
                //设置正飞机，想下飞
                plane.setIcon(new ImageIcon("src/img/plane.png"));
                //飞机位置和界面大小判断
                if(plane.getY()+speed>container.getHeight()){
                    plane.setLocation(plane.getX(),plane.getY());
                }else{
                    plane.setLocation(plane.getX(),plane.getY()+speed);
                }
            }
            try{
                Thread.sleep(50);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
