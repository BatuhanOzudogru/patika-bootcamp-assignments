package Week2.obs.src;
public class Course {
    Teacher teacher;
    String name;
    String code;
    String prefix;
    double note;



    Course(String name,String code,String prefix){
        this.name=name;
        this.code=code;
        this.prefix=prefix;
        this.note=0;
    }

    public void addTeacher(Teacher teacher){
        if(this.prefix.equals(teacher.branch)){
            this.teacher=teacher;
            System.out.println("Öğretmen ataması başarılı !");
        }else{
            System.out.println("Öğretmen branşı ile ders uyuşmuyor !!");
        }
    }

    public void printTeacher (Teacher teacher){
        System.out.println("Öğretmen Adı= "+this.teacher.name);
        System.out.println("Öğretmenin Telefon Numarası= "+this.teacher.mpno);
        System.out.println("Öğretmenin Branşı = "+this.teacher.branch);
    }

}
