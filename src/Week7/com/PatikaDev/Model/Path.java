package Week7.com.PatikaDev.Model;

import Week7.com.PatikaDev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Path {
    private int id;
    private String name;

    public Path(int id, String name) {
        this.id = id;
        this.name = name;
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

    public static ArrayList<Path> getList(){
        ArrayList<Path> pathList= new ArrayList<>();
        Path obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM path");
            while(rs.next()){
                obj=new Path(rs.getInt("id"),rs.getString("name"));
                pathList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pathList;
    }
    public static boolean add(String name){
        String query = "INSERT INTO path (name) VALUES (?)";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1,name);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean update(int id,String name){
        String query= "UPDATE path SET name = ? WHERE id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1,name);
            ps.setInt(2,id);
            return ps.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
    public static Path getFetch(int id) {
        Path obj = null;
        String query = "SELECT * FROM path WHERE id = ? ";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Path(rs.getInt("id"), rs.getString("name") );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static boolean delete (int id ){
        String query = "DELETE FROM path WHERE id = ?";
        ArrayList<Course> courseList = Course.getList();
        for(Course obj : courseList){
            if(obj.getPath().getId()==id){
                Course.delete(obj.getId());
            }
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return true;
    }

}
