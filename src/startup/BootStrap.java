package startup;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import view.frame.LoginFrame;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ZQ
 */

//TODO 美化包使用后面板变白的问题待解决
public class BootStrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        //使用美化包
        try {
            //设置本属性将窗口边框样式定义
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /*
        //隐藏设置按钮
        UIManager.put("RootPane.setupButtonVisible",false);      
         */
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                LoginFrame.instance.setVisible(true);
            }
        });
    }
}
