package com.hhu.ui.frame;

import com.hhu.awt.MyJButton;
import com.hhu.awt.MyJFrame;
import com.hhu.domain.entity.RoomInfo;

import java.util.ArrayList;
import java.util.List;

import com.hhu.domain.entity.RoomType;
import com.hhu.service.Impl.RoomInfoServiceImpl;
import com.hhu.service.Impl.RoomTypeServiceImpl;
import com.hhu.service.RoomTypeService;
import com.hhu.ui.panel.LeftBottPanel;
import com.hhu.ui.panel.LeftTopPanel;
import com.hhu.ui.panel.RightBottPanel;
import com.hhu.ui.panel.RightTopPanel;
import com.hhu.util.Windows;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import com.hhu.service.RoomInfoService;
public class MainFrame extends MyJFrame {
    private static int x,y,width,height;
    private JToolBar jToolBar;//工具栏
    private JPanel panelMain,jp1,jp2,jp3,jp4,bott;//面板
    private JSplitPane spaneLeft,spaneRight,spaneMain;//分割面板
    private static Map<Integer,String[]> toolbars = new HashMap<>();//保存菜单项
    // 去数据库查roomInfoList，定义为全局变量
    private List<RoomInfo> roomInfoList = new ArrayList<>();
    private List<RoomType> roomTypeList = new ArrayList<>();
    private RoomInfoService roomInfoService = new RoomInfoServiceImpl();
    private RoomTypeService roomTypeService = new RoomTypeServiceImpl();
    private RoomInfo roomInfo = new RoomInfo();
    private RoomType roomType = new RoomType();

    static {
        // 计算窗口位置和大小
        width = 1020;
        height = 740;
        x = Windows.x - width / 2;
        y = Windows.y - height / 2;
        //定义菜单项
        toolbars.put(1,new String[]{"散客开单","toolbar/m01.gif"});
        toolbars.put(2,new String[]{"团体开单","toolbar/m02.gif"});
        toolbars.put(3,new String[]{"宾客结账","toolbar/m03.gif"});
        toolbars.put(4,new String[]{"客户预订","toolbar/m04.gif"});
        toolbars.put(5,new String[]{"网络设置","toolbar/m05.gif"});
        toolbars.put(6,new String[]{"系统设置","toolbar/m06.gif"});
        toolbars.put(7,new String[]{"关于我们","toolbar/m07.gif"});
        toolbars.put(8,new String[]{"退出系统","toolbar/m10.gif"});
    }
    public MainFrame() throws Exception {
        super("阳光酒店管理系统 V2004", x,y,width,height);
        //制作工具栏
        buildToolBar();
        //制作分割面板
        buildSpaneMain();
        // 制作底部状态栏
        buildBott();
        //加入组件到主面板
        panelMain = new JPanel (new BorderLayout());//主面板边界布局
        panelMain.add ("North", jToolBar);	//加入工具栏
        panelMain.add ("South", bott);			//加入窗口底端信息框
        panelMain.add ("Center", spaneMain);	//加入分割面板
        this.setContentPane (panelMain);

//         初始化房间信息
//         从数据库中获取房间信息
         roomInfoList = roomInfoService.selectAll();
//         从数据库中获取房间类型信息
         roomTypeList = roomTypeService.selectAll();





        this.setContentPane (panelMain);

        this.setVisible(true);
    }


    /**
     * 初始化工具栏
     */
    public void buildToolBar(){
        jToolBar = new JToolBar();
        for(String[] toolbar : toolbars.values()){
            MyJButton myJButton = new MyJButton(toolbar[0], Windows.IMGPATH+toolbar[1]);
            jToolBar.add(myJButton);
        }
        jToolBar.setBounds(0,0,width,90);
        //设置工具栏不可浮动
        jToolBar.setFloatable(false);
    }

    /**
     *  制作主面板
     */
    private void buildSpaneMain () throws Exception {

        jp1 = new LeftTopPanel();		//这四个面板为功能接口//////////////
        jp2 = new LeftBottPanel();		//左下面板		快速通道
        jp3 = new RightTopPanel();        ///////////////////////////////
        jp4 = new RightBottPanel();		//右下面板		消费信息表

        //声名分割面板
        spaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp1, jp2);
        spaneRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp3, jp4);
        spaneMain  = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, spaneLeft, spaneRight);

        //设置面板最小尺寸
        jp1.setMinimumSize(new Dimension(157, 450));
        jp2.setMinimumSize(new Dimension (157, 94));
        jp3.setMinimumSize(new Dimension (875, 300));
        jp4.setMinimumSize(new Dimension (875, 94));
        spaneRight.setMinimumSize(new Dimension (875, 565));

        //设置分割条是否有伸缩键
        spaneMain.setOneTouchExpandable (true);
        spaneRight.setOneTouchExpandable(true);

        //设置各面板的初起尺寸
        spaneMain.setDividerLocation (160);
        spaneLeft.setDividerLocation (450);
        spaneRight.setDividerLocation(450);

        //设置分隔条宽度
        spaneMain.setDividerSize (10);
        spaneLeft.setDividerSize (23);
        spaneRight.setDividerSize(23);

    }

    /**
     * 制作底部状态栏
     */
    private void buildBott () {
        JLabel lb1, lb2,lbA,lbB;
        lb1 = new JLabel("     酒 店 宾 馆 管 理 系 统    ");
        lb2 = new JLabel("    当前操作员 :  " +"" + "                  ");
        lbA = new JLabel( "请选择功能项 ...   　　　　　　　　　　　　　　　　　　　　");
        lbB	= new JLabel(" 酒 店 宾 馆 管 理 系 统 -    【猿来入此】修订版         ");
        //加外框线
        lbA.setBorder(new LineBorder(new Color(87, 87, 47)));
        lbB.setBorder(new LineBorder(new Color(87, 87, 47)));
        lb1.setBorder(new LineBorder(new Color(87, 87, 47)));
        lb2.setBorder(new LineBorder(new Color(87, 87, 47)));
        //流式布局
        bott = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        bott.add (lb1);
        bott.add (lbA);
        bott.add (lbB);
        bott.add (lb2);
    }

}
