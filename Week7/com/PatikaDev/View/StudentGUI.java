package Week7.com.PatikaDev.View;

import Week7.com.PatikaDev.Helper.Config;
import Week7.com.PatikaDev.Helper.DBConnector;
import Week7.com.PatikaDev.Helper.Helper;
import Week7.com.PatikaDev.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_studentWelcome;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextField fld_hiddenContentId;
    private JTextField fld_hiddenCourseId;
    private JTextField fld_hiddenPathId;
    private JButton selectButtonPath;
    private JTable tbl_pathList;
    private JButton enrollButtonCourse;
    private JTable tbl_courseList;
    private JPanel pnl_pathList;
    private JPanel pnl_courseList;
    private JButton selectButtonCourse;
    private JTable tbl_myCourseList;
    private JTable tbl_myContents;
    private JTextField fld_myContentName;
    private JTextField fld_myContentDescription;
    private JTextField fld_myContentLink;
    private JTextField fld_myComment;
    private JTextArea txt_myQuiz;
    private JTextArea txt_myAnswer;
    private JRadioButton a1RadioButton;
    private JRadioButton a5RadioButton;
    private JRadioButton a2RadioButton1;
    private JRadioButton a4RadioButton;
    private JRadioButton a3RadioButton1;
    private JButton selectButtonContent;
    private JTextField fld_hiddenMyCourseId;
    private JButton submitButton;
    private User user;
    private Object[] row_pathList;
    private DefaultTableModel mdl_pathList;
    private Object[] row_courseList;
    private DefaultTableModel mdl_courseList;
    private Object[] row_myCourseList;
    private DefaultTableModel mdl_myCourseList;
    private Object[] row_myContentList;
    private DefaultTableModel mdl_myContentList;

    public StudentGUI(User user) {
        this.user = user;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterLocation("x", getSize());
        int y = Helper.screenCenterLocation("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_studentWelcome.setText("Welcome " + user.getName());
        fld_hiddenContentId.setVisible(false);
        fld_hiddenPathId.setVisible(false);
        fld_hiddenMyCourseId.setVisible(false);
        fld_hiddenCourseId.setVisible(false);


        mdl_pathList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_pathList = {"Id", "Path Name"};
        mdl_pathList.setColumnIdentifiers(col_pathList);
        row_pathList = new Object[col_pathList.length];
        loadPathModel();
        tbl_pathList.setModel(mdl_pathList);
        tbl_pathList.getTableHeader().setReorderingAllowed(false);
        tbl_pathList.getColumnModel().getColumn(0).setMaxWidth(30);


        tbl_pathList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String select_pathId = tbl_pathList.getValueAt(tbl_pathList.getSelectedRow(), 0).toString();
                    fld_hiddenPathId.setText(select_pathId);

                } catch (Exception exception) {

                }
            }
        });
        tbl_courseList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {

                    String select_courseId = tbl_courseList.getValueAt(tbl_courseList.getSelectedRow(), 0).toString();
                    fld_hiddenCourseId.setText(select_courseId);
                } catch (Exception exception) {

                }
            }
        });
        tbl_myContents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {

                    String select_contentId = tbl_myContents.getValueAt(tbl_myContents.getSelectedRow(), 0).toString();
                    fld_hiddenContentId.setText(select_contentId);
                } catch (Exception exception) {

                }
            }
        });
        tbl_myCourseList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {

                    String select_courseId = tbl_myCourseList.getValueAt(tbl_myCourseList.getSelectedRow(), 0).toString();
                    fld_hiddenMyCourseId.setText(select_courseId);
                } catch (Exception exception) {

                }
            }
        });



        mdl_courseList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_courseList = {"Id", "Course Name", "Course Language"};
        mdl_courseList.setColumnIdentifiers(col_courseList);
        row_courseList = new Object[col_courseList.length];
        tbl_courseList.setModel(mdl_courseList);
        tbl_courseList.getTableHeader().setReorderingAllowed(false);
        tbl_courseList.getColumnModel().getColumn(0).setMaxWidth(30);


        mdl_myCourseList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_myCourseList = {"Id", "Course Name", "Course Language", "Course Path"};
        mdl_myCourseList.setColumnIdentifiers(col_myCourseList);
        row_myCourseList = new Object[col_myCourseList.length];
        loadMyCourseModel();
        tbl_myCourseList.setModel(mdl_myCourseList);
        tbl_myCourseList.getTableHeader().setReorderingAllowed(false);
        tbl_myCourseList.getColumnModel().getColumn(0).setMaxWidth(30);


        mdl_myContentList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_myContentList = {"Id", "Content Name"};
        mdl_myContentList.setColumnIdentifiers(col_myContentList);
        row_myContentList = new Object[col_myContentList.length];
        tbl_myContents.setModel(mdl_myContentList);
        tbl_myContents.getTableHeader().setReorderingAllowed(false);
        tbl_myContents.getColumnModel().getColumn(0).setMaxWidth(30);

        selectButtonPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadCourseModel();
            }
        });
        enrollButtonCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fld_hiddenCourseId.getText().isEmpty()){
                    Helper.showMessage("error");
                } else if (1==2) {
                    Helper.showMessage("You already enrolled this course !");
                }else {
                    addSelectedCourses();
                    Helper.showMessage("done");
                    loadMyCourseModel();
                }

            }
        });
        selectButtonCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMyContentModel();
            }
        });


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_myAnswer.getText().isEmpty() || fld_myComment.getText().isEmpty()){
                    Helper.showMessage("fill");
                }else{
                    Helper.showMessage("Well done");
                }
            }
        });
        selectButtonContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadContentDetailsModel();
            }
        });
    }

    public static ArrayList<Path> getPaths() {
        ArrayList<Path> pathList = new ArrayList<>();

        Path obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM path");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                obj = new Path(id, name);
                pathList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pathList;
    }

    private void loadPathModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_pathList.getModel();
        clearModel.setRowCount(0);
        for (Path obj : getPaths()) {
            row_pathList[0] = obj.getId();
            row_pathList[1] = obj.getName();
            mdl_pathList.addRow(row_pathList);
        }
    }

    public static ArrayList<Course> getCourseByPath(int path_id) {
        ArrayList<Course> courseList = new ArrayList<>();

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course WHERE path_id = " + path_id);
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int pathId = rs.getInt("path_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Course(id, userId, pathId, name, lang);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_courseList.getModel();
        clearModel.setRowCount(0);
        int pathId = Integer.parseInt(fld_hiddenPathId.getText());
        for (Course obj : getCourseByPath(pathId)) {
            row_courseList[0] = obj.getId();
            row_courseList[1] = obj.getName();
            row_courseList[2] = obj.getLang();
            mdl_courseList.addRow(row_courseList);
        }
    }

    public static ArrayList<Course> getCourseById(int courseId) {
        ArrayList<Course> courseList = new ArrayList<>();

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course WHERE id = " + courseId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int pathId = rs.getInt("path_id");
                String name = rs.getString("name");
                String lang = rs.getString("lang");
                obj = new Course(id, userId, pathId, name, lang);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    private void loadMyCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_myCourseList.getModel();
        clearModel.setRowCount(0);

        for (Course obj : getMyCourseList(getSelectedCourseId())) {
            row_myCourseList[0] = obj.getId();
            row_myCourseList[1] = obj.getName();
            row_myCourseList[2] = obj.getLang();
            row_myCourseList[3] = obj.getPath().getName().toString();
            mdl_myCourseList.addRow(row_myCourseList);
        }
    }

    public static ArrayList<Content> getContentByCourseId(int courseId) {
        ArrayList<Content> getContentByCourseId = new ArrayList<>();

        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content WHERE course_id = " + courseId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int courseID = rs.getInt("course_id");
                String contentName = rs.getString("name");
                String description = rs.getString("description");
                String youtubeLink = rs.getString("youtubeLink");
                obj = new Content(id,contentName,courseID,description,youtubeLink);
                getContentByCourseId.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getContentByCourseId;
    }
    private void loadMyContentModel() {
        int courseId = Integer.parseInt(fld_hiddenMyCourseId.getText());
        DefaultTableModel clearModel = (DefaultTableModel) tbl_myContents.getModel();
        clearModel.setRowCount(0);
        for (Content obj : getContentByCourseId(courseId)) {
            row_myCourseList[0] = obj.getId();
            row_myCourseList[1] = obj.getName();
//            row_myCourseList[2] = obj.getCourseId();
//            row_myCourseList[3] = obj.getDescription();
//            row_myCourseList[4] = obj.getYoutubeLink();
            mdl_myContentList.addRow(row_myCourseList);
        }
    }
    public static ArrayList<Content> getDetailsByContentId(int contentId) {
        ArrayList<Content> contentDetailsList = new ArrayList<>();

        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content WHERE id = " + contentId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int courseID = rs.getInt("course_id");
                String contentName = rs.getString("name");
                String description = rs.getString("description");
                String youtubeLink = rs.getString("youtubeLink");
                obj = new Content(id,contentName,courseID,description,youtubeLink);
                contentDetailsList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentDetailsList;
    }

    public static ArrayList<Quiz> getQuizByContentId(int contentId) {
        ArrayList<Quiz> quizList = new ArrayList<>();

        Quiz obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz WHERE content_id = " + contentId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int content_id = rs.getInt("content_id");
                String quizName = rs.getString("quiz_name");
                String quizText = rs.getString("quiz_text");

                obj = new Quiz(id,content_id,quizName,quizText);
                quizList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }

    private void loadContentDetailsModel() {
        int contentId = Integer.parseInt(fld_hiddenContentId.getText());


        for (Content obj : getDetailsByContentId(contentId)) {
            fld_myContentName.setText(obj.getName());
            fld_myContentDescription.setText(obj.getDescription());
            fld_myContentLink.setText(obj.getYoutubeLink());
        }

        String quizName;
        String quizText;
        String myQuiz = "";
        for (Quiz obj : getQuizByContentId(contentId)) {
            quizName = obj.getQuiz_name() + "\n";
            quizText = obj.getQuiz_text() + "\n";
            myQuiz += quizName + quizText + "\n";
            txt_myQuiz.setText(myQuiz);
        }

    }
    private boolean addSelectedCourses() {
        String query = "INSERT INTO selected_courses (course_id, user_id) VALUES (?,?)";


        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, Integer.parseInt(fld_hiddenCourseId.getText()));
            pr.setInt(2, user.getId());


            int response = pr.executeUpdate();

            if (response == -1) {
                Helper.showMessage("error");
            }

            return response != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    private ArrayList<Integer> getSelectedCourseId() {
        ArrayList<Integer> courseIdList = new ArrayList<>();

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM selected_courses WHERE user_id = " + user.getId());
            while (rs.next()) {
                int course_id = rs.getInt("course_id");

                courseIdList.add(course_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseIdList;
    }


    private ArrayList<Course> getMyCourseList(ArrayList<Integer> xList) {
        ArrayList<Course> myCourseList = new ArrayList<>();

        Course obj;

        for (Integer ID : xList) {

            try {
                Statement st = DBConnector.getInstance().createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM course WHERE id = " + ID);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int path_id = rs.getInt("path_id");
                    String name = rs.getString("name");
                    String lang = rs.getString("lang");

                    obj = new Course(id, user.getId(), path_id, name, lang);
                    myCourseList.add(obj);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return myCourseList;
    }
}
