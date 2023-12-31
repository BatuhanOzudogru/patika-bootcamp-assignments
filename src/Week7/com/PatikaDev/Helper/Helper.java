package Week7.com.PatikaDev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static int screenCenterLocation(String axis, Dimension size) {
        int point = 0;
        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }
    public static boolean isFieldEmpty(JTextArea area) {
        return area.getText().trim().isEmpty();
    }

    public static void showMessage(String str) {
        optionPage();
        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Please fill all areas ! ";
                title = "Error !";
                break;
            case "done":
                msg = "The operation is successful";
                title = "Notification";
                break;
            case "error":
                msg = "An error has occurred";
                title = "Error";
                break;
            default:
                msg = str;
                title = "Message";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void optionPage() {
        UIManager.put("OptionPane.okButtonText", "Okay");
        UIManager.put("OptionPane.yesButtonText", "YES");
        UIManager.put("OptionPane.noButtonText", "NO");
    }
    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure":
                msg= "Are you sure ?";
                break;
            default:
                msg=str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Sure",JOptionPane.YES_NO_OPTION)==0;
    }

}
