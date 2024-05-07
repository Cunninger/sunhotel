package com.hhu.ui.frame;

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
    private JButton btnOk,btnCancel,btnRegister;
    private static Integer screenWidth,screenHeight,x,y;
    private Pwd pwd = new Pwd();
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
        lblTop.setBounds(0,0,431,54);
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
        // TODO
        // 增加注册按钮
        btnRegister = new JButton("注册");
        btnRegister.setBounds(260,180,60,35);



        JComponent[] jComponents = {lblTop,lblUsername,lblPwd,txtUsername,txtPwd
        ,btnCancel,btnOk,btnRegister};
        add(jComponents);
        // 创建btn事件
        btnOk.addActionListener(new BtnOkListenner());
        btnCancel.addActionListener(new BtnCancelListenner());
        btnRegister.addActionListener(new BtnRegisterListenner());

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

            try {
               Boolean flag = pwdService.login(userId,password);
               pwd.setUserId(userId);
               pwd.setPwd(password);
               if(flag){
                   System.out.println("登录成功");
                   //写日志
                   Record record = new Record();
                   record.setTime(DateUtils.date2String(new Date()));
                   record.setOperator(userId);
                   record.setBrief("记录");
                   record.setContent(userId + "登录系统");
                   recordService.save(record);

                     // 关闭当前窗口
                        dispose();
                   new MainFrame(pwd);
               }
                } catch (Exception ex) {
                    String msg =  ex.getMessage();
                    JOptionPane.showMessageDialog(null, msg);
                }

        }
    }

    // BtnCancelListenner
    class BtnCancelListenner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 关闭当前窗口
            dispose();
        }
    }
    // BtnRegisterListenner
    class BtnRegisterListenner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // 关闭当前窗口
            dispose();
            new RegisterFrame();
        }
    }

}

