package flyObject;

import moveThread.Explosion;
import windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class bullet implements Runnable {
    //控制面板
    private Container container;
    //飞机
    private JLabel plane;
    //子弹
    private JLabel jlbBullet;
    //速度x,y轴向
    private int xSpeed;
    private int ySpeed;

    public bullet(Container container,JLabel plane){
        this.container = container;
        this.plane=plane;

        //随机类
        Random random = new Random();
        //创建子弹
        jlbBullet = new JLabel(new ImageIcon("src/img/bullet.png"));
        //子弹位置生成
        jlbBullet.setBounds(random.nextInt(container.getWidth()),random.nextInt(container.getHeight()/2),12,12);
        //速度1-6随机僧成
        xSpeed=random.nextInt(5)+1;
        ySpeed=random.nextInt(5)+1;
        container.add(jlbBullet);
    }
    @Override
    public void run() {
        System.out.println("子弹开始发射！");
        while(MainWindow.isRun){
            //子弹的边缘处理
            if(jlbBullet.getX()<0||jlbBullet.getX()>container.getWidth()){
                xSpeed = -xSpeed;
            }
            if(jlbBullet.getY()<0|| jlbBullet.getY()>container.getHeight()){
                ySpeed=-ySpeed;
            }
            jlbBullet.setLocation(jlbBullet.getX()+xSpeed,jlbBullet.getY()+ySpeed);
            //碰撞检测(利用intersects)
            if(jlbBullet.getBounds().intersects(plane.getBounds())){
                //游戏结束
                MainWindow.isRun = false;
                //飞机爆炸
                int x = plane.getX()-plane.getWidth();
                int y = plane.getY()-plane.getHeight();
                new Thread(new Explosion(x,y,container,plane)).start();

            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
