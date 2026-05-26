/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
import java.util.Random;
import java.util.Scanner;

public class Message {
    // These are the properties of a message
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private static int totalMessagesSent = 0;
    
    // This runs when you create a new message
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    
    // Method 1: Check if message is not too long (max 250 chars)
    public boolean checkMessageLength() {
        if (messageText.length() <= 250) {
            System.out.println("Message ready to send.");
            return true;
        } else {
            int excess = messageText.length() - 250;
            System.out.println("Message exceeds 250 characters by " + excess + 
                             "; please reduce the size.");
            return false;
        }
    }
    
    // Method 2: Check if phone number is correct (+27 and 12 chars total)
    public String checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() == 12) {
            String numbers = recipient.substring(3);
            if (numbers.matches("\\d+")) {
                return "Cell phone number successfully captured.";
            }
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
    
    // Method 3: Create the special Message Hash
    public String createMessageHash() {
       
        String firstTwo = messageID.substring(0, 2);
        
        String msgNum = String.valueOf(messageNumber);
        

        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        String hash = firstTwo + ":" + msgNum + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }
    
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }
    
    // Method 4: Let user choose Send, Delete, or Store
    public String sentMessage() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message (Delete)");
        System.out.println("3. Store Message to send later");
        System.out.print("Choose option (1/2/3): ");
        
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            totalMessagesSent++;
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            storeMessage();
            return "Message successfully stored.";
        } else {
            return "Invalid option.";
        }
    }
    
    // Method 5: Store message (for JSON - you can improve this later)
    public void storeMessage() {
        System.out.println("Storing message to messages.json...");
      
    }
    
    // Method 6: Print all message details
    public String printMessage() {
        return "Message ID: " + messageID + 
               ", Message Hash: " + messageHash + 
               ", Recipient: " + recipient + 
               ", Message: " + messageText;
    }
    
    // Method 7: Get total number of messages sent
    public static int returnTotalMessages() {
        return totalMessagesSent;
    }
    
    // Getters for testing
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
} 

