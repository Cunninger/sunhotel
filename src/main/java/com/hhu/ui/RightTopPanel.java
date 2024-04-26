package com.hhu.ui;
import com.hhu.awt.MyJButton;
import com.hhu.domain.entity.RoomInfo;
import com.hhu.domain.entity.RoomType;
import com.hhu.service.RoomInfoService;
import com.hhu.service.RoomTypeService;
import com.hhu.service.Impl.RoomInfoServiceImpl;
import com.hhu.service.Impl.RoomTypeServiceImpl;
import com.hhu.util.Windows;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RightTopPanel extends JPanel  {
    private RoomTypeService roomTypeService = new RoomTypeServiceImpl();
    private RoomInfoService roomInfoService = new RoomInfoServiceImpl();
    private JTabbedPane jTabbedPane;
    private java.util.List<RoomInfo> roomInfoList = new ArrayList<>();
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
        /*roomtypes[0]="标准单人间";
        roomtypes[1]="标准双人间";
        roomtypes[2]="豪华单人间";
        roomtypes[3]="豪华双人间";
        roomtypes[4]="商务套房";
        roomtypes[5]="总统套房";
        roomtypes[6]="特价单人房";*/
        try {
            java.util.List<RoomType> list = roomTypeService.getAll();
            roomInfoList = roomInfoService.getAll();
            for(int i=0;i<list.size();i++){
                RoomType roomType = (RoomType) list.get(i);
                roomtypes[i] = roomType.getrType();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //初始化各房间类型面板
        for (int i = 0;i < roomtypes.length;i++) {
            //建立一个房间类型的标签栏单页，网格布局
            JPanel jp = new JPanel(new GridLayout(1, 1));
            String roomTypeId="LX000"+ (i+1); //拼接房间类型号
            //制作ViewList面板并加入jp
            JPanel vl = buildViewList(roomTypeId);
            jp.add(vl);
            jTabbedPane.addTab(roomtypes[i], jp);
        }

    }
    public JPanel buildViewList(String roomTypeId) {
        java.util.List<RoomInfo> rooms = getRoomsByRoomType(roomTypeId);
        int vRow = (int)Math.ceil((float)rooms.size()/ 6);    //一行放6个button
        //建立按键面板
        JPanel panelMain	= new JPanel(new GridLayout(vRow, 1, 5, 15));
        //设置默认背景色
        panelMain.setBackground(new Color(248, 242, 230));
        //指定房间，后面从数据库读取
        JButton jButton ;
        for (RoomInfo roomInfo:rooms){
            switch (roomInfo.getState()){
                case "可供":
                    jButton = new MyJButton(roomInfo.getId(),Windows.IMGPATH+"room/prov.gif");
                    panelMain.add(jButton);
                    break;
                case "占用":
                    jButton = new MyJButton(roomInfo.getId(),Windows.IMGPATH+"room/clock.gif");
                    panelMain.add(jButton);
                    break;
                case "停用":
                    jButton = new MyJButton(roomInfo.getId(),Windows.IMGPATH+"room/stop.gif");
                    panelMain.add(jButton);
                    break;
                case "脏房":
                    jButton = new MyJButton(roomInfo.getId(),Windows.IMGPATH+"room/clean.gif");
                    panelMain.add(jButton);
                    break;
                default:
                    jButton = new MyJButton(roomInfo.getId(),Windows.IMGPATH+"room/rese.gif");
                    panelMain.add(jButton);
            }
            jButton.addActionListener(new RoomBtnAcionListener(roomInfo));
        }
        return panelMain;
    }

    private java.util.List<RoomInfo> getRoomsByRoomType(String roomTypeId){
        java.util.List<RoomInfo> rooms = new ArrayList<>();
        for (RoomInfo roomInfo:roomInfoList){
            //按类型查找房间
            if(roomInfo.getrTypeId().equals(roomTypeId)){
                rooms.add(roomInfo);
            }
        }
        return rooms;
    }

    class RoomBtnAcionListener implements ActionListener{
        private RoomInfo roomInfo;
        public  RoomBtnAcionListener(){}
        public  RoomBtnAcionListener(RoomInfo roomInfo){
            this.roomInfo=roomInfo;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("e = " + roomInfo.getState());
            //提示框
            JOptionPane.showMessageDialog(null, roomInfo.getState(),"", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
