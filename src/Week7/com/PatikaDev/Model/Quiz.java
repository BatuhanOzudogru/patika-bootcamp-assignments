package Week7.com.PatikaDev.Model;

public class Quiz {
    private int id;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private int content_id;
    private Content content;

    public Quiz(int id, String q1, String q2, String q3, String q4, String q5,int content_id) {
        this.id = id;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.content=Content.getFetch(content_id);
        this.content_id=content_id;
    }
}
