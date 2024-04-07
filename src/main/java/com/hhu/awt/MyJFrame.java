package com.hhu.awt;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    public MyJFrame(){}
    /**
     * 有参构造方法
     * @param title 窗体标题
     * @param x 窗体座标x
     * @param y 窗体座标y
     * @param width 窗体宽度
     * @param height 窗体高度
     */
    public MyJFrame(String title, int x, int y, int width, int height){
        this.setTitle(title);
        this.setBounds(x,y,width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setVisible(true);
    }

    /**
     * 向窗体容器添加组件
     * @param jComponents 组件数组
     */
    public void add(JComponent[] jComponents){
        // 获取默认容器
        Container container=this.getContentPane();
        setLayout(null); // 绝对布局
        for(JComponent jComponent : jComponents){
            container.add(jComponent);
        }
        this.setVisible(true);
    }

}
