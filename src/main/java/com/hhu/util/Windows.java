package com.hhu.util;

import java.awt.*;

public class Windows {
    public static final String IMGPATH = "src/main/resources/pic/";//图片路径
    public static int screenWidth,screenHeight,x,y;
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
}
