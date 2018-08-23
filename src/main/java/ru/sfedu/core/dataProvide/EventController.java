package ru.sfedu.core.dataProvide;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.sfedu.core.model.LogEvents;
import ru.sfedu.core.util.Constans;
import ru.sfedu.core.util.HibernateUtil;

/**
 *
 * @author sergei
 */
public class EventController {
    
    private static final Logger logger = LogManager.getLogger("EventController.class");
    
    public String addEvent(LogEvents logEvent) {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(logEvent);
        transaction.commit(); 
        session.close();
        return null;
    }
    
    public LogEvents getEventById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        LogEvents logEvent = (LogEvents) session.get(LogEvents.class, id);
        transaction.commit();
        session.close();
        return logEvent;
    }
    
    public List<LogEvents> getLogEvents(int pageNumber, int pageSize){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query query = session.createQuery(Constans.LOGEVENT);
        query = query.setFirstResult(pageSize * (pageNumber - 1));
        query.setMaxResults(100);
        List<LogEvents> logEvent = (List<LogEvents>) query.list();
        transaction.commit();
        session.close();
        logEvent.forEach(action -> {
            action.getExperiment().setData(null);
            action.getUser().setPassword("");
        });
        return logEvent;
    }
   
}
