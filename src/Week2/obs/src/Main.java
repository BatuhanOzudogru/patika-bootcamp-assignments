package Week2.obs.src;
public class Main {
    public static void main(String[] args) {
        Course fiz=new Course("Fizik","111","FZK");
        Course mat=new Course("Matematik","112","MAT");
        Course tur=new Course("Türkçe","113","TUR");
        Student s1=new Student("a öğrencisi",1,"4",fiz,mat,tur);
        Student s2=new Student("b öğrencisi",2,"3",fiz,mat,tur);
        Student s3=new Student("c öğrencisi",3,"2",fiz,mat,tur);
        Teacher t1=new Teacher("a öğretmeni","001","FZK");
        Teacher t2=new Teacher("b öğretmeni","002","MAT");
        Teacher t3=new Teacher("c öğretmeni","003","TUR");

        fiz.addTeacher(t2);
        System.out.println("-------------------------------------");
        fiz.addTeacher(t1);
        System.out.println("-------------------------------------");

        s1.addBulkExamNote(100,50,80,50,80,100);
        s1.isPass();

        s2.addBulkExamNote(1000,200,3000,400,50,60);
        s2.isPass();
        s3.addBulkExamNote(65,60,32,65,46,12);
        s3.isPass();








    }
}