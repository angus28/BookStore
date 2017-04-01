/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author angusmiller
 */
public class UserInputValidation {
    private Scanner scanner = new Scanner(System.in);
    private boolean start = true;
    
//    public int quantity(int quantity){
//        String strQuantity;
//        
//        // convert double to string
//        quantity = Integer.toString(quantity);
//        
//        Pattern pattern =
//                Pattern.compile("[0-9]{1,}.[0-9]{2}+$"); // match 0.00 format
//        
//        Matcher matcher = 
//                pattern.matcher(strQuantity);
//        
//        boolean found = false;
//        while(!found){
//            matcher = pattern.matcher(strQuantity);
//            
//            while(matcher.find()){
//                System.out.print("No match found. \n Enter the books quantity: ");
//                strQuantity = scanner.nextLine();
//            }
//        }
//        quantity = Integer.parseInt(strQuantity);
//        return quantity;
//    }
//
//    
//    public Double price(Double price){
//        String strPrice;
//        
//        // convert double to string
//        DecimalFormat df = new DecimalFormat("0.00");
//        df.setMaximumFractionDigits(2);
//        strPrice = df.format(price);
//        
//        Pattern pattern =
//                Pattern.compile("[0-9]{1,}.[0-9]{2}+$"); // match 0.00 format
//        
//        Matcher matcher = 
//                pattern.matcher(strPrice);
//        
//        boolean found = false;
//        while(!found){
//            matcher = pattern.matcher(strPrice);
//            
//            while(matcher.find()){
//                System.out.print("No match found. \n Enter the books title's selling price: ");
//                strPrice = scanner.nextLine();
//            }
//        }
//        price = Double.parseDouble(strPrice);
//        return price;
//    }
    
    public String isbn(String input){
    Scanner scanner = new Scanner(System.in); 
       
       Pattern pattern = Pattern.compile("[0-9]-[0-9]{3}-[0-9]{5}-[0-9]"); // regex pattern for ISBN
       
       boolean found = false;
       while (!found){
       System.out.print("Enter the book ISBN:"); 
       input = scanner.next();
       Matcher matcher = pattern.matcher(input);
      
       // check if input matchs pattern
       
       while(matcher.find()){
           return input;
       }
       
       System.out.println("Looks like you have enter a invalid input. The isbn format is 0-000-00000-0 where the 0's are any digit from 1 - 9" );
      
       }
       return input;
    }
    
    public String name(String name, String nameType){
        Scanner scanner = new Scanner(System.in); 
        
        Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
        
        boolean found = false;
        
        while (!found){
        System.out.print("Enter the " + nameType + " name: ");
        name = scanner.next();
        Matcher matcher = pattern.matcher(name);
        
  
            
            
            while(matcher.find()){
                return name;
                
            }
            
            System.out.println("Looks like you have enter a invalid input. Make sure it contain only letters!");
         
        }
        return name;
    }
}
