package com.hhu.ui;

import com.hhu.awt.MyJFrame;
import com.hhu.domain.entity.Pwd;
import com.hhu.domain.entity.Record;
import com.hhu.service.PwdService;
import com.hhu.service.RecordService;
import com.hhu.service.Impl.PwdServiceImpl;
import com.hhu.service.Impl.RecordServiceImpl;
import com.hhu.util.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class LoginFrame extends MyJFrame{
    private PwdService pwdService = new PwdServiceImpl();
    private RecordService recordService = new RecordServiceImpl();
    private JLabel lblTop,lblUsername,lblPwd;
    private JTextField txtUsername;
    private JPasswordField txtPwd;
    private JButton btnOk,btnCancel;
    private static Integer screenWidth,screenHeight,x,y;
    static {
        // 获取默认工具包
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕尺寸
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        x = screenWidth / 2;
        y = screenHeight / 2;
    }
    public LoginFrame(){
        super("用户登录",x,y,431,300);
        ImageIcon icon = new ImageIcon("src/main/resources/pic/Login_top.gif");
        // 添加top图片
        lblTop = new JLabel(icon);
        lblTop.setBounds(0,0,431,53);
        // 用户名标签
        lblUsername = new JLabel("用户名");
        lblUsername.setHorizontalAlignment(JLabel.RIGHT);
        lblUsername.setBounds(50,90,60,35);
        // 密码标签
        lblPwd = new JLabel("密码");
        lblPwd.setHorizontalAlignment(JLabel.RIGHT);
        lblPwd.setBounds(50,135,60,35);
        // 用户名输入框
        txtUsername = new JTextField();
        txtUsername.setBounds(120,90,230,35);
        // 密码输入框
        txtPwd = new JPasswordField();
        txtPwd.setBounds(120,135,230,35);
        // 确定和取消按钮
        btnOk = new JButton("登录");
        btnOk.setBounds(120,180,60,35);
        btnCancel = new JButton("取消");
        btnCancel.setBounds(190,180,60,35);
        JComponent[] jComponents = {lblTop,lblUsername,lblPwd,txtUsername,txtPwd
        ,btnCancel,btnOk};
        add(jComponents);
        // 创建btn事件
        btnOk.addActionListener(new BtnOkListenner());

    }

    /**
     * 监听ok按键事件
     */
    class BtnOkListenner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 接收用户请求
            String userId = txtUsername.getText();
            String password = txtPwd.getText();
            // 调用业务模型， 响应结果
            Pwd pwd = new Pwd();
            try {
               Boolean flag = pwdService.login(userId,password);
               if(flag){
                   System.out.println("登录成功");
                   //写日志
                   Record record = new Record();
                   record.setTime(DateUtils.date2String(new Date()));
                   record.setOperator(userId);
                   record.setBrief("这个好像要设置，不然会空");
                   record.setContent(userId + "登录系统");
                   recordService.save(record);

                     // 关闭当前窗口
                        dispose();
                   new MainFrame();
               }
            } catch (Exception ex) {
                String msg =  ex.getMessage();
                JOptionPane.showMessageDialog(null, msg);
            }

        }
    }

}

