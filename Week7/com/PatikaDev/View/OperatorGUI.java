package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.*;
import Week7.com.PatikaDev.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_userForm;
    private JTextField fld_userName;
    private JTextField fld_userUName;
    private JTextField fld_userPass;
    private JComboBox cmb_userType;
    private JButton btn_userAdd;
    private JTextField fld_userId;
    private JButton btn_userDelete;
    private JTextField fld_searchUserName;
    private JTextField fld_searchUserUName;
    private JComboBox cmb_searchUserType;
    private JButton btn_userSearch;
    private JPanel pnl_pathList;
    private JScrollPane scrl_pathList;
    private JTable tbl_pathList;
    private JPanel pnl_pathAdd;
    private JTextField fld_pathName;
    private JButton btn_pathAdd;
    private JPanel pnl_userTab;
    private JPanel pnl_courseList;
    private JScrollPane scrl_courseList;
    private JTable tbl_courseList;
    private JPanel pnl_courseAdd;
    private JTextField fld_courseName;
    private JTextField fld_CourseLang;
    private JComboBox cmb_coursePath;
    private JComboBox cmb_courseEducator;
    private JButton btn_courseAdd;
    private JTable tbl_allContent;
    private JButton deleteButtonContent;
    private JTextField fld_contentId;
    private JTable tbl_allQuiz;
    private JButton deleteButtonQuiz;
    private JTextField fld_quizId;
    private JButton deleteButtonCourse;
    private JTextField fld_hiddenCourseId;
    private DefaultTableModel mdl_userList;
    private Object[] row_userList;
    private final Operator operator;
    private DefaultTableModel mdl_pathList;
    private Object[] row_pathList;
    private  JPopupMenu pathMenu;
    private DefaultTableModel mdl_courseList;
    private Object[] row_courseList;
    private DefaultTableModel mdl_contentList;
    private Object[] row_contentList;
    private DefaultTableModel mdl_quizList;
    private Object[] row_quizList;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Welcome " + operator.getName());
        fld_hiddenCourseId.setVisible(false);

        //UserList
        mdl_userList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_userList = {"ID", "Name Surname", "Username", "Password", "Type"};
        mdl_userList.setColumnIdentifiers(col_userList);
        row_userList = new Object[col_userList.length];

        loadUserModel();

        tbl_userList.setModel(mdl_userList);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        tbl_userList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_userId=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString();
                    fld_userId.setText(select_userId);
                }catch (Exception exception){

                }
            }
        });
        tbl_userList.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int user_id = Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString());
                    String user_name = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),1).toString();
                    String user_uname = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),2).toString();
                    String user_pass = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),3).toString();
                    String user_type = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),4).toString();

                    if(User.update(user_id,user_name,user_uname,user_pass,user_type)){
                        Helper.showMessage("done");
                    }
                    loadUserModel();
                    loadEducatorCombo();
                    loadCourseModel();
                }
            }
        });

        //PathList
        pathMenu=new JPopupMenu();
        JMenuItem updateMenu= new JMenuItem("Update");
        JMenuItem deleteMenu= new JMenuItem("Delete");
        pathMenu.add(updateMenu);
        pathMenu.add(deleteMenu);

        updateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int select_id=Integer.parseInt(tbl_pathList.getValueAt(tbl_pathList.getSelectedRow(),0).toString());
                UpdatePathGUI updateGUI =new UpdatePathGUI(Path.getFetch(select_id));
                updateGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadPathModel();
                        loadPathCombo();
                        loadCourseModel();
                    }
                });
            }
        });

        deleteMenu.addActionListener(e -> {
            if(Helper.confirm("sure")){
                int select_id=Integer.parseInt(tbl_pathList.getValueAt(tbl_pathList.getSelectedRow(),0).toString());
                if(Path.delete(select_id)){
                    Helper.showMessage("done");
                    loadPathModel();
                    loadPathCombo();
                    loadCourseModel();
                }else{
                    Helper.showMessage("error");
                }
            }

        });

        mdl_pathList= new DefaultTableModel();
        Object[] col_pathList = {"ID", "Path Name"};
        mdl_pathList.setColumnIdentifiers(col_pathList);
        row_pathList=new Object[col_pathList.length];
        loadPathModel();

        tbl_pathList.setModel(mdl_pathList);
        tbl_pathList.setComponentPopupMenu(pathMenu);
        tbl_pathList.getTableHeader().setReorderingAllowed(false);
        tbl_pathList.getColumnModel().getColumn(0).setMaxWidth(100);

        tbl_pathList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow=tbl_pathList.rowAtPoint(point);
                tbl_pathList.setRowSelectionInterval(selectedRow,selectedRow);


            }
        });
        //pathlist """""""

        //courseList
        mdl_courseList=new DefaultTableModel();
        Object[] col_courseList = {"ID","Course Name", "Language","Path","Educator"};
        mdl_courseList.setColumnIdentifiers(col_courseList);
        row_courseList = new Object[col_courseList.length];
        loadCourseModel();
        tbl_courseList.setModel(mdl_courseList);
        tbl_courseList.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_courseList.getTableHeader().setReorderingAllowed(false);

        loadPathCombo();
        loadEducatorCombo();

        tbl_courseList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_courseId=tbl_courseList.getValueAt(tbl_courseList.getSelectedRow(),0).toString();
                    fld_hiddenCourseId.setText(select_courseId);
                }catch (Exception exception){

                }
            }
        });
        //courseList """""""""

        mdl_contentList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_contentList = {"ID", "Name"};
        mdl_contentList.setColumnIdentifiers(col_contentList);
        row_contentList = new Object[col_contentList.length];

        loadContentModel();

        tbl_allContent.setModel(mdl_contentList);
        tbl_allContent.getTableHeader().setReorderingAllowed(false);
        tbl_allContent.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int content_id = Integer.parseInt(tbl_allContent.getValueAt(tbl_allContent.getSelectedRow(),0).toString());
                    String content_name = tbl_allContent.getValueAt(tbl_allContent.getSelectedRow(),1).toString();


                    if(Content.updateName(content_id,content_name)){
                        Helper.showMessage("done");
                    }

                    loadContentModel();
                }
            }
        });

        tbl_allContent.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_contentId=tbl_allContent.getValueAt(tbl_allContent.getSelectedRow(),0).toString();
                    fld_contentId.setText(select_contentId);
                }catch (Exception exception){

                }
            }
        });

        mdl_quizList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] col_quizList = {"ID", "Name"};
        mdl_quizList.setColumnIdentifiers(col_quizList);
        row_quizList = new Object[col_quizList.length];

        loadQuizModel();

        tbl_allQuiz.setModel(mdl_quizList);
        tbl_allQuiz.getTableHeader().setReorderingAllowed(false);

        tbl_allQuiz.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int quiz_id = Integer.parseInt(tbl_allQuiz.getValueAt(tbl_allQuiz.getSelectedRow(),0).toString());
                    String quiz_name = tbl_allQuiz.getValueAt(tbl_allQuiz.getSelectedRow(),1).toString();


                    if(Quiz.updateName(quiz_id,quiz_name)){
                        Helper.showMessage("done");
                    }

                    loadContentModel();
                }
            }
        });

        tbl_allQuiz.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_quizId=tbl_allQuiz.getValueAt(tbl_allQuiz.getSelectedRow(),0).toString();
                    fld_quizId.setText(select_quizId);
                }catch (Exception exception){

                }
            }
        });


        btn_userAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_userName) || Helper.isFieldEmpty(fld_userUName) || Helper.isFieldEmpty(fld_userPass)) {
                    Helper.showMessage("fill");
                } else {
                    String name = fld_userName.getText();
                    String uname = fld_userUName.getText();
                    String pass = fld_userPass.getText();
                    String type = cmb_userType.getSelectedItem().toString();
                    if (User.add(name, uname, pass, type)) {
                        Helper.showMessage("done");
                        loadUserModel();
                        loadEducatorCombo();
                        fld_userName.setText(null);
                        fld_userUName.setText(null);
                        fld_userPass.setText(null);
                    }
                }
            }
        });
        btn_userDelete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_userId)) {
                Helper.showMessage("fill");
            } else {
                if(Helper.confirm("sure")){
                    int userId = Integer.parseInt(fld_userId.getText());
                    if (User.delete(userId)) {
                        Helper.showMessage("done");
                        loadUserModel();
                        loadEducatorCombo();
                        loadCourseModel();
                        fld_userId.setText(null);
                    } else {
                        Helper.showMessage("error");
                    }
                }
            }
        });
        btn_userSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fld_searchUserName.getText();
                String uName= fld_searchUserUName.getText();
                String type= cmb_searchUserType.getSelectedItem().toString();
                String query=User.searchQuery(name,uName,type);
                ArrayList<User> searchUser = User.searchUserList(query);
                loadUserModel(searchUser);
            }
        });
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI l = new LoginGUI();
            }
        });
        btn_pathAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_pathName)){
                    Helper.showMessage("fill");
                }else{
                    if(Path.add(fld_pathName.getText())){
                        Helper.showMessage("done");
                        loadPathModel();
                        loadPathCombo();
                        fld_pathName.setText(null);
                    }else{
                        Helper.showMessage("error");
                    }
                }
            }
        });
        btn_courseAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item pathItem= (Item)cmb_coursePath.getSelectedItem();
                Item userItem=(Item) cmb_courseEducator.getSelectedItem();
                if(Helper.isFieldEmpty(fld_courseName)||Helper.isFieldEmpty(fld_CourseLang)){
                    Helper.showMessage("fill");

                }else{
                    if(Course.add(userItem.getKey(),pathItem.getKey(),fld_courseName.getText(),fld_CourseLang.getText())){
                        Helper.showMessage("done");
                        loadCourseModel();
                        fld_CourseLang.setText(null);
                        fld_courseName.setText(null);
                    }else{
                        Helper.showMessage("error");
                    }
                }
            }
        });
        deleteButtonContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_contentId)) {
                    Helper.showMessage("Pick a content to delete");
                } else {
                    if(Helper.confirm("sure")){
                        int contentId = Integer.parseInt(fld_contentId.getText());
                        if (Content.delete(contentId)) {
                            Quiz.deleteQuizByContent(contentId);
                            Helper.showMessage("done");
                            loadContentModel();
                            loadQuizModel();
                            fld_contentId.setText(null);

                        } else {
                            Helper.showMessage("error");
                        }
                    }
                }
            }
        });
        deleteButtonQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_quizId)) {
                    Helper.showMessage("Pick a quiz to delete");
                } else {
                    if(Helper.confirm("sure")){
                        int quizId = Integer.parseInt(fld_quizId.getText());
                        if (Quiz.delete(quizId)) {
                            Helper.showMessage("done");
                            loadQuizModel();
                            fld_quizId.setText(null);

                        } else {
                            Helper.showMessage("error");
                        }
                    }
                }

            }
        });
        deleteButtonCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_hiddenCourseId)) {
                    Helper.showMessage("Pick a course to delete");
                } else {
                    if(Helper.confirm("sure")){
                        int courseId = Integer.parseInt(fld_hiddenCourseId.getText());
                        if (Course.delete(courseId)) {
                            Helper.showMessage("done");
                            loadCourseModel();
                            fld_hiddenCourseId.setText(null);

                        } else {
                            Helper.showMessage("error");
                        }
                    }
                }
            }
        });
    }


    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_courseList.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Course obj : Course.getList()){
            i=0;
            row_courseList[i++]=obj.getId();
            row_courseList[i++]=obj.getName();
            row_courseList[i++]=obj.getLang();
            row_courseList[i++]=obj.getPath().getName();
            row_courseList[i++]=obj.getEducator().getName();
            mdl_courseList.addRow(row_courseList);
        }
    }

    private void loadPathModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_pathList.getModel();
        clearModel.setRowCount(0);
        int i ;
        for(Path obj : Path.getList()){
            i=0;
            row_pathList[i++]=obj.getId();
            row_pathList[i++]=obj.getName();
            mdl_pathList.addRow(row_pathList);
        }
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        int i;
        for (User obj : User.getList()) {
            i=0;
            row_userList[i++] = obj.getId();
            row_userList[i++] = obj.getName();
            row_userList[i++] = obj.getuName();
            row_userList[i++] = obj.getPass();
            row_userList[i++] = obj.getType();
            mdl_userList.addRow(row_userList);
        }
    }
    public void loadUserModel(ArrayList<User> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        for (User obj : list) {
            int i = 0;
            row_userList[i++] = obj.getId();
            row_userList[i++] = obj.getName();
            row_userList[i++] = obj.getuName();
            row_userList[i++] = obj.getPass();
            row_userList[i++] = obj.getType();
            mdl_userList.addRow(row_userList);
        }
    }
    public void loadPathCombo(){
        cmb_coursePath.removeAllItems();
        for(Path obj : Path.getList()){
            cmb_coursePath.addItem(new Item(obj.getId(), obj.getName()));
        }
    }

    public void loadEducatorCombo(){
        cmb_courseEducator.removeAllItems();
        for(User obj : User.getList()){
            if(obj.getType().equals("educator")){
                cmb_courseEducator.addItem(new Item(obj.getId(),obj.getName()));
            }
        }
    }

    public static ArrayList<Quiz> getQuizList(){
        ArrayList<Quiz> quizList= new ArrayList<>();
        Quiz obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz");
            while(rs.next()){
                obj=new Quiz(rs.getInt("id"),rs.getInt("content_id"),rs.getString("quiz_name"),rs.getString("quiz_text"));
                quizList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }
    public void loadQuizModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_allQuiz.getModel();
        clearModel.setRowCount(0);
        for (Quiz obj : getQuizList()) {
            int i = 0;
            row_quizList[i++] = obj.getId();
            row_quizList[i++] = obj.getQuiz_name();

            mdl_quizList.addRow(row_quizList);
        }
    }
    public static ArrayList<Content> getContentList(){
        ArrayList<Content> contentList= new ArrayList<>();
        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content");
            while(rs.next()){
                obj=new Content(rs.getInt("id"),rs.getString("name"),rs.getInt("course_id"),rs.getString("description"),rs.getString("youtubeLink"));
                contentList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList;
    }
    public void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_allContent.getModel();
        clearModel.setRowCount(0);
        for (Content obj : getContentList()) {
            int i = 0;
            row_contentList[i++] = obj.getId();
            row_contentList[i++] = obj.getName();

            mdl_contentList.addRow(row_contentList);
        }
    }
}
