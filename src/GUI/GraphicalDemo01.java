package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicalDemo01 {

    public static void main(String[] args) {

        /**
         * GUI简单实例
         * */
        
        //创建一个窗口对象
        JFrame windows = new JFrame("HelloWorldSwing");
        
        //设置窗口大小
        windows.setSize(400,400);
        
        //设置窗口位置
        windows.setLocation(600,300);
        
        //设置程序图标
        /*windows.setIconImage(Toolkit.getDefaultToolkit().createImage(4.png));*/

        windows.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                //退出程序
                System.exit(0);
            }
        });

        //添加按钮
        Button btn1 = new Button("login");
        Button btn2 = new Button("regis");
        Button btn3 = new Button("keyBoard");
        windows.add(btn1);
        windows.add(btn2);
        windows.add(btn3);

        //FlowLayout流布局，从左到右边
        windows.setLayout(new FlowLayout());

        //添加按钮点击
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了");
            }
        });

        //鼠标监听
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("我按下了");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("我松开了");
            }

        });
        btn3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar()+ ":" + e.getKeyCode());
            }
        });
        
        //显示窗口
        windows.setVisible(true);
    }
}
