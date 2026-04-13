/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class MyTests {
      
    @Test
    public void testCheckUserNameCorrect() {
        Assertions.assertEquals(true, Login.checkUserName("kyl_1"));
    }
    
    @Test
    public void testCheckUserNameIncorrect() {
        Assertions.assertEquals(false, Login.checkUserName("kyle!!!!!"));
    }
    
    @Test
    public void testCheckPasswordComplexityCorrect() {
        Assertions.assertEquals(true, Login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test
    public void testCheckPasswordComplexityIncorrect() {
        Assertions.assertEquals(false, Login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testCheckCellPhoneNumberCorrect() {
        Assertions.assertEquals(true, Login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        Assertions.assertEquals(false, Login.checkCellPhoneNumber("08966553"));
    }
   
    @Test
    public void testRegisterUser() {
        String result = Login.registerUser("Thabo", "Nkosi", "tha_b", "Th@b0Sec99!", "+27721234567");
        Assertions.assertEquals(true, result.contains("Welcome"));
    }
    
    @Test
    public void testLoginUserCorrect() {
        Login.registerUser("Thabo", "Mkhize", "tha_b", "L3r@t0Sec99!", "+27731234567");
        Assertions.assertEquals(true, Login.loginUser("tha_b", "L3r@t0Sec99!"));
    }
    
    @Test
    public void testLoginUserIncorrect() {
        Login.registerUser("Sipho", "Dlamini", "sip_ho", "S1ph0Sec99!", "+27741234567");
        Assertions.assertEquals(false, Login.loginUser("wrong", "wrong"));
    }
    
    @Test
    public void testReturnLoginStatusSuccess() {
        Login.registerUser("Nomsa", "Zulu", "tha_b", "N0ms@Sec99!", "+27751234567");
        String result = Login.returnLoginStatus(true);
        Assertions.assertEquals(true, result.contains("Welcome"));
    }
    
    @Test
    public void testReturnLoginStatusFailed() {
        String output = Login.returnLoginStatus(false);
        Assertions.assertEquals(true, output.contains("failed"));
    }
}