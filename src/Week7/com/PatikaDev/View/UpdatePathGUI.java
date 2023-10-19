package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.Path;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePathGUI extends JFrame{
    private JPanel wrapper;
    private JTextField fld_pathName;
    private JButton btn_update;
    private Path path;
    public UpdatePathGUI(Path path){
     this.path=path;
     add(wrapper);
     setSize(300,150);
     setLocation(Helper.screenCenterLocation("x",getSize()),Helper.screenCenterLocation("y",getSize()));
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     setTitle(Config.PROJECT_TITLE);
     setVisible(true);

     fld_pathName.setText(path.getName());
        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_pathName)){
                    Helper.showMassage("fill");
                }else{
                    if(Path.update(path.getId(),fld_pathName.getText())){
                        Helper.showMassage("done");

                    }
                    dispose();
                }
            }
        });
    }
}
