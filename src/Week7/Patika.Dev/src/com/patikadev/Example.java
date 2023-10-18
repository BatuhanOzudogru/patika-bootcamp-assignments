package com.patikadev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;

    public Example(){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        setContentPane(wrapper);
        setSize(400,300);
        setTitle("Uygulama Adı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //pencereyi kapantınca program kapansın
        setResizable(false);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width-getSize().width)/2;
        int y =(Toolkit.getDefaultToolkit().getScreenSize().height-getSize().height)/2;
        setLocation(x,y);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if(fld_username.getText().length()==0 || fld_password.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Tüm Alanları Doldurun ! ","Hata",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }


}
