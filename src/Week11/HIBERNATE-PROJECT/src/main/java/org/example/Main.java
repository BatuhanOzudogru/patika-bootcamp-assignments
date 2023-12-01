/*package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        try{
            Customer customer = new Customer();
            /*
            customer.setName("hibernate test");
            customer.setGender(Customer.GENDER.MALE);
            customer.setOnDate(LocalDate.now());
            customer.setMail("hibarnate@test.com");
            session.persist(customer);


            List<Customer> customers = session
                    .createSelectionQuery("FROM Customer", Customer.class)
                    .getResultList();


            Customer customer1= session
                    .createSelectionQuery("FROM Customer WHERE id = 2", Customer.class).getSingleResult();
            System.out.println(customer1.toString());

            customer=session.get(Customer.class,1);
            customer.setName("değişti");
            session.persist(customer);
            session.remove(customer);

            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }



    }
}
*/

