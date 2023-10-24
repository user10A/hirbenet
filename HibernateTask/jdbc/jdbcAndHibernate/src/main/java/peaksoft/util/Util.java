package peaksoft.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

public class Util {
    public static SessionFactory sessionFactory(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres1.5");
        properties.put(Environment.USER,"postgres");
        properties.put(Environment.PASS,"erkin");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");
        properties.put(Environment.HBM2DDL_AUTO,"update");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
        return  configuration.buildSessionFactory();
    }
}
