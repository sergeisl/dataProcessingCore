package ru.sfedu.core;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import ru.sfedu.core.dataProvide.DataProvide;
import ru.sfedu.core.model.Info;
import ru.sfedu.core.util.Strategy;

/**
 *
 * @author sergei
 */
public class Core {
    
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("Core.class");

    public void setExperiment(String PATH_INFO, String PATH_DATA, Strategy STRATEGY) {
        try {
            List<String> file = (List<String>) Files.lines(Paths.get(PATH_INFO), StandardCharsets.UTF_8)
                    .collect(Collectors.toList());
            DataInputStream input = new DataInputStream(
                    new FileInputStream(PATH_DATA));
            switch (STRATEGY) {
                case StrategyFirst:
                    new DataProvide().addStrategyFirst(file, input);
                case StrategySecond:
                    new DataProvide().addStrategySecond(file, input, PATH_DATA);
            }
        } catch (IOException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Info getExperiment(Long id, Strategy STRATEGY) {
        switch (STRATEGY) {
            case StrategyFirst:
                new DataProvide().getStrategyFirst(id);
                return null;
            case StrategySecond:
                return new DataProvide().getStrategySecond(id);
        }
        return null;       
    }
    public DataInputStream getData(Info info,int start, int end){
        try {
            DataInputStream input = new DataInputStream(
                new FileInputStream(info.getPathData()));
            
            
        } catch (IOException ex) {
            logger.info(ex);
        }
        return null;
    }
}
