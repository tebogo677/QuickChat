/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

//

class Login {
    static String registeredUsername = "";
    static String savedUsername = "";
    static String savedPassword = "";
    static String savedCellphone = "";
    static String savedFirstname = "";
    static String savedLastname = "";
    
    static boolean checkUserName(String username){
        boolean hasUnderscore = false;
        
        if(username.indexOf('_') != -1){
            hasUnderscore = true;
        }
        
        if(hasUnderscore == true && username.length() <= 5){
            return true;
        } else {
            return false;
        }
    }
    //my checkpassword method
    static boolean checkPasswordComplexity(String password){
        boolean hasUpperCase = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;
        
        if(password.length() < 8){
            return false;
        }
        
        if(password.equals(password.toLowerCase()) == false){
            hasUpperCase = true;
        }
        
        if(password.indexOf('!') != -1 || password.indexOf('@') != -1 || password.indexOf('#') != -1 || 
           password.indexOf('$') != -1 || password.indexOf('%') != -1 || password.indexOf('^') != -1 || 
           password.indexOf('&') != -1 || password.indexOf('*') != -1 || password.indexOf('(') != -1 || 
           password.indexOf(')') != -1 || password.indexOf('_') != -1 || password.indexOf('+') != -1){
            hasSpecial = true;
        }
        
        if(password.indexOf('0') != -1 || password.indexOf('1') != -1 || password.indexOf('2') != -1 || 
           password.indexOf('3') != -1 || password.indexOf('4') != -1 || password.indexOf('5') != -1 || 
           password.indexOf('6') != -1 || password.indexOf('7') != -1 || password.indexOf('8') != -1 || 
           password.indexOf('9') != -1){
            hasNumber = true;
        }
        
        if(hasUpperCase == true && hasSpecial == true && hasNumber == true){
            return true;
        } else {
            return false;
        }
    }
    
    static boolean checkCellPhoneNumber(String cellphone){
        if(cellphone.startsWith("+27") == true && cellphone.length() == 12){
            String part1 = cellphone.substring(3, 4);
            String part2 = cellphone.substring(4, 5);
            String part3 = cellphone.substring(5, 6);
            String part4 = cellphone.substring(6, 7);
            String part5 = cellphone.substring(7, 8);
            String part6 = cellphone.substring(8, 9);
            String part7 = cellphone.substring(9, 10);
            String part8 = cellphone.substring(10, 11);
            String part9 = cellphone.substring(11, 12);
            
            if(part1.matches("\\d") == true && part2.matches("\\d") == true && 
               part3.matches("\\d") == true && part4.matches("\\d") == true && 
               part5.matches("\\d") == true && part6.matches("\\d") == true && 
               part7.matches("\\d") == true && part8.matches("\\d") == true && 
               part9.matches("\\d") == true){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    static String registerUser(String firstname, String lastname, String username, String password, String cellphone){
        String errorMessages = "";
        
        if(checkUserName(username) == false){
            errorMessages = errorMessages + "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters length.\n";
        }
        if(checkPasswordComplexity(password) == false){
            errorMessages = errorMessages + "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.\n";
        }
        if(checkCellPhoneNumber(cellphone) == false){
            errorMessages = errorMessages + "Cellphone is not correctly formatted or does not contain international code.\n";
        }
        
        if(errorMessages.isEmpty() == false){
            return errorMessages;
        }
        
        savedUsername = username;
        savedFirstname = firstname;
        savedLastname = lastname;
        savedCellphone = cellphone;
        savedPassword = password;
        
        return "Username successfully captured\nPassword successfully captured\nCellphone successfully captured\nWelcome " + firstname + " " + lastname + " it is great to see you.";
    }
    
    static boolean loginUser(String username, String password){
        if(username.equals(savedUsername) && password.equals(savedPassword)){
            return true;
        } else {
            return false;
        }
    }
    
    static String returnLoginStatus(boolean isLogged){
        if(isLogged == true){
            return "Welcome back " + savedFirstname + " " + savedLastname + " it is great to see you again";
        } else {
            return "A failed login";
        }
    }
}
