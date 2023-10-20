package Week7.com.PatikaDev.Model;

import Week7.com.PatikaDev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int path_id;
    private String name;
    private String lang;
    private Path path;
    private User educator;

    public Course(int id, int user_id, int path_id, String name, String lang) {
        this.id = id;
        this.user_id = user_id;
        this.path_id = path_id;
        this.name = name;
        this.lang = lang;
        this.path=Path.getFetch(path_id);
        this.educator=User.getFetch(user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPath_id() {
        return path_id;
    }

    public void setPath_id(int path_id) {
        this.path_id = path_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }

    public static ArrayList<Course> getList(){
        ArrayList<Course> courseList = new ArrayList<>();

        Course obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM course");
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
    public static boolean add(int user_id,int path_id,String name,String lang){
        String query = "INSERT INTO course (user_id,path_id, name,lang) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1,user_id);
            ps.setInt(2,path_id);
            ps.setString(3,name);
            ps.setString(4,lang);
            return  ps.executeUpdate() !=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
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
    public static boolean delete(int id) {
        String query = "DELETE FROM course WHERE id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
