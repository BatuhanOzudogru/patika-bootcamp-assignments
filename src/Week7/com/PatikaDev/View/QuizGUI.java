package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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
    private JTextField fld_hiddenId;
    private JTable tbl_quizList;
    private JButton newQuizButton;
    private static Content content;
    private DefaultTableModel mdl_myQuizList;
    private Object[] row_myQuizList;


    public QuizGUI(Content content) {

        this.content = content;
        add(wrapper);
        setSize(700, 700);
        setLocation(Helper.screenCenterLocation("x", getSize()), Helper.screenCenterLocation("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        txt_questions.setSize(50, 50);
        txt_questions.setLineWrap(true);
        lbl_contentName.setText(content.getName());
        fld_hiddenId.setVisible(false);

        mdl_myQuizList=new DefaultTableModel();

        Object[] col_myQuizList ={"Id","Quiz Name"};
        mdl_myQuizList.setColumnIdentifiers(col_myQuizList);
        row_myQuizList = new Object[col_myQuizList.length];
        //loadContentModel(course.getId());
        tbl_quizList.setModel(mdl_myQuizList);
        tbl_quizList.getTableHeader().setReorderingAllowed(false);
        tbl_quizList.getColumnModel().getColumn(0).setMaxWidth(30);
        loadQuizModel();

        tbl_quizList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{

                    String select_quizId=tbl_quizList.getValueAt(tbl_quizList.getSelectedRow(),0).toString();


                    fld_hiddenId.setText(select_quizId);
                }catch (Exception exception){

                }
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_quizName) || Helper.isFieldEmpty(txt_questions)) {
                    Helper.showMessage("fill");
                } else {
                    String quizName = fld_quizName.getText();
                    String quizText = txt_questions.getText();

                    //course-content ilişkisinide yiyen bunda yemedi
                    // quizName,quizText böyleydi
                    if (Quiz.add(quizName, quizText, content.getId())) {
                        Helper.showMessage("done");
                        loadQuizModel();

                        fld_quizName.setText(null);
                        txt_questions.setText(null);

                    }
                }
            }

        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(fld_hiddenId.getText());
                String name=Quiz.getFetchName(id).getQuiz_name();
                fld_quizName.setText(name);
                String text=Quiz.getFetchText(id).getQuiz_text();
                txt_questions.setText(text);



            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_hiddenId)) {
                    Helper.showMessage("Pick a quiz to delete");
                } else {
                    if(Helper.confirm("sure")){
                        int quizId = Integer.parseInt(fld_hiddenId.getText());
                        if (Quiz.delete(quizId)) {
                            Helper.showMessage("done");
                            loadQuizModel();
                            fld_hiddenId.setText(null);
                            fld_quizName.setText(null);
                            txt_questions.setText(null);
                        } else {
                            Helper.showMessage("error");
                        }
                    }
                }
            }
        });


        newQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fld_quizName.setText(null);
                txt_questions.setText(null);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(fld_hiddenId.getText());
                String quizName = fld_quizName.getText();
                String quizText = txt_questions.getText();
               if(Quiz.update(id,quizName,quizText)){
                   Helper.showMessage("done");
                   loadQuizModel();
                   fld_quizName.setText(null);
                   txt_questions.setText(null);
                } else {
                   Helper.showMessage("error");
               }
            }
        });
    }
    private void loadQuizModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_quizList.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Quiz obj : Quiz.getListByContent(content.getId())){
            i=0;
            row_myQuizList[i++] = obj.getId();
            row_myQuizList[i++] = obj.getQuiz_name();

            mdl_myQuizList.addRow(row_myQuizList);

        }
    }



}
