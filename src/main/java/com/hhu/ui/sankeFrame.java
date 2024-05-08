package com.hhu.ui;

import com.hhu.domain.entity.Livein;
import com.hhu.domain.entity.RoomInfo;
import com.hhu.domain.entity.RoomType;
import com.hhu.service.Impl.LiveinServiceImpl;
import com.hhu.service.LiveinService;
import com.hhu.service.RoomInfoService;
import com.hhu.service.Impl.RoomInfoServiceImpl;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 功能：散客开单
 * 日期：2024/4/26 上午8:40
 */
public class sankeFrame extends JFrame  implements ActionListener {
    JLabel roomCode;
    JLabel roomTypeJLabel;
    JLabel roomPriceJLabel;

    JComboBox<String> idType;
    JTextField idCode;
    JComboBox<String> guestSexType;
    JComboBox<String> guestType;
    JTextField guestName;
    JTextField guestCount;
    JTextField addressInfo;
    JTextField otherInfo;
    JLabel discount;
    JTextField actualPrice;
    JTextField useRoomDays;//预住天数
    JTextField cashPledge;//押金
    JList<String> emptyRoomList;
    JList<String> billRoomList;
    JButton addRoom,deleteRoom,confirm,cancel;

    Font font;
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();;
    private Integer leftIndex=null;
    private Integer rightIndex=null;
    private  LiveinService liveinService=new LiveinServiceImpl();
    private RoomInfoService roomInfoService=new RoomInfoServiceImpl();
    private Livein livein=new Livein();
    private List<Livein> liveinList=new ArrayList<>();
    public sankeFrame(List<RoomInfo> roomInfoList, RoomType roomType, RoomInfo roomInfo)  {
        setTitle("散客开单");
        setIconImage(Toolkit.getDefaultToolkit().getImage(""));
        setSize(600,650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        font = new Font("微软雅黑",Font.PLAIN,20);

        JLabel topLabel = new JLabel("开单信息");
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setBounds(0,5,590,30);
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(255, 255, 255));
        add(topLabel);
//        RoomType roomTypea=new RoomType();


        livein.setrNo(roomInfo.getState());
        livein.setMainRoom(roomInfo.getState());
        livein.setMainPk(String.valueOf(livein.getPk()));
        //TODO
        livein.setcTypeId("123");//客户类型编号
        livein.setmId("123456");
        livein.setStatemark("已结算");



        roomCode = createJLabelOfCenter(roomCode,"主客房间:"+roomInfo.getId(),10,40,190,25);
        roomTypeJLabel = createJLabelOfCenter(roomTypeJLabel,"房间类型:"+roomType.getrType(),200,40,190,25);
        roomPriceJLabel = createJLabelOfCenter(roomPriceJLabel,"预设单价:"+roomType.getPrice(),390,40,190,25);

        createJLabel("证件类型:",18,70,65,30);

        idType = new JComboBox<>();
        idType.addItem("身份证");
        idType.addItem("临时身份证");
        idType.addItem("港澳居民身份证");
        idType.addItem("国外居民暂住证");
        livein.setZjType("身份证");//初始化
        idType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String)e.getItem();
                    livein.setZjType(selectedItem);
                }
            }
        });
        idType.setBounds(73,70,80,25);
        add(idType);

        createJLabel("证件编号:",182,70,65,30);

        idCode = new JTextField();
        livein.setZjNo("");
        idCode.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            public void printIt() {
                String text = idCode.getText();
                livein.setZjNo(text);
            }
        });
        idCode.setBounds(239,70,160,25);
        add(idCode);

        createJLabel("主客性别:",428,70,65,30);

        guestSexType = new JComboBox<>();
        guestSexType.addItem("男");
        guestSexType.addItem("女");
        livein.setSex("男");//初始化
        guestSexType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String)e.getItem();
                    livein.setSex(selectedItem);
                }
            }
        });
        guestSexType.setBounds(483,70,80,25);
        add(guestSexType);


        //-----------------------------------------------------------------------------

        createJLabel("宾客类型:",18,110,65,30);

        guestType = new JComboBox<>();
        guestType.addItem("普通宾客");
        guestType.addItem("团体组织");
        guestType.addItem("内部人事");
        //TODO
        livein.setrTypeId("普通宾客");
        guestType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String)e.getItem();
                    livein.setrTypeId(selectedItem);
                }
            }
        });
        guestType.setBounds(73,110,80,25);
        add(guestType);

        createJLabel("主客姓名:",182,110,65,30);

        guestName = new JTextField();
        livein.setcName("text");
        livein.setcJp("text");
        guestName.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            public void printIt() {
                String text = guestName.getText();
                livein.setcName(text);
                livein.setcJp(text);
            }
        });

        guestName.setBounds(239,110,160,25);
        add(guestName);

        createJLabel("宾客人数:",428,110,65,30);

        guestCount = new JTextField("1");
        livein.setRenshu(1);
        guestCount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void printIt() {
                if(!guestCount.getText().equals("")&&!guestCount.getText().equals(null)) {
                    Integer text = Integer.valueOf(guestCount.getText());
                    livein.setRenshu(text);
                }else {
                    livein.setRenshu(1);
                }
            }
        });
        guestCount.setBounds(483,110,80,25);
        add(guestCount);

        //-----------------------------------------------------------------------------

        createJLabel("地址信息:",18,150,65,30);

        addressInfo = new JTextField();
        livein.setAddress("");
        addressInfo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void printIt() {
                String text = addressInfo.getText();
                livein.setAddress(text);
            }
        });
        addressInfo.setBounds(73,150,490,25);
        add(addressInfo);

        createJLabel("备注信息:",18,190,65,30);

        otherInfo = new JTextField();
        livein.setRemark("");
        otherInfo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void printIt() {
                String text = otherInfo.getText();
                livein.setRemark(text);
            }

        });
        otherInfo.setBounds(73,190,490,25);
        add(otherInfo);

        //-----------------------------------------------------------------------------
        createJLabel("折扣比例:",18,230,65,30);

        discount = new JLabel("10");
        discount.setBounds(73,230,40,30);
        add(discount);


        createJLabel("实际单价:",140,230,65,30);

        actualPrice = new JTextField("200.00");
        livein.setAccount(200.00);
        actualPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void printIt() {
                Double text = Double.valueOf(actualPrice.getText());

                livein.setAccount(text);
            }
        });
        actualPrice.setBounds(195,230,53,30);
        add(actualPrice);

        createJLabel("预住天数:",270,230,65,30);

        useRoomDays = new JTextField("1");
        livein.setDays(1);
        useRoomDays.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void printIt() {
                Integer text = Integer.valueOf(useRoomDays.getText());

                livein.setDays(text);
            }
        });
        useRoomDays.setBounds(325,230,60,30);
        add(useRoomDays);

        createJLabel("实收押金:",420,230,65,30);

        cashPledge = new JTextField("50.00");
        livein.setForegift(50.00);
        cashPledge.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                printIt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                printIt();
            }
            public void printIt() {
                Double text = Double.valueOf(cashPledge.getText());
                livein.setForegift(text);
            }
        });
        cashPledge.setBounds(480,230,80,30);
        add(cashPledge);

        //-----------------------------------------------------------------------------

        createJLabel("追加房间",18,280,53,30);

        JLabel jLabel13 = new JLabel("可供房间");
        jLabel13.setFont(font);//字体
        jLabel13.setHorizontalAlignment(JLabel.CENTER);
        jLabel13.setBounds(18,320,200,30);
        jLabel13.setOpaque(true);
        jLabel13.setBackground(Color.orange);
        add(jLabel13);

        List<String>emptyRooms=new ArrayList<>();
        for(RoomInfo t:roomInfoList){
            if(!t.getId().equals(roomInfo.getId()))
                emptyRooms.add(t.getId());
        }
        Collections.sort(emptyRooms);
        emptyRoomList = new JList<>(emptyRooms.toArray(new String[0]));
        emptyRoomList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                leftIndex = e.getFirstIndex();
            }
        });
        JScrollPane jScrollPane1=new JScrollPane(emptyRoomList);
        jScrollPane1.setBounds(18,350,200,200);

        add(jScrollPane1);

        JLabel jLabel14 = new JLabel("开单房间");



        jLabel14.setFont(font);
        jLabel14.setHorizontalAlignment(JLabel.CENTER);
        jLabel14.setBounds(360,320,200,30);
        jLabel14.setOpaque(true);
        jLabel14.setBackground(Color.orange);
        add(jLabel14);

        List<String>billRooms=new ArrayList<>();
        billRooms.add(roomInfo.getId());
        billRoomList = new JList<>(billRooms.toArray(new String[0]));;
        billRoomList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                rightIndex = e.getFirstIndex();

            }
        });

        JScrollPane jScrollPane2=new JScrollPane(billRoomList);
        jScrollPane2.setBounds(360,350,200,200);

        add(jScrollPane2);

        addRoom = new JButton(">");
        addRoom.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(leftIndex!=null){
                    billRooms.add(emptyRooms.get(leftIndex));
                    Collections.sort(billRooms);
                    emptyRooms.remove((int)leftIndex);
                    billRoomList.setListData(billRooms.toArray(new String[0]));
                    emptyRoomList.setListData(emptyRooms.toArray(new String[0]));


                    leftIndex=null;
                }


            }
        });
        addRoom.setMargin(new Insets(0, 0, 0, 0));
        addRoom.setBounds(275,400,30,30);
        addRoom.setBorderPainted(false);
        addRoom.setFocusPainted(false);
        addRoom.addActionListener(this);
        add(addRoom);

        deleteRoom = new JButton("<");
        deleteRoom.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!roomInfo.getId().equals(billRooms.get(rightIndex)))
                    if(rightIndex!=null){
                        emptyRooms.add(billRooms.get(rightIndex));
                        Collections.sort(emptyRooms);
                        billRooms.remove((int)rightIndex);
                        billRoomList.setListData(billRooms.toArray(new String[0]));
                        emptyRoomList.setListData(emptyRooms.toArray(new String[0]));



                        rightIndex=null;
                    }
            }
        });
        deleteRoom.setMargin(new Insets(0, 0, 0, 0));
        deleteRoom.setBounds(275,450,30,30);
        deleteRoom.setBorderPainted(false);
        deleteRoom.setFocusPainted(false);
        deleteRoom.addActionListener(this);
        add(deleteRoom);

        confirm = new JButton("确认");
        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                livein.setChkNo(String.valueOf(new Date().getTime()));
                livein.setChkTime( LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                livein.setUserId("123");
                livein.setStatemark("已结算");

                try {
                    for (String roomInfoId : billRooms) {
                        System.out.println(roomInfoId);
                        roomInfoService.updateByState(roomInfoId, "占用");
                        Livein liveinTemp = new Livein();
                        liveinTemp = livein;
                      
                        liveinTemp.setPk(BigDecimal.valueOf((long) (Math.random() * 1000)));
                        liveinTemp.setrNo(roomInfoId);
                        liveinService.insert(liveinTemp);
                    }

                    setVisible(false);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        confirm.setMargin(new Insets(0, 0, 0, 0));
        confirm.setBounds(150,570,100,30);
        confirm.setBorderPainted(false);
        confirm.setFocusPainted(false);
        confirm.addActionListener(this);
        add(confirm);

        cancel = new JButton("取消");
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                setVisible(false);
            }
        });
        cancel.setMargin(new Insets(0, 0, 0, 0));
        cancel.setBounds(320,570,100,30);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
/*
        updateRoomInfo();
        updateJLists();*/
    }



    void createJLabel(String title,int x,int y ,int width,int height)
    {
        JLabel jLabel = new JLabel(title);
        jLabel.setBounds(x,y,width,height);
        add(jLabel);
    }

    JLabel createJLabelOfCenter(JLabel jLabel,String title,int x,int y ,int width,int height)
    {
        jLabel = new JLabel(title);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setBounds(x,y,width,height);
        add(jLabel);
        return jLabel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
