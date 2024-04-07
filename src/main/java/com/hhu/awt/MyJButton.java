package com.hhu.awt;

import com.hhu.util.Windows;

import javax.swing.*;

public class MyJButton extends JButton {
    public MyJButton(){}
    public MyJButton(String text,int x,int y,int width,int height){
        this.setText(text);
        this.setBounds(x,y,width,height);
    }
    public MyJButton(String text,String img){
        this.setText(text);
        ImageIcon icon = new ImageIcon( img);
        this.setIcon(icon);
        this.setContentAreaFilled(false);		//设置背景色透明
        this.setHorizontalTextPosition (SwingConstants.CENTER);//文字水平居中
        this.setVerticalTextPosition (SwingConstants.BOTTOM);//文字垂直靠底
    }
}
