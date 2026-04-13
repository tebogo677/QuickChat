/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;

public class QuickChat {

    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter your firstname: ");
        String firstname = scan.next();
        
        System.out.println("Enter your lastname: ");
        String lastname = scan.next();
        
        System.out.println("Enter your username: ");
        String username = scan.next();
        
        System.out.println("Enter your password: ");
        String password = scan.next();
        
        System.out.println("Enter your cellphone: ");
        String cellphone = scan.next();
        
        String output = Login.registerUser(firstname, lastname, username, password, cellphone);
        System.out.println(output);
        
        if(output.contains("is not correctly")){
            return;
        }
        
        System.out.print("Enter your username: ");
        String LoginUsername = scan.next();
        
        System.out.print("Enter your password: ");
        String LoginPassword = scan.next();
        
        boolean LoginOutput = Login.loginUser(LoginUsername, LoginPassword);
        
        System.out.println(Login.returnLoginStatus(LoginOutput));
    }
}
