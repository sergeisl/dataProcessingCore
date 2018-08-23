package ru.sfedu.authentication;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.core.authentication.GetTokenService;
import ru.sfedu.core.model.Users;
//import static org.junit.Assert.*;
//import ru.sfedu.core.model.Users;

/**
 *
 * @author sergei
 */
public class GetTokenServiceTest {
    
    public GetTokenServiceTest() {
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
     * Test of loginUser method, of class GetTokenService.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String login = "sergei.s.l@mail.ru";
        String password = "123s";
        GetTokenService instance = new GetTokenService();
        Users result = instance.loginUser(login, password);
        System.out.println(result.toString());
        
    }

    /**
     * Test of loginChek method, of class GetTokenService.
     */
    @Test
    public void testLoginChek() {
        System.out.println("loginChek");
        String jwtStr = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoid2VyIiwiY3VzdG9tIjoibXlDdXN0b20ifQ.m3zcY3W-tMJY3PMICvICoetFr-J_QGwFfppE5rizqWM";
        GetTokenService instance = new GetTokenService();
        String result = instance.loginChekw(jwtStr);
        System.out.println(result);

    }
    
}
