package com.navr.hibernatedemo;

import com.navr.hibernatedemo.entity.Employee;
import com.navr.hibernatedemo.entity.EmployeeAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        SessionFactory sf = null;
        Configuration cfg = new Configuration();
        try {
            sf = cfg.configure().buildSessionFactory();
        } catch (Exception exception) {
            System.err.println("buildSessionFactory: ex=" + exception.getMessage());
        }
        return sf;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * This method returns a session instance.
     *
     * <pre>
     *     Let’s explore the differences between openSession() and getCurrentSession() in Hibernate:
     *
     * openSession():
     *   * The openSession() method always opens a new session.
     *   * It creates a fresh session that you need to explicitly close once you’re done with your database operations.
     *   * Use openSession() when you want an independent session that is not bound to any specific context.
     *   * For example, if you need a different session (other than the one bound to the context) for specific purposes (e.g., Hibernate interceptors), you would use openSession().
     *
     * getCurrentSession():
     *   * The getCurrentSession() method retrieves the current session from the existing thread context.
     *   * It returns a session that is already associated with the current context (e.g., a web request or a transaction).
     *   * You don’t need to manually close this session; it’s managed by Hibernate.
     *   * To use getCurrentSession(), you must configure the hibernate.current_session_context_class property in your Hibernate configuration file.
     *   * If you’re using Spring or EJBs to manage transactions, they can automatically open and close sessions along with transactions.
     *
     * Choosing Between Them:
     *   * If your application runs in a single-threaded environment, consider using getCurrentSession() because it’s faster in performance. The session is reused within the same context.
     *   * If you’re using getCurrentSession(), ensure that you’ve set the appropriate context class (e.g., thread) in your Hibernate configuration.
     *   * Avoid using “one session per web app”—sessions are not thread-safe and cannot be shared across multiple threads.
     *   * Instead, follow the best practice of using “one session per request” or “one session per transaction”.
     *
     * </pre>
     *
     * @return session instance
     */
    public static Session getSession() {
//        return sessionFactory.openSession();
        return sessionFactory.getCurrentSession();
    }

    /**
     * <pre>
     * Let’s explore the differences between openSession() and getCurrentSession() in Hibernate:
     *
     * openSession():
     *   * The openSession() method always opens a new session.
     *   * It creates a fresh session that you need to explicitly close once you’re done with your database operations.
     *   * Use openSession() when you want an independent session that is not bound to any specific context.
     *   * For example, if you need a different session (other than the one bound to the context) for specific purposes (e.g., Hibernate interceptors), you would use openSession().
     *
     * getCurrentSession():
     *   * The getCurrentSession() method retrieves the current session from the existing thread context.
     *   * It returns a session that is already associated with the current context (e.g., a web request or a transaction).
     *   * You don’t need to manually close this session; it’s managed by Hibernate.
     *   * To use getCurrentSession(), you must configure the hibernate.current_session_context_class property in your Hibernate configuration file.
     *   * If you’re using Spring or EJBs to manage transactions, they can automatically open and close sessions along with transactions.
     *
     * Choosing Between Them:
     *   * If your application runs in a single-threaded environment, consider using getCurrentSession() because it’s faster in performance. The session is reused within the same context.
     *   * If you’re using getCurrentSession(), ensure that you’ve set the appropriate context class (e.g., thread) in your Hibernate configuration.
     *   * Avoid using “one session per web app”—sessions are not thread-safe and cannot be shared across multiple threads.
     *   * Instead, follow the best practice of using “one session per request” or “one session per transaction”.
     *
     *  </pre>
     * <p>
     * NOTE: The save() method in Hibernate has been deprecated since Hibernate 6.0.
     * Instead, you should use the persist() method.
     */
    public static void persist(List<Employee> empList, List<EmployeeAddress> employeeAddressList) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();

        Transaction t = session.beginTransaction();

        int i = 0;
        for (Employee emp : empList) {
            session.persist(emp); // session.save(emp) method call is deprecated. Use persist() method instead.
            System.out.println("New employee record added. id=" + emp.getEmpId());

            // Insert Employee address for each Employee record
            EmployeeAddress empAddr = employeeAddressList.get(i++);
            empAddr.setEmpId(emp.getEmpId());
            session.persist(empAddr);
            System.out.println("New employee_address record added. id=" + empAddr.getEmpAddrId());
        }

        t.commit();

        System.out.println("Employee record(s) successfully saved. Count= " + i + " records.");
        factory.close();
        session.close();
    }
}
