package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.Content;
import Week7.com.PatikaDev.Model.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContentGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_courseName;
    private JTextField fld_contentName;
    private JButton addButton;
    private JButton deleteButton;
    private JButton selectButton;
    private JComboBox cmb_contentHeader;
    private DefaultTableModel mdl_myContentList;
    private Object[] row_myContentList;
    private JTable tbl_contentList;
    private JScrollPane scrl_contentList;
    private Course course;

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
        lbl_courseName.setText(course.getName());

        mdl_myContentList = new DefaultTableModel();
        Object[] col_myContentList ={"Content Id","Content Name"};
        mdl_myContentList.setColumnIdentifiers(col_myContentList);
        row_myContentList = new Object[col_myContentList.length];
        loadContentModel(2);
        tbl_contentList.setModel(mdl_myContentList);
        tbl_contentList.getTableHeader().setReorderingAllowed(false);
        tbl_contentList.getColumnModel().getColumn(0).setMaxWidth(75);
    }

    private void loadContentModel(int id) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_contentList.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Content obj : Content.getListByCourse(id)){
            i=0;
            row_myContentList[i++]=obj.getId();
            row_myContentList[i++]=obj.getName();
            mdl_myContentList.addRow(row_myContentList);

        }
    }
}
