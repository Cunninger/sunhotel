package com.hhu.ui;

/**
 * 功能：
 * 日期：2024/4/11 上午10:22
 */

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


public class RegisterFrame extends MyJFrame{
    private PwdService pwdService = new PwdServiceImpl();
    private RecordService recordService = new RecordServiceImpl();
    private JLabel lblTop,lblUsername,lblPwd;
    private JTextField txtUsername;
    private JPasswordField txtPwd;
    private JButton backToLogin,btnRegister;
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
    public RegisterFrame(){
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
        backToLogin = new JButton("返回登录");
        backToLogin.setBounds(120,180,120,35);

        // TODO
        // 增加注册按钮
        btnRegister = new JButton("注册");
        btnRegister.setBounds(260,180,60,35);



        JComponent[] jComponents = {lblTop,lblUsername,lblPwd,txtUsername,txtPwd
                ,backToLogin,btnRegister};
        add(jComponents);
        // 创建btn事件
        backToLogin.addActionListener(new backToLoginListenner());

        btnRegister.addActionListener(new BtnRegisterListenner());

    }

   //backToLoginListenner
    class backToLoginListenner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 关闭当前窗口
            dispose();
            new LoginFrame();
        }
    }


    // BtnRegisterListenner
    class BtnRegisterListenner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 接收用户请求
            String userId = txtUsername.getText();
            String password = new String(txtPwd.getPassword());
            Pwd pwd = new Pwd();
            pwd.setUserId(userId);
            pwd.setPwd(password);
            pwd.setPuis("1");
            pwd.setDelmark(0);
            try {
                pwdService.save(pwd);
                // 记录日志
                Record record = new Record();
                record.setTime(DateUtils.dateToString(new Date()));
                record.setOperator(userId);
                record.setBrief("用户注册");
                record.setContent("用户注册成功");
                record.setDelmark(0);
                recordService.save(record);
                JOptionPane.showMessageDialog(null,"注册成功");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"用户名已存在");
            }
        }
    }

}

