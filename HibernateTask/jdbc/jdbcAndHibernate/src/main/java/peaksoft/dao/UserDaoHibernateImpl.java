package peaksoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.sessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("saving user");
    }

    @Override
    public void removeUserById(long id) {
        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.delete(getUserByID(id));
        session.getTransaction().commit();
        session.close();
        System.out.println("deleted user");
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        users = query.list();
        session.getTransaction().commit();
        session.close();
        return users;
    }



    @Override
    public void cleanUsersTable() {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        System.out.println("clean from User table ");
    }
    public User getUserByID(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

}
