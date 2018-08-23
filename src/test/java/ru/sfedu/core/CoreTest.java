package ru.sfedu.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.core.Core;
import ru.sfedu.core.authentication.Authorization;
import ru.sfedu.core.dataProvide.EventController;
import ru.sfedu.core.dataProvide.DataProvider;
import ru.sfedu.core.model.ExampleExperiment;
import ru.sfedu.core.model.LogEvents;
import ru.sfedu.core.model.Users;

/**
 *
 * @author sergei
 */
public class CoreTest {
    
    public CoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setExperiment method, of class Core.
     */
        @Test
    public void tesreg() {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Transaction transaction = null;
//            transaction = session.beginTransaction();
//            Users user = new Users("sergei111","sazhin1111","wert1211","123s");
//            user.setPermission(Permission.admin);
//            session.save(user);
//
//            transaction.commit();
//            session.close();
//            HibernateUtil.shutdown();
//            String PATH_DATA = "/home/sergei/PLX/plx2csv/wer.plx.csv";
//            
//            try {    
//                DataInputStream input = new DataInputStream(
//                        new FileInputStream(PATH_DATA));
//                int i = 0;
//                for(;i<=30;i++){
//                    System.out.println(input.readLine());
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }
    
    @Test
    public void testSetExperiment() throws FileNotFoundException, IOException {
//        System.out.println("setExperiment");
//        Core instance = new Core();
////        System.out.println(instance.getExperiment(10L).toString());
//        instance.getData((instance.getExperiment(20L)) , 1, 10, 1).forEach(action->System.out.println(action));
////        instance.getExperiments().forEach(action->System.out.println(action.toString()));
//                System.out.print(instance.getChennalExperiment(20L));
//             
////      
    }
//
//    public static short toShort(byte[] array) {
//        short i = (short) (((0xFF & array[0]) << 0) | ((0xFF & array[1]) << 8));
//        return i;
//    }
//    /**
//     * Test of getExperiment method, of class Core.
//     */
//    @Test
//    public void testGetExperiment() throws FileNotFoundException {
//        System.out.println("getExperiment");
//        ExampleExperiment exp = new ExampleExperiment();
//        List<ExperimentData> dataExp = new ArrayList<ExperimentData>();
//        ExperimentData wer = new ExperimentData();
//        ExperimentData wer2 = new ExperimentData();
//        
//        String asdasdasd = "/home/sergei/ExperimentalData/experimental1/05 03 18.inf";
//        
//        File file = new File(asdasdasd);
//        byte[] fileContent = new byte[(int) file.length()];
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            fileInputStream.read(fileContent);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String asdasdasd2 = "/home/sergei/ExperimentalData/experimental1/05 03 18.dat";
//        File file2 = new File(asdasdasd2);
//        byte[] fileContent2 = new byte[(int) file2.length()];
//        try {
//            FileInputStream fileInputStream2 = new FileInputStream(file2);
//            fileInputStream2.read(fileContent2);
//            fileInputStream2.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        wer.setType(TypeDataExperiment.inf);
//        wer.setFileName(asdasdasd);
////        wer.setDataExperiment(fileContent);
//        wer2.setType(TypeDataExperiment.dat);
//        wer2.setFileName(asdasdasd2);
////        wer2.setDataExperiment(fileContent2);
//        
//        dataExp.add(wer);
//        dataExp.add(wer2);
//        exp.setUser(new Authorization().login("wert1", "123s"));
//        exp.setData(dataExp);
//        DataProvide DP = new DataProvide();
//        DP.addExperiment(exp);
//    }
//        ExampleExperiment newExp = (ExampleExperiment) DP.getExperimentById(1L);
//        newExp.getData().forEach(action->System.out.println(action.getDataExperiment().length));
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        transaction = session.beginTransaction();
//        ExperimentData experiment = (ExperimentData) session.get(ExperimentData.class, 2L);
//        transaction.commit();
//        session.close();
//        System.out.println(experiment.getDataExperiment().length);
        
//    }
//
//    /**
//     * Test of getData method, of class Core.
//     */
//    @Test
//    public void testGetData() {
//        System.out.println("getData");
////        int start = 2;
////        int end = 10;
////        Core instance = new Core();
//////        Info info = instance.getExperiment(1L, Strategy.StrategySecond);
////        List<Integer> expResult = null;
////        List<Integer> result = instance.getData(info, start, end);
////        System.out.println(result.get(0));
////        System.out.println(result.get(1));
////        System.out.println(result.get(2));
////    }
//    @Test
//    public void testLog() {
//        int i = 0;
//        for(;i<=25;i++){
//            new EventController().addEvent(new LogEvents( "Log"+i, new DataProvider().getExperimentById(23L), "Name"+i,new Date().getTime(), new Authorization().login("wert1", "123s")));
//        }
//    }   
    @Test
    public void testLogGet() {
//        List<LogEvents> log = new EventController().getLogEvents(3, 5);
//        log.forEach(action->System.out.println( action.toString()));
            if(DigestUtils.md5Hex("123s").equals("4e05549202ece8ef2450019692d1829e")){
                System.out.println(DigestUtils.md5Hex("123s"));
            }
    }   

//    /**
//     * Test of parsingDoc method, of class Core.
//     */
//    @Test
//    public void testParsingDoc() {
//        System.out.println("parsingDoc");
//        String PATH_INFO = "/home/sergei/ExperimentalData/experimental1/05 03 18.inf";
//        String PATH_ROOT = "/home/sergei/ExperimentalData/experimental1/";
//        String PATH_DATA = "/home/sergei/ExperimentalData/experimental1/05 03 18.dat";
//        String PATH_DOC = "/home/sergei/ExperimentalData/experimental1/Протокол испытания 27.02.18 Н5.docx";
//
//        Core instance = new Core();
//        instance.parsingDoc(PATH_DOC, PATH_ROOT);
//    }
//    

