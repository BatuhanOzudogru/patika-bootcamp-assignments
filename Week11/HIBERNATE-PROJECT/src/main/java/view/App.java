package view;

import business.concretes.CustomerManager;
import dal.concretes.CustomerDao;
import entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new CustomerDao());
        /*
        Customer customer = new Customer();
        customer.setMail("TEST@mail.com");
        customer.setName("test dersleri");
        customer.setGender(Customer.GENDER.FEMALE);
        customer.setOnDate(LocalDate.now());

        customerManager.save(customer);
        */
   /* Customer firstCustomer = customerManager.findById(1);
        System.out.println(firstCustomer.toString());


        customerManager.deleteById(2);


        Customer customer = customerManager.findById(1);
        customer.setMail("TEST@mail.com");
        customerManager.update(customer);

    */
        List<Customer> customerList = customerManager.findAll();
        System.out.println(customerList.toString());

    }
}




