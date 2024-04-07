package com.hhu.ui;
import com.hhu.awt.MyJButton;
import com.hhu.util.Windows;

import javax.swing.*;
import java.awt.*;


public class RightTopPanel extends JPanel {
    private JTabbedPane jTabbedPane;
    public RightTopPanel() {
        super(new BorderLayout());//创建一个边界布局面板
        //房间类型选项卡
        jTabbedPane = new JTabbedPane();
        //制作标签栏
        buildJTabbedPane();
        //设置起始页
        jTabbedPane.setSelectedIndex(1);
        // 加入面板
        this.add("Center",jTabbedPane);
    }
    public void buildJTabbedPane() {
        String[] roomtypes = new String[7];	//保存房间类型数组
        //将房间类型的信息保存到数组中，先定义固定类型，后面从数据库读取
        roomtypes[0]="标准单人间";
        roomtypes[1]="标准双人间";
        roomtypes[2]="豪华单人间";
        roomtypes[3]="豪华双人间";
        roomtypes[4]="商务套房";
        roomtypes[5]="总统套房";
        roomtypes[6]="特价单人房";

        //初始化各房间类型面板
        for (String tab:roomtypes) {
            //建立一个房间类型的标签栏单页，网格布局
            JPanel jp = new JPanel(new GridLayout(1, 1));
            //制作ViewList面板并加入jp
            JPanel vl = buildViewList(12);
            jp.add(vl);
            jTabbedPane.addTab(tab, jp);
        }

    }
    public JPanel buildViewList(int buttons) {
        int vRow = buttons / 6;    //一行放6个button
        //建立按键面板
        JPanel panelMain	= new JPanel(new GridLayout(vRow, 1, 5, 15));
        //设置默认背景色
        panelMain.setBackground(new Color(248, 242, 230));
        //指定房间，后面从数据库读取
        for (int i = 0;i < buttons; i++){
            JButton jButton = new MyJButton("BD1001",Windows.IMGPATH+"room/prov.gif");
            panelMain.add(jButton);
        }

        return panelMain;
    }
}