    /**
     * Test of getExperiment method, of class Core.
     */
    @Test
    public void testGetExperiment() {
        System.out.println("getExperiment");
        Long id = null;
        Core instance = new Core();
        ExampleExperiment expResult = null;
//        ExampleExperiment result = instance.getExperiment(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getExperiments method, of class Core.
     */
    @Test
    public void testGetExperiments() {
        System.out.println("getExperiments");
        Core instance = new Core();
        List<ExampleExperiment> expResult = null;
//        List<ExampleExperiment> result = instance.getExperiments();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Core.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ExampleExperiment experiment = null;
        int start = 0;
        int end = 0;
        int channel = 0;
        Core instance = new Core();
        List<Integer> expResult = null;
//        List<Integer> result = instance.getData(experiment, start, end, channel);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getChennalExperiment method, of class Core.
     */
    @Test
    public void testGetChennalExperiment() {
//        System.out.println("getChennalExperiment");
        long id = 0L;
        Core instance = new Core();
        int expResult = 0;
//        int result = instance.getChennalExperiment(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Core.
     */
    @Test
    public void testGetUsers() {
//        System.out.println("getUsers");
        Core instance = new Core();
        List<Users> expResult = null;
//        List<Users> result = instance.getUsers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testGetChennalExperiment1() {
//        System.out.println("getChennalExperiment");
        long id = 0L;
        Core instance = new Core();
        int expResult = 0;
//        int result = instance.getChennalExperiment(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Core.
     */
    @Test
    public void testGetUsers1() {
//        System.out.println("getUsers");
        Core instance = new Core();
        List<Users> expResult = null;
//        List<Users> result = instance.getUsers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    @Test
    public void testGetUsers11() {
//        System.out.println("getUsers");
        Core instance = new Core();
        List<Users> expResult = null;
//        List<Users> result = instance.getUsers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
