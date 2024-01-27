package business.concretes;

import business.abstacts.ICustomerService;
import dal.abstacts.ICustomerDal;
import entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerService {
    private final ICustomerDal customerDal;

    //Dependency Injection
    public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDal.findByMail(customer.getMail());
        if (checkMailCustomer != null) {
            throw new RuntimeException(customer.getMail() + " bu e posta adresi daha önceden eklenmiş");
        }
        this.customerDal.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerDal.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkMailCustomer = this.customerDal.findByMail(customer.getMail());
        if (checkMailCustomer != null && checkMailCustomer.getId() != customer.getId()) {
            throw new RuntimeException(customer.getMail() + " bu e posta adresi daha önceden eklenmiş");
        }
        this.customerDal.update(customer);
    }

    @Override
    public void deleteById(int id) {
        // this.customerDal.delete(this.findById(id));
        Customer customer = this.customerDal.findById(id);
        this.customerDal.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDal.findAll();
    }
}
