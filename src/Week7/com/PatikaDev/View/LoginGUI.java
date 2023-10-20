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
    private JButton btn__login;

    public LoginGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterLocation("x",getSize()),Helper.screenCenterLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn__login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_userUname)||Helper.isFieldEmpty(fld_userPass)){
                    Helper.showMassage("fill");
                }else{
                    User u = User.getFetch(fld_userUname.getText(),fld_userPass.getText());
                    if(u==null){
                        Helper.showMassage("User not found !");
                    }else{
                        switch (u.getType()){
                            case "operator":
                                OperatorGUI operatorGUI =new OperatorGUI((Operator) u);
                                break;
                            case "educator":
                                EducatorGUI educatorGUI = new EducatorGUI();
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
    }
    public static void main (String[] args){
        Helper.setLayout();
        LoginGUI log = new LoginGUI();
    }
}
