package Week2.SalaryCalculator.src;
public class Employee {
    String name;         //variables
    double salary;
    int workHours;
    int hireYear;

    Employee(String name,double salary,int workHours,int hireYear){      //constructor method
        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;
    }

    double tax(){                 // x employee's salary<1000 we do not impose any taxes, but if salary<1000 we impose %3 tax.
        double tax;
        if(this.salary<1000) {
            tax=0;

        }
        else {
            tax = this.salary * 0.03;

        }
        return tax;
    }
    double bonus(){    // x employee's work hour>40 we pay 30 $ per extra hour
        int extraHours;
        int bonusSalary=0;
        if(this.workHours>40){
           extraHours= this.workHours-40;
           bonusSalary=extraHours*30;
        }
        return bonusSalary;

    }
    public double raiseSalary(){               // if x employee has been working for less than 10 years we increase x's salary by 5 percent
        int thisYear=2021;                     //                           more than 9 years and less than 20 years we increase x's salary by 10 percent
        int workYear=thisYear-this.hireYear;   //                           more than 20 years we increase x's salary by 15 percent.
        double salaryIncrease;
        if(workYear<10){
            salaryIncrease=(this.salary*0.05);


        } else if (workYear>9&&workYear<20) {
            salaryIncrease=(this.salary*0.1);

        }else{
            salaryIncrease=(this.salary*0.15);

        }

        return salaryIncrease;
    }

    public void info(){
        System.out.println("Name : "+this.name);
        System.out.println("Salary : "+this.salary);
        System.out.println("Work Hours : "+this.workHours);
        System.out.println("Hire Year : "+this.hireYear);
        System.out.println("Tax : "+this.tax());
        System.out.println("Bonus : "+this.bonus());
        System.out.println("Salary with taxes and bonuses: "+(this.salary+bonus()-tax()));
        System.out.println("Total Salary : "+ raiseSalary());

    }
    public String toString(){
        return "Name : "+this.name+"\n"+"Salary : "+this.salary+"\n"+
                "Work Hours : "+this.workHours+"\n"+"Hire Year : "+this.hireYear+"\n"+
                "Tax : "+this.tax()+"\n"+"Bonus : "+this.bonus()+"\n"+"Salary Increase : "+raiseSalary()+
                "\n"+"Salary with taxes and bonuses: "+(this.salary+bonus()-tax())+"\n"+"Total Salary : "+ (this.salary+raiseSalary());
    }
}
