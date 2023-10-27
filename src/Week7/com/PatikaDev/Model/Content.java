package Week7.com.PatikaDev.Model;


import Week7.com.PatikaDev.Helper.DBConnector;
import Week7.com.PatikaDev.Helper.Helper;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private String name;
    private int courseId;
    private String description;
    private String youtubeLink;
    private static int quizId;
    private static Course course;



    public Content(int id, String name, int courseId, String description, String youtubeLink) {
        this.course=Course.getFetch(courseId);
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.description = description;
        this.youtubeLink = youtubeLink;

    }
    public Content(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static Content getFetch(int id) {
        Content obj = null;
        String query = "SELECT * FROM content WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
            }

            pr.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static ArrayList<Content> getListByCourse(int course_Id){
        ArrayList<Content> contentList = new ArrayList<>();

        Content obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content WHERE course_id = " + course_Id);
            while(rs.next()){
                int id = rs.getInt("id");
                String name= rs.getString("name");
                int courseId=rs.getInt("course_id");
                String description = rs.getString("description");
                String youtubeLink=rs.getString("youtubelink");
               // int quizId=rs.getInt("quiz_id");
                //(int id, String name, int courseId, String description, String youtubeLink, int quizId
                obj = new Content(id,name,courseId,description,youtubeLink);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList;

    }

    public static boolean add(String name) {
        String query = "INSERT INTO content (name , course_id, description, youtubelink, quiz_id) VALUES (?,?,?,?,?)";
        Content findUser = Content.getFetch(name);
        if (findUser != null) {
            Helper.showMessage("This content name has been added before. Please enter a different content name");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setInt(2, course.getId());
            pr.setString(3, "Add your description here");
            pr.setString(4, "Add Youtube link here");
            pr.setInt(5, quizId);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
    public static Content getFetch(String name) {
        Content obj = null;
        String query = "SELECT * FROM content WHERE name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setCourseId(rs.getInt("course_id"));
                obj.setDescription(rs.getString("description"));
                obj.setYoutubeLink(rs.getString("youtubelink"));
                obj.setId(Integer.parseInt(rs.getString("quiz_id")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static boolean delete(int id) {
        String query = "DELETE FROM content WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean update(int id, String name, String description, String youtubeLink,int courseId) {
        String query = "UPDATE content SET name=?,description=?,youtubelink=?,course_id=? WHERE id=?";
        Content findContent = getFetch(name);

        if (findContent != null && findContent.getId() != id && !(findContent.getDescription().equals(description))&&!(findContent.getYoutubeLink().equals(youtubeLink))) {
            Helper.showMessage("This content has been added before. Please enter a different content");
            return false;
        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, youtubeLink);

            ps.setInt(4, courseId);
            ps.setInt(5, id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
    public static boolean updateName(int id, String name) {
        String query = "UPDATE content SET name=? WHERE id=?";


        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
}
