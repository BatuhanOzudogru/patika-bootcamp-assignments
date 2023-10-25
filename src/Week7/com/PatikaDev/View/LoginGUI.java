package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.Operator;
import Week7.com.PatikaDev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_userUname;
    private JPasswordField fld_userPass;
    private JButton btn_login;
    private JButton btn_signup;

    public LoginGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterLocation("x",getSize()),Helper.screenCenterLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_userUname)||Helper.isFieldEmpty(fld_userPass)){
                    Helper.showMessage("fill");
                }else{
                    User u = User.getFetch(fld_userUname.getText(),fld_userPass.getText());
                    if(u==null){
                        Helper.showMessage("User not found !");
                    }else{
                        switch (u.getType()){
                            case "operator":
                                OperatorGUI operatorGUI =new OperatorGUI((Operator) u);
                                break;
                            case "educator":
                                EducatorGUI educatorGUI = new EducatorGUI(u);
                                break;
                            case "student":
                                StudentGUI studentGUI = new StudentGUI();
                                break;
                        }
                        dispose();
                    }
                }
            }
        });
        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpGUI s = new SignUpGUI();
            }
        });
    }
    public static void main (String[] args){
        Helper.setLayout();
        LoginGUI log = new LoginGUI();
    }
}
