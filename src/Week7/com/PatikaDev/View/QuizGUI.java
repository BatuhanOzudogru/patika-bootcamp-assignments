package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.Content;
import Week7.com.PatikaDev.Model.Course;
import Week7.com.PatikaDev.Model.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGUI extends JFrame {

    private JPanel wrapper;
    private JLabel lbl_contentName;
    private JButton selectButton;
    private JComboBox cmb_quizList;
    private JTextField fld_quizName;
    private JTextArea txt_questions;
    private JButton deleteButton;
    private JButton addButton;
    private JButton updateButton;
    private static Content content;

public QuizGUI (Content content){
    this.content=content;
    add(wrapper);
    setSize(700,700);
    setLocation(Helper.screenCenterLocation("x",getSize()),Helper.screenCenterLocation("y",getSize()));
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle(Config.PROJECT_TITLE);
    setResizable(false);
    setVisible(true);
    txt_questions.setSize(50, 50);
    txt_questions.setLineWrap(true);
    lbl_contentName.setText(content.getName());


    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Helper.isFieldEmpty(fld_quizName)||Helper.isFieldEmpty(txt_questions)) {
                Helper.showMessage("fill");
            } else {
                String quizName = fld_quizName.getText();
                String quizText = txt_questions.getText();








                            //course-content ilişkisinide yiyen bunda yemedi
                          // quizName,quizText böyleydi
                if (Quiz.add(quizName,quizText,content.getId())) {
                    Helper.showMessage("done");
                    //loadQuizCombo(content.getId());

                    fld_quizName.setText(null);
                }
            }
        }
    });
}

}
