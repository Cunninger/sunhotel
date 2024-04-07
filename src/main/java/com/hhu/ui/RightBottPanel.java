package com.hhu.ui;

//import com.sun.deploy.panel.JreTableModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class RightBottPanel extends JPanel {
    public RightBottPanel(){
        super(new BorderLayout());
        // 声明表格,数据和显示分离rbDTM，带滚动条sp
        DefaultTableModel rbDTM = new DefaultTableModel();
        JTable tb = new JTable(rbDTM);
        JScrollPane sp = new JScrollPane(tb);
        // 初始化表格数据
        iniDTM(rbDTM);
        //设置表格属性
        tb.setRowHeight (18);//表格的行高度
        tb.setEnabled(false);
        //将表格加入面板
       this.add("Center",sp);
    }

    /**
     * 为rbDTM加入数据
     * @param rbDTM
     */
    public static void iniDTM(DefaultTableModel rbDTM) {
        String[] columns = new String[] { "入住单号", "主房间号", "标准单价", "宾客类型" ,
                "享受折扣" , "消费金额" , "消费时间" , "记账人" };
        String[][] data = new String[][] { { "R24001", "BD001", "100", "普通宾客",
                "10", "100", "2024-3-20", "test100" }};
        rbDTM.setDataVector(data,columns);
    }
}
