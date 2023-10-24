package Week7.com.PatikaDev.Model;


import Week7.com.PatikaDev.Helper.DBConnector;

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
    private int quizId;
    private Course course;


    public Content(int id, String name, int courseId, String description, String youtubeLink, int quizId) {
        this.course=Course.getFetch(courseId);
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.description = description;
        this.youtubeLink = youtubeLink;
        this.quizId = quizId;
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
                int quizId=rs.getInt("quiz_id");
                //(int id, String name, int courseId, String description, String youtubeLink, int quizId
                obj = new Content(id,name,courseId,description,youtubeLink,quizId);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList;

    }
}
