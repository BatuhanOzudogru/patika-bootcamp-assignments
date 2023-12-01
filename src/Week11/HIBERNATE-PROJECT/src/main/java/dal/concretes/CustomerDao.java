package dal.concretes;

import core.HibernateSession;
import dal.abstacts.ICustomerDal;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CustomerDao implements ICustomerDal {

    private final Session session;

    public CustomerDao() {
        this.session = HibernateSession.getSession();
    }

    @Override
    public void save(Customer customer) {
    this.session.beginTransaction();
    this.session.persist(customer);
    this.session.getTransaction().commit();
    }

    @Override
    public Customer findById(int id) {

        return this.session.get(Customer.class,id);
    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        this.session.beginTransaction();
        this.session.remove(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public List<Customer> findAll() {
        //List<Customer> customers = this.session.createSelectionQuery("FROM Customer", Customer.class).getResultList();
        return  this.session.createSelectionQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findByMail(String mail) {
        SelectionQuery<Customer> query = this.session.createSelectionQuery("FROM Customer Where mail = :mail", Customer.class);
        query.setParameter("mail",mail);
        return query.getSingleResultOrNull();
    }
}
