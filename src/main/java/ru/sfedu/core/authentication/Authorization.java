package ru.sfedu.core.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.sfedu.core.model.Users;
import ru.sfedu.core.util.HibernateUtil;

/**
 *
 * @author sergei
 */
public class Authorization {

    private static final Logger logger = LogManager.getLogger("Authorization.class");

    /**
     *
     * @param login
     * @param password
     * @return
     */
    public Users login(String login, String password) {
        password = DigestUtils.md5Hex(password);
        Users user = null;
        if (!login.isEmpty() && !password.isEmpty() ) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Users where email = :paramEmail");
            query.setParameter("paramEmail", login);
            user = (Users)query.getResultList().get(0);
            transaction.commit();
            session.close();
        }
        
        if ((login == null
                ? user.getEmail() == null
                : login.equals(user.getEmail()))
                && (password == null
                        ? user.getPassword() == null
                        : password.equals(user.getPassword()))) {
            user.setPassword("");
            return user;
        } else {
            return null;
        }
    }
    
    public Users getUserById(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Users user = session.get(Users.class, id);
        transaction.commit();
        session.close();
        return user;
    }
}
