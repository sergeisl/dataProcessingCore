package ru.sfedu.core.dataProvide;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.sfedu.core.model.Channel_desc;
import ru.sfedu.core.model.Channel_val;
import ru.sfedu.core.model.Experiment;
import ru.sfedu.core.model.ExampleExperiment;
import ru.sfedu.core.model.Info;
import ru.sfedu.core.model.InfoKeyValue;
import ru.sfedu.core.model.Users;
import ru.sfedu.core.util.Constans;
import ru.sfedu.core.util.HibernateUtil;
import ru.sfedu.core.util.ParsingData;


/**
 *
 * @author sergei
 */
public class DataProvider {
    
    private static final Logger logger = LogManager.getLogger("DataProvider.class");

//
//    public String addStrategyFirst(List file, DataInputStream input) throws IOException {
//       
//        Session session = HibernateUtil.getSessionFactory().openSession(); 
//        Transaction transaction = null;
//        transaction = session.beginTransaction();
//        ParsingData parsingData = new ParsingData();
//        
//        int count_channel = parsingData.findByInfo(file, "[ChannelNames]").size();   
//        List <InfoKeyValue> channelNames = parsingData.getList(parsingData.findByInfo(file, "[ChannelNames]"));
//        
//        Info info = new Info(count_channel);
//        session.save(info);
//        
//        int size = input.available();
//        
//        int index = 0;
//        while (input.available() > 0) {
//            List<Channel_desc> listChannelDesc = new ArrayList<Channel_desc>();
//            channelNames.forEach((InfoKeyValue action) -> {
//                Channel_desc channel_desc = new Channel_desc(info.getId(),action.getIndex(),action.getKey());
//                session.save(channel_desc);
//                listChannelDesc.add(channel_desc);
//            });
//            listChannelDesc.forEach(action->{
//                try {
//                    session.save(new Channel_val(input.readShort(),action.getId()));
//                } catch (IOException ex) {
//                    logger.info(ex);
//                }
//            });
//            index++;
//            if (index % 1500 == 0) {
//                session.flush();
//                session.clear();
//            }  
//        }
//        
//        transaction.commit(); 
//        session.close();
//        return null;
//    }
//    
//    public String addStrategySecond(List file, DataInputStream input, String PATH_DATA) {
//       
//        Session session = HibernateUtil.getSessionFactory().openSession(); 
//        Transaction transaction = null;
//        transaction = session.beginTransaction();
//        ParsingData parsingData = new ParsingData();
//        int count_channel = parsingData.findByInfo(file, "[ChannelNames]").size();
//        Info info = new Info(count_channel, PATH_DATA);
//        session.save(info);
//        transaction.commit(); 
//        session.close();
//        return null;
//    }
    
    public String addExperiment(Experiment experiment) {
        experiment.setDate(new Date().getTime());
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(experiment);
        experiment.getData().forEach(data ->session.save(data));
        transaction.commit(); 
        session.close();
        return null;
    }
    
    public Experiment getExperimentById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Experiment experiment = (Experiment) session.get(Experiment.class, id);
        Hibernate.initialize(experiment.getData());
        transaction.commit();
        session.close();
        return experiment;
    }
    
    public List<ExampleExperiment> getExperimentAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query query = session.createQuery(Constans.EXPERIMENT);
        List<ExampleExperiment> experiments = (List<ExampleExperiment>) query.list();
        transaction.commit();
        experiments.forEach(action->{
            action.setData(null);
            action.getUser().setPassword("");
        });
        session.close();
        return experiments;
    }
    
    public Info getStrategySecond(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Info info = (Info) session.get(Info.class, id);
        transaction.commit();
        session.close();
        return info;
    }
    
    public Users getUserById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Users user = session.get(Users.class, id);
        transaction.commit();
        session.close();
        return user;
    }
    
    public List<Users> getUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query query = session.createQuery(Constans.USERS);
        List<Users> users = query.list();
        transaction.commit();
        session.close();
        users.forEach(action -> {
            action.setPassword("(-_-)");
        });
        return users;
    }
    
    public Users updateUser(Users user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        user.setPassword(getUserById(user.getId()).getPassword());
        session.update(user);
        transaction.commit();
        session.close();
        return user;
    }
    
    public List<Users> deleteUser(Users user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
        return getUsers();
    }
    
    public List<ExampleExperiment> deleteExperiment(ExampleExperiment experiment){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.delete(experiment);
        transaction.commit();
        session.close();
        return getExperimentAll();
    }
    
    public List<Users> createUser(Users user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        session.save(user);
        transaction.commit();
        session.close();
        return getUsers();
    }
    
}
