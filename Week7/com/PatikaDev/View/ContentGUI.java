package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.Content;
import Week7.com.PatikaDev.Model.Course;
import Week7.com.PatikaDev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ContentGUI extends JFrame  {
    private JPanel wrapper;
    private JLabel lbl_courseName;
    private JTextField fld_contentName;
    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private DefaultTableModel mdl_myContentList;
    private Object[] row_myContentList;
    private JTable tbl_contentList;
    private JScrollPane scrl_contentList;
    private JTextField fld_hiddenDelete;
    private Course course;

    private JPopupMenu quizMenu;

    public ContentGUI(Course course){
        this.course=course;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        fld_hiddenDelete.setVisible(false);
        lbl_courseName.setText(course.getName());


        mdl_myContentList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0||column==4){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };




        quizMenu=new JPopupMenu();
        JMenuItem addQuiz= new JMenuItem("Add/Update Quiz");
        quizMenu.add(addQuiz);

        addQuiz.addActionListener((ActionListener) e -> {
            Content c = Content.getFetch(Integer.parseInt(fld_hiddenDelete.getText()));
            QuizGUI qGUI =new QuizGUI(c);
        });


        Object[] col_myContentList ={"Content Id","Content Name","Description","Youtube Link","Quiz"};
        mdl_myContentList.setColumnIdentifiers(col_myContentList);
        row_myContentList = new Object[col_myContentList.length];
        loadContentModel(course.getId());
        tbl_contentList.setModel(mdl_myContentList);
        tbl_contentList.setComponentPopupMenu(quizMenu);
        tbl_contentList.getTableHeader().setReorderingAllowed(false);
        tbl_contentList.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_contentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow=tbl_contentList.rowAtPoint(point);
                tbl_contentList.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKeyLow = fld_contentName.getText().toLowerCase();
                String searchKeyUp = fld_contentName.getText().toUpperCase();

                DefaultTableModel clearModel = (DefaultTableModel) tbl_contentList.getModel();
                clearModel.setRowCount(0);
                int i = 0;
                for (Content obj : Content.getListByCourse(course.getId())) {
                    if (obj.getName().toLowerCase().contains(searchKeyLow) || obj.getName().toUpperCase().contains(searchKeyUp)) {
                        i = 0;
                        row_myContentList[i++] = obj.getId();
                        row_myContentList[i++] = obj.getName();
                        row_myContentList[i++] = obj.getDescription();
                        row_myContentList[i++] = obj.getYoutubeLink();
                        row_myContentList[i] = obj.getQuizId();
                        mdl_myContentList.addRow(row_myContentList);
                    }
                }
            }
        });
        addButton.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_contentName)) {
                Helper.showMessage("fill");
            } else {
                String name = fld_contentName.getText();

                if (Content.add(name)) {
                    Helper.showMessage("done");
                    loadContentModel(course.getId());
                    fld_contentName.setText(null);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_hiddenDelete)) {
                    Helper.showMessage("fill");
                } else {
                    if(Helper.confirm("sure")){
                        int contentId = Integer.parseInt(fld_hiddenDelete.getText());
                        if (Content.delete(contentId)) {
                            Helper.showMessage("done");
                            loadContentModel(course.getId());
                            fld_hiddenDelete.setText(null);
                        } else {
                            Helper.showMessage("error");
                        }
                    }
                }
            }
        });
        tbl_contentList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_contentId=tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),0).toString();
                    fld_hiddenDelete.setText(select_contentId);
                    String select_contentName=tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),1).toString();
                    fld_contentName.setText(select_contentName);
                }catch (Exception exception){

                }
            }
        });
        tbl_contentList.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int contentId = Integer.parseInt(tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),0).toString());
                    String contentName = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),1).toString();
                    String description = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),2).toString();
                    String youtubeLink = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),3).toString();
                    int quizId = Integer.parseInt(tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(),4).toString());

                    if(Content.update(contentId,contentName,description,youtubeLink,course.getId())){
                        Helper.showMessage("done");
                    }
                    loadContentModel(course.getId());
                }
            }
        });
    }



    private void loadContentModel(int id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_contentList.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Content obj : Content.getListByCourse(id)){
            i=0;
            row_myContentList[i++] = obj.getId();
            row_myContentList[i++] = obj.getName();
            row_myContentList[i++] = obj.getDescription();
            row_myContentList[i++] = obj.getYoutubeLink();
            row_myContentList[i++] = obj.getQuizId();
            mdl_myContentList.addRow(row_myContentList);

        }
    }
}
