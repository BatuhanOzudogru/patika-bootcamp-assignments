package Week7.com.PatikaDev.Model;

import Week7.com.PatikaDev.Helper.DBConnector;
import Week7.com.PatikaDev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private int content_id;
    private String quiz_name;

    private String quiz_text;
    private static Content content;

    public Quiz(int id, int content_id, String quiz_name, String quiz_text) {
        this.content=Content.getFetch(content_id);
        this.id = id;
        this.content_id = content_id;
        this.quiz_name = quiz_name;
        this.quiz_text = quiz_text;
    }
    public Quiz(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public String getQuiz_text() {
        return quiz_text;
    }

    public void setQuiz_text(String quiz_text) {
        this.quiz_text = quiz_text;
    }

    public static Content getContent() {
        return content;
    }

    public static void setContent(Content content) {
        Quiz.content = content;
    }
    //                          (String quiz_name,String quiz_text) method id almıyordu
    public static boolean add(String quiz_name,String quiz_text,int id) {
        String query = "INSERT INTO quiz (content_id , quiz_name, quiz_text) VALUES (?,?,?)";
//        Content findUser = Content.getFetch(name);
//        if (findUser != null) {
//            Helper.showMessage("This content name has been added before. Please enter a different content name");
//            return false;
//        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);//content.getId() alıyordu
            pr.setString(2, quiz_name);
            pr.setString(3, quiz_text);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }


    public static ArrayList<Quiz> getListByContent(int content_id){
        ArrayList<Quiz> quizList = new ArrayList<>();

        Quiz obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz WHERE content_id = " + content_id);
            while(rs.next()){
                int id = rs.getInt("id");
                int contentId=rs.getInt("content_id");
                String quizName= rs.getString("quiz_name");
                String quizText = rs.getString("quiz_text");
                obj = new Quiz(id,contentId,quizName,quizText);
                quizList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }
    public static boolean delete(int id) {
        String query = "DELETE FROM quiz WHERE id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean deleteQuizByContent(int content_id) {
        String query = "DELETE FROM quiz WHERE content_id = ?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, content_id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static Quiz getFetchName(int id) {
        Quiz obj = null;
        String query = "SELECT * FROM quiz WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setQuiz_name(rs.getString("quiz_name"));
            }

            pr.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static Quiz getFetchText(int id) {
        Quiz obj = null;
        String query = "SELECT * FROM quiz WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setQuiz_text(rs.getString("quiz_text"));
            }

            pr.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static boolean update(int id, String quizName, String quizText) {
        String query = "UPDATE quiz SET quiz_name=?,quiz_text=? WHERE id=?";
//        //Content findContent = getFetch(name);
//
//        if (findContent != null && findContent.getId() != id && !(findContent.getDescription().equals(description))&&!(findContent.getYoutubeLink().equals(youtubeLink))) {
//            Helper.showMessage("This content has been added before. Please enter a different content");
//            return false;
//        }

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, quizName);
            ps.setString(2, quizText);
            ps.setInt(3, id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
    public static boolean updateName(int id, String quizName) {
        String query = "UPDATE quiz SET quiz_name=? WHERE id=?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, quizName);
            ps.setInt(2, id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

}
