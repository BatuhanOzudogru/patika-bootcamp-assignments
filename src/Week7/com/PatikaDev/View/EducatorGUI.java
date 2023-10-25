package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.DBConnector;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.Course;
import Week7.com.PatikaDev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_educatorWelcome;
    private JTabbedPane tab_educator;
    private JTable tbl_myCourses;
    private JScrollPane scrl_myCourses;
    private JButton selectButton;
    private JTextField fld_courseName;
    private JButton btn_logout;
    private JTextField fld_courseId;
    private DefaultTableModel mdl_myCourseList;
    private Object[] row_myCourseList;
    private  User user;

    public EducatorGUI(User user)  {
        this.user=user;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        fld_courseId.setVisible(false);
        lbl_educatorWelcome.setText("Welcome "+ user.getName());

        mdl_myCourseList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0||column==1){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };



        Object[] col_myCourseList ={"Course Id","Course Name"};
        mdl_myCourseList.setColumnIdentifiers(col_myCourseList);
        row_myCourseList = new Object[col_myCourseList.length];
        loadCourseModel();
        tbl_myCourses.setModel(mdl_myCourseList);
        tbl_myCourses.getTableHeader().setReorderingAllowed(false);
        tbl_myCourses.getColumnModel().getColumn(0).setMaxWidth(75);

        tbl_myCourses.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_courseName=tbl_myCourses.getValueAt(tbl_myCourses.getSelectedRow(),1).toString();
                    String select_courseId=tbl_myCourses.getValueAt(tbl_myCourses.getSelectedRow(),0).toString();
                    fld_courseName.setText(select_courseName);
                    fld_courseId.setText(select_courseId);
                }catch (Exception exception){

                }
            }
        });

        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI loginGUI = new LoginGUI();
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_courseName)){
                    Helper.showMessage("fill");
                }else{
                    Course c = Course.getFetch(Integer.parseInt(fld_courseId.getText()));

                    ContentGUI contentGUI = new ContentGUI(c);
                }

            }
        });
    }
    public static ArrayList<Course> getListByUser(int user_id){
        ArrayList<Course> courseList = new ArrayList<>();

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course WHERE user_id = " + user_id);
            while(rs.next()){
                int id = rs.getInt("id");
                int userId= rs.getInt("user_id");
                int pathId= rs.getInt("path_id");
                String name= rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Course(id,userId,pathId,name,lang);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;

    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_myCourses.getModel();
        clearModel.setRowCount(0);
            for(Course obj : getListByUser(user.getId())){
                row_myCourseList[0]=obj.getId();
                row_myCourseList[1]=obj.getName();
                mdl_myCourseList.addRow(row_myCourseList);
        }
    }
}
