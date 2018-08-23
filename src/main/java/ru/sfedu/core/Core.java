package ru.sfedu.core;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import ru.sfedu.core.dataProvide.DataProvider;
import ru.sfedu.core.model.TypeDataExperiment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
//import org.apache.poi.xwpf.converter.core.FileImageExtractor;
//import org.apache.poi.xwpf.converter.core.FileURIResolver;
//
//import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
import ru.sfedu.core.authentication.Authorization;
import ru.sfedu.core.model.ExampleExperiment;
import ru.sfedu.core.model.Experiment;
import ru.sfedu.core.model.ExperimentData;
import ru.sfedu.core.model.Users;
import ru.sfedu.core.util.ParsingData;

/**
 *
 * @author sergei
 */
public class Core {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("Core.class");

//    public void setExperiment(String PATH_INFO, String PATH_DATA, Strategy STRATEGY) {
//        try {
//            List<String> file = (List<String>) Files.lines(Paths.get(PATH_INFO), StandardCharsets.UTF_8)
//                    .collect(Collectors.toList());
//            DataInputStream input = new DataInputStream(
//                    new FileInputStream(PATH_DATA));
//            switch (STRATEGY) {
//                case StrategyFirst:
//                    new DataProvide().addStrategyFirst(file, input);
//                case StrategySecond:
//                    new DataProvide().addStrategySecond(file, input, PATH_DATA);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void setExperiment(ExampleExperiment exp) {
        exp.setDate(new Date().getTime());
        new DataProvider().addExperiment(exp);
    }

    public ExampleExperiment getExperiment(Long id) {
        return  (ExampleExperiment) new DataProvider().getExperimentById(id);
    }
    
    public List<ExampleExperiment> getExperiments() {
        return new DataProvider().getExperimentAll();
    }

    public List<Integer> getData(ExampleExperiment experiment, int start, int end,int channel) {

        List<Integer> resultList = new ArrayList<Integer>();
        int i = 0;
//        int channel = 1;
        ParsingData parserInfo = new ParsingData();
        String nameFile = experiment.getData().stream()
                .filter(data -> data.getType().equals(TypeDataExperiment.inf))
                .findFirst().get().getFileName();

        File file2 = new File(experiment.getData().stream()
                .filter(data -> data.getType().equals(TypeDataExperiment.dat))
                .findFirst().get().getFileName());
      
//        c experiment.getData().stream()
//                .filter(data -> data.getType().equals(TypeDataExperiment.dat))
//                .findFirst().get().getDataExperiment();
        byte[] dataByte = new byte[(int) file2.length()];
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file2);
//            fileInputStream2.read(bytes);
            fileInputStream2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> items = null;
        DataInputStream byteStream = null;
        try {
            items = (List<String>) Files.lines(Paths.get(nameFile), StandardCharsets.UTF_8)
                    .collect(Collectors.toList());
            byteStream = new DataInputStream(
                new FileInputStream(file2));                    
        } catch (IOException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        byte[] fileBaty = experiment.getData().stream()
//                .filter(data -> data.getType().equals(TypeDataExperiment.inf))
//                .findFirst().get().getDataExperiment();
//        
//        List<String> items = Arrays.asList(new String(fileBaty, StandardCharsets.UTF_8).split("\n"))
//                .stream().map(mapper -> mapper.trim())
//                .collect(Collectors.toList());
//        
        
//        List<String> items = Arrays.asList(new String(bytes, StandardCharsets.UTF_8).split("\n"))
//                .stream().map(mapper -> mapper.trim())
//                .collect(Collectors.toList());
        
//        items.forEach(action ->System.out.println(action));
        
//        System.out.println(parserInfo.mapList(parserInfo.findByInfo(items, "[Parameters]")).get("NChannels"));
        int nChannels = Integer.parseInt(parserInfo.mapList(parserInfo.findByInfo(items, "[Parameters]")).get("NChannels"));
//        int lengthData = experiment.getData().stream()
//                .filter(data -> data.getType().equals(TypeDataExperiment.dat))
//                .findFirst().get().getDataExperiment().length;
//        byte[] dataByte = new byte[lengthData];

//        dataByte = experiment.getData().stream()
//                .filter(data -> data.getType().equals(TypeDataExperiment.dat))
//                .findFirst().get().getDataExperiment();

//        DataInputStream byteStream = new DataInputStream(new ByteArrayInputStream(fileBaty));
        byte[] data = new byte[2];
        try {
            while (i < end) {
                int j = 0;
                while (j <= nChannels) {
                    if (i >= start & i <= end & j == channel) {
                        byteStream.read(data);
                        resultList.add((int) ((parserInfo.toShort(data)!=0) ? parserInfo.toShort(data) : 1));
                    } else {
                        byteStream.read(data);
                    }
                    j++;
                }
                i++;
            }
            byteStream.close();
        } catch (IOException ex) {
            logger.error(ex);
        }
        return resultList;
        
    }

//    public void parsingDoc(String PATH_DOC, String PATH_ROOT) {
//        InputStream doc;
//        try {
//            doc = new FileInputStream(new File(PATH_DOC));
////            XWPFDocument document = new XWPFDocument(is);
////            XHTMLOptions options = XHTMLOptions.create();
////            OutputStream out = new FileOutputStream(new File(
////                    PATH_ROOT + "wer.html"));
////            XHTMLConverter.getInstance().convert(document, out, options);
//
//            // 1) Load DOCX into XWPFDocument
//            //InputStream doc = new FileInputStream(new File("c:/document.docx"));
//            XWPFDocument document = new XWPFDocument(doc);
//
//            // 2) Prepare XHTML options (here we set the IURIResolver to load images from a "word/media" folder)
//            XHTMLOptions options = XHTMLOptions.create(); //.URIResolver(new FileURIResolver(new File("word/media")));;
//
//            // 3) Extract image
//            String root = "target";
//            File imageFolder = new File(PATH_ROOT + "/images/" + doc);
//            options.setExtractor(new FileImageExtractor(imageFolder));
//            // 4) URI resolver
//            options.URIResolver(new FileURIResolver(imageFolder));
//
    //            OutputStream out = new FileOutputStream(new File(PATH_ROOT + "wer.html"));
//            XHTMLConverter.getInstance().convert(document, out, options);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    public int getChennalExperiment(long id){
        
        ParsingData parserInfo = new ParsingData();
        String nameFile = this.getExperiment(id).getData().stream()
                .filter(data -> data.getType().equals(TypeDataExperiment.inf))
                .findFirst().get().getFileName();
//        byte[] fileBaty = this.getExperiment(id).getData().stream()
//                .filter(data -> data.getType().equals(TypeDataExperiment.inf))
//                .findFirst().get().getDataExperiment();
        List<String> items = null;
        try {
            items = (List<String>) Files.lines(Paths.get(nameFile), StandardCharsets.UTF_8)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
//        List<String> itemsW = Arrays.asList(new String(fileBaty, StandardCharsets.UTF_8).split("\n"))
//                .stream().map(mapper -> mapper.trim())
//                                .collect(Collectors.toList());
       
        return Integer.parseInt(parserInfo.mapList(parserInfo.findByInfo(items, "[Parameters]")).get("NChannels"));
    }
    
    public List<Users> getUsers(){
        return new DataProvider().getUsers();
    }
}
