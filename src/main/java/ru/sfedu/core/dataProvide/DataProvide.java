package ru.sfedu.core.dataProvide;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.core.model.Channel_desc;
import ru.sfedu.core.model.Channel_val;
import ru.sfedu.core.model.Info;
import ru.sfedu.core.model.InfoKeyValue;
import ru.sfedu.core.util.HibernateUtil;
import ru.sfedu.core.util.ParsingData;


/**
 *
 * @author sergei
 */
public class DataProvide {
    
    private static final Logger logger = LogManager.getLogger("DataProvider.class");

    public String addStrategyFirst(List file, DataInputStream input) throws IOException {
       
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = null;
        transaction = session.beginTransaction();
        ParsingData parsingData = new ParsingData();
        
        int count_channel = parsingData.findByInfo(file, "[ChannelNames]").size();   
        List <InfoKeyValue> channelNames = parsingData.getList(parsingData.findByInfo(file, "[ChannelNames]"));
        
        Info info = new Info(count_channel);
        session.save(info);
        
        int size = input.available();
        
        int index = 0;
        while (input.available() > 0) {
            List<Channel_desc> listChannelDesc = new ArrayList<Channel_desc>();
            channelNames.forEach((InfoKeyValue action) -> {
                Channel_desc channel_desc = new Channel_desc(info.getId(),action.getIndex(),action.getKey());
                session.save(channel_desc);
                listChannelDesc.add(channel_desc);
            });
            listChannelDesc.forEach(action->{
                try {
                    session.save(new Channel_val(input.readShort(),action.getId()));
                } catch (IOException ex) {
                    logger.info(ex);
                }
            });
            index++;
            if (index % 1500 == 0) {
                session.flush();
                session.clear();
            }  
        }
        
        transaction.commit(); 
        session.close();
        HibernateUtil.shutdown();
        return null;
    }
    
    public String addStrategySecond(List file, DataInputStream input, String PATH_DATA) {
       
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = null;
        transaction = session.beginTransaction();
        ParsingData parsingData = new ParsingData();
        int count_channel = parsingData.findByInfo(file, "[ChannelNames]").size();   
        
        Info info = new Info(count_channel, PATH_DATA);
        session.save(info);
      
        transaction.commit(); 
        session.close();
        HibernateUtil.shutdown();
        return null;
    }
    
    public String getStrategyFirst(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        HibernateUtil.shutdown();
        return null;
    }
    public Info getStrategySecond(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Info info = (Info) session.get(Info.class, id);
        logger.info(info.toString());
        transaction.commit();
        session.close();
        HibernateUtil.shutdown();
        return info;
    }
}
