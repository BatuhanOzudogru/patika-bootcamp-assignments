package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_signupName;
    private JTextField fld_signupUsername;
    private JTextField fld_signupPass;
    private JButton signUpButton;

    public SignUpGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterLocation("x",getSize()),Helper.screenCenterLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_signupPass)||Helper.isFieldEmpty(fld_signupUsername)||Helper.isFieldEmpty(fld_signupName)){
                    Helper.showMessage("fill");
                }else{
                    if(User.add(fld_signupName.getText(),fld_signupUsername.getText(),fld_signupPass.getText(),"student"))
                    {
                        Helper.showMessage("done");
                        dispose();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SignUpGUI s = new SignUpGUI();

    }
}
