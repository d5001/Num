package me.mcdcs.rgbtext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JFrame {

    public static void a(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui gui = new Gui();
                gui.setVisible(true);
            }
        });
    }

    public static String n;
    public static int jz = 2;

    public static JButton zs;
    public static JButton ze;

    public static JTextField tf;
    public static JTextField sz;

    public Gui(){
        setTitle("简单的进制转换器");
        setLayout(new FlowLayout());
        setBounds(100, 100, 497, 305);
        zs = new JButton("转换十进制");
        zs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Num num = new Num(n);
                n = num.ezs(jz);
                tf.setText(n);
            }
        });
        ze = new JButton("十进制转换");
        ze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Num num = new Num(n);
                n = num.sze(jz);
                tf.setText(n);
            }
        });
        tf = new JTextField(25);
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                n = tf.getText();
            }
        });
        tf.setText("输入数值");
        sz = new JTextField(5);
        sz.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try{
                    jz = Integer.parseInt(sz.getText());
                }catch (NumberFormatException i){
                    jz = 2;
                }
            }
        });
        sz.setText("进制");
        add(sz);
        add(tf);
        add(ze);
        add(zs);
    }
}
