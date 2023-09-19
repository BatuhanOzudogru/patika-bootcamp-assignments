public class Student {
    String name;
    int stuNo;
    String classes;
    Course fiz;
    Course mat;
    Course tur;
    double avarage;
    boolean isPass=false;

    Student(String name,int stuNo,String classes,Course fiz,Course mat,Course tur){
        this.name=name;
        this.stuNo=stuNo;
        this.classes=classes;
        this.fiz=fiz;
        this.mat=mat;
        this.tur=tur;
    }

    public void addBulkExamNote(double noteFiz,double quizFiz,double noteMat,double quizMat,double noteTur,double quizTur){
        if(noteFiz>=0 && noteFiz<=100){
            if(quizFiz>=0 && quizFiz<=100){
                this.fiz.note=(quizFiz*0.2)+(noteFiz*0.8);
                System.out.println("Fizik notu: "+fiz.note);

            }else{fiz.note=0;}
        }else {fiz.note=0;}
        if(noteMat>=0 && noteMat<=100){
            if(quizMat>=0 && quizMat<=100){
                this.mat.note=(quizMat*0.2)+(noteMat*0.8);
                System.out.println("Matematik notu: "+mat.note);
            }else {mat.note=0;}
        }else {mat.note=0;}
        if(noteTur>=0 && noteTur<=100){
            if(quizTur>=0 && quizTur<=100){
                this.tur.note=(quizTur*0.2)+(noteTur*0.8);
                System.out.println("Türkçe notu: "+tur.note);
            }else {tur.note=0;}
        }else {tur.note=0;}
        System.out.println("-------------------------------------------------------");

    }
    public void calcAvarage(){
        this.avarage=(this.fiz.note+this.mat.note+this.tur.note)/3.0;
        System.out.println(this.avarage);
    }
    public void isPass(){
        this.avarage=(this.fiz.note+this.mat.note+this.tur.note)/3.0;
        printNote();
        if(this.avarage>55){
            System.out.println("Sınıfı geçtiniz.");
            this.isPass=true;
        }else{
            System.out.println("Sınıfta kaldınız.");
            this.isPass=false;
        }

        System.out.println("-------------------------------------------------------");
    }

    public void printNote(){
        System.out.println("Öğrenci : "+this.name);
        System.out.println("Fizik notunuz: "+this.fiz.note);
        System.out.println("Matematik notunuz: "+this.mat.note);
        System.out.println("Türkçe notunuz: "+this.tur.note);
        System.out.println("Ortalamanız = "+this.avarage);



    }
}
