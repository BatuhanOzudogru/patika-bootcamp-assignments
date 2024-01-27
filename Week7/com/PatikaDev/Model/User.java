package Week7.com.PatikaDev.Model;

import Week7.com.PatikaDev.Helper.DBConnector;
import Week7.com.PatikaDev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String uName;
    private String pass;
    private String type;

    public User(int id, String name, String uName, String pass, String type) {
        this.id = id;
        this.name = name;
        this.uName = uName;
        this.pass = pass;
        this.type = type;
    }

    public User() {

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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setuName(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static boolean add(String name, String uname, String pass, String type) {
        String query = "INSERT INTO user(name,uname,pass,type) VALUES (?,?,?,?)";
        User findUser = User.getFetch(uname);
        if (findUser != null) {
            Helper.showMessage("This username has been added before. Please enter a different username");
            return false;
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            int response = pr.executeUpdate();
            if (response == -1) {
                Helper.showMessage("error");
            }
            return response != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static User getFetch(String uName) {
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uName);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setuName(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static User getFetch(String uName,String pass) {
        User obj = null;
        String query = "SELECT * FROM user WHERE uname = ? AND pass = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uName);
            pr.setString(2,pass);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                switch (rs.getString("type")){
                    case "operator":
                        obj=new Operator();
                        break;
                    default:
                        obj = new User();
                }

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setuName(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static User getFetch(int id) {
        User obj = null;
        String query = "SELECT * FROM user WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setuName(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM user WHERE id = ?";
        ArrayList<Course> courseList = Course.getListByUser(id);
        for(Course c : courseList){
            Course.delete(c.getId());
        }
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean update(int id, String name, String uname, String pass, String type) {
        String query = "UPDATE user SET name=?,uname=?,pass=?,type=? WHERE id=?";
        User findUser = User.getFetch(uname);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMessage("This username has been added before. Please enter a different username");
            return false;
        }
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, uname);
            ps.setString(3, pass);
            ps.setString(4, type);
            ps.setInt(5, id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public static ArrayList<User> searchUserList(String query) {
        ArrayList<User> userList = new ArrayList<>();

        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setuName(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static String searchQuery(String name, String uname, String type) {
        String query = "SELECT * FROM user WHERE uname LIKE '%{{uname}}%' AND name LIKE '%{{name}}%'";
        query = query.replace("{{uname}}", uname);
        query = query.replace("{{name}}", name);
        if (!type.isEmpty()) {
            query += " AND type='{{type}}'";
            query = query.replace("{{type}}", type);
        }

        return query;
    }
}

