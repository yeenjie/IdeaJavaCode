package windows;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import flyObject.bullet;
import flyObject.Plane;
import moveThread.Timer;

/**
 * 游戏主界面
 */
public class MainWindow extends JFrame {
    /**
     * 初始化游戏全局参数
     * 1.是否存活，2.方向，3.子弹数量,4.飞机
     */
    //1。游戏是否在运行
    public static boolean isRun = true;
    //2。方向
    public static boolean right, left, up, down;
    //3.子弹数量
    public static int bulletNumb = 30;
    //4.飞机
    private JLabel plane;
    private JLabel lbDesc;
    /**
     * 初始化参数
     */
    public MainWindow() {
        isRun = true;
        // 设置界面大小
        setSize(400, 600);
        // 设置居中
        setLocationRelativeTo(null);
        // 设置退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 得到内容面板
        final Container container = getContentPane();
        container.setBackground(Color.black);
        //设置标题
        setTitle("是男人就坚持20s");
        //设置绝对定位
        container.setLayout(null);

        //添加标签
        final JLabel lbDesc = new JLabel("是男人就坚持20s");
        lbDesc.setBounds(133, 175, 113, 31);
        lbDesc.setForeground(Color.white);
        container.add(lbDesc);

        //添加按钮
        final JButton btnStart = new JButton("开始");
        btnStart.setBounds(133, 210, 113, 31);
        container.add(btnStart);

        //测试
        //添加按钮
        final JButton btnTest = new JButton("测试");
        btnTest.setBounds(133, 210, 113, 31);
        btnTest.setVisible(false);
        container.add(btnTest);

        //设置可见
        setVisible(true);
        //设置内容面板焦点
        container.setFocusable(true);

        /**
         * 键盘事件
         */
//        container.addKeyListener(new KeyAdapter() {
//            // 按下,具体实现，即为按钮把对应的方向设置为true
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println("操作杆已连接！");
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_LEFT:
//                        System.out.println("左方向已打！");
//                        left=true;
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        right=true;
//                        break;
//                    case KeyEvent.VK_UP:
//                        up=true;
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        down=true;
//                        break;
//                }
//            }
//
//            // 释放，把当前方向再设置成false
//            @Override
//            public void keyReleased(KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_LEFT:
//                        left=false;
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        right=false;
//                        break;
//                    case KeyEvent.VK_UP:
//                        up=false;
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        down=false;
//                        break;
//                }
//            }
//        });
        container.addKeyListener(new KeyListener() {
            public void keyAction(KeyEvent e,boolean bl){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        left = bl;
                        break;
                    case KeyEvent.VK_RIGHT:
                        right = bl;
                        break;
                    case KeyEvent.VK_UP:
                        up = bl;
                        break;
                    case KeyEvent.VK_DOWN:
                        down = bl;
                        break;
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }

            //按下，具体实现，对应方向变为true
            @Override
            public void keyPressed(KeyEvent e) {
                keyAction(e,true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyAction(e,false);
            }
        });


        /**
         * 给开始按钮加上点击事件
         */
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //隐藏标题和按钮
                btnStart.setVisible(false);
                lbDesc.setVisible(false);
                //飞机出现
                plane = new JLabel(new ImageIcon("src/img/plane.png"));
                plane.setBounds(150, 400, 33, 33);
                container.add(plane);
                //刷新页面
                plane.updateUI();
                //飞机移动
                new Thread(new Plane(container,plane)).start();
                // 计时线程启动
                new Thread(new Timer(container)).start();
                //子弹开始发射
               for(int i=0;i<bulletNumb;i++){
                   new Thread(new bullet(container,plane)).start();
               }

            }
        });

    }


}
