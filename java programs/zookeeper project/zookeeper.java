/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.swing.RowFilter.Entry;


public class zookeeper {

    HashMap<Integer, Animal> animals = new HashMap<Integer, Animal>();
    private static String FILE_NAME = "";
    private int id = 1;  
    Scanner scanner = new Scanner(System.in);
   /**
    *reads input from a give file
    *creates an object animal
    *passes the id with the animal into the hash map
    */
    public void readFromFile(String fileName){
                      
      try{
          FileInputStream inputStream = new FileInputStream(FILE_NAME);
          DataInputStream dataInputStream = new DataInputStream(inputStream);
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
          Scanner input = new Scanner(inputStream);
          
          while(input.hasNextLine()){

                String line = input.nextLine();	
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                String name = (tokens[1].substring(1, tokens[1].length()-1));	
                String species = (tokens[2].substring(1, tokens[2].length()-1));          
                Animal animal = new Animal(name, species);              
                animals.put(id, animal);
     
          }// end of while loop
          dataInputStream.close();
      
      }
      catch(FileNotFoundException e){
          System.out.println(e.getMessage());
      }//end of catch block
      
      catch(IOException e){
      
          System.out.println(e.getMessage());
      
      }//end of catch block
       
    }// end of method readFromFile
    /**
    *prints and formate the ledger  
    */
    public void printLedger(){
        
        System.out.println("Id    " + "   | " + "    Name     " + "   | " + "     Species     ");
        System.out.println("---------------------------------------------------");
        
        for(Map.Entry<Integer, Animal> key: animals.entrySet()){

            Integer id = key.getKey();
            String name = key.getValue().getName().toString();
            String species = key.getValue().getSpecies().toString(); 

           System.out.printf("%-9d|     %-12s|       %-10s",      id,name,species);
            System.out.println();             
        }//end of for loop
        
    }//end of method printLedger
    /**
    *takes a name, species, and id as parameters
    * writes these to a file
    */
    public static void writeToFile(String name, String species, int i){
       
        try {            
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)));                   
         out.println(i+",\"" + name + "\",\"" + species + "\"");         
         out.close();                  
        }// end of try block

        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }// end of catch block

        catch(IOException e){
            System.out.println(e.getMessage());
        }// end of catch block
    }//end of method writeToFile
    /**
    *determines if a string is Integer
    */
    public static boolean isInt(String value) {
        try { 
            Integer.parseInt(value); 
        }// end if try block 
        catch(NumberFormatException e) { 
            return false; 
        }//end of catch block
    
    return true;
    
    }//end of method isInt  
    
    /**
    *takes name, species, and id as parameters
    *updates the hash map
    *updates the current file
    */
    public void addToZoo(String name, String species, int id){
        if(!animals.containsKey(id)){
            
        clearTextFile(FILE_NAME);       
        Animal animal = new Animal(name, species);
        animals.put(id, animal);
        
        for(Map.Entry<Integer, Animal> key: animals.entrySet()){            
            writeToFile(key.getValue().getName(), key.getValue().getSpecies(), key.getKey());       
        }// end of for loop

        }else{
            System.out.println("Cannot have duplicate id's");
        }// end of else statement

    }// end of method addToZoo
    
    /**
    *takes a file name as a parameter
    *gets the current file
    *saves it to another file with the give name
    */
    public void save(String fileName){
        
        PrintWriter writer = null;
       
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
           
            for(Map.Entry<Integer, Animal> key: animals.entrySet()){            

                writeToFile(key.getValue().getName(), key.getValue().getSpecies(), key.getKey());                      
            }// end of for loop
         }// end of try block                       
        catch(IOException e){
            System.out.printf(e.getMessage());
        }// end of catch block
        
    }// end of save method
    
     /**
    *removes an animal with a given id number
    *gets the current file
    *saves it to another file with the give name
    */
    public void removeAnimal(int idNumber){

        if(animals.containsKey(idNumber)){
              
           animals.remove(idNumber);
           clearTextFile(FILE_NAME);
           try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {                        
                for(Map.Entry<Integer, Animal> key: animals.entrySet()){
                    printWriter.println(key.getKey() + ",\"" + key.getValue().getName() + ",\"" + key.getValue().getSpecies() + "\"");
                }// end of for loop
            }catch(IOException e){
               e.getMessage();
            }// end of catch block

       }else{
           System.out.println("Key cannot be found");
       }// end of else statement
       
    }//end of remove
    /**
    *takes a file name as a parameter
    *clears that file
    */
    public void clearTextFile(String fileName){       
        try{
            PrintWriter writer = new PrintWriter(fileName);
            writer.print("");        
            writer.close();
        }// end of try block
        catch(FileNotFoundException e){
            System.out.printf(e.getMessage());
        }// end of catch block   
    }// end of clearTextFile method    
    /**
    *set the files name
    */
    public void setFileName(String fileName){
       FILE_NAME = fileName;
    }//end of setFileName method
    
    /**
    *generates an id number
    * makes sure it is not a duplicate
    */
    public int createNonDuplicateIdNumber(int id){
               
        for(Map.Entry<Integer, Animal> key: animals.entrySet()){
            if(key.getKey() == id){
                id++;
            }// end of if statement
        }// end of for loop       
        return id;                
    }// end of method createNonDuplicateIdNumber 
    
   /**   
    *exits the program
    */
    public void exit(){
        System.exit(0);
    }// end of method exit
       
    public static void main(String[] args){
               
        zookeeper keeper = new zookeeper();
        Scanner scanner = new Scanner(System.in); 
        String fileName = "";
         
        while(true){    
            /**  
              *take command line arguments
              */  
            System.out.println("Enter a zookeper options: open <file name>, save <file name>, list, add <name> <species> <id number (optional)>, or exit");
            int id = 1;
            String zookeeperOption = scanner.nextLine();
            String[] tokens = zookeeperOption.split(" "); 
            /**
            *opens a file           
            */
            if(tokens[0].equals("open")){
                
                keeper.setFileName(tokens[1].toString());
                keeper.readFromFile(tokens[1].toString());           
   

            }// end of if statement
            /**
            *save a file to a given name           
            */
            else if(tokens[0].equals("save")){               
                String temp = FILE_NAME;
                keeper.setFileName(tokens[1]);
                keeper.save(tokens[1]);
                keeper.setFileName(temp);
            }// end of else if statmet
            /**
            *prints out the ledger           
            */
            else if(tokens[0].equals("list")){
                keeper.printLedger();
            }//end of else if statement
            /**
            *adds to the ledger and file          
            */
            else if(tokens[0].equals("add")){
                        
            if(tokens.length -1 == 2){ 
               if(tokens[1].length() > 10){
                   System.out.println("Value is too large");
               }//end of if statement
               else if(tokens[2].length() > 10){
                   System.out.println("Value is too large");
               }//end of else if statement
               else{ 
                    int i = keeper.createNonDuplicateIdNumber(id);
                    keeper.addToZoo(tokens[1],tokens[2],i);
               }//end of else stament

            }//end of if statement
            else if(tokens.length-1 == 3){
               
               if(tokens[1].length() > 10){
                   System.out.println("Value is too large");
               }//end of if statement
               else if(tokens[2].length() > 10){
                   System.out.println("Value is too large");
               }//end of else if statement
               
               else if(tokens[3].length() > 8){
                   System.out.println("Value is too large");
               }//end of else if statement
               else{
                int i = Integer.parseInt(tokens[3]);
                keeper.addToZoo(tokens[1], tokens[2], i); 
               }//end of else statement
            }         
            else if(tokens.length-1 > 3){
                
                System.out.println("Not a valid input");
                
            }//end of else if statement
            
            } // end of else if
            /**
            *removes from the ledger and file           
            */
            else if(tokens[0].equals("remove")){
                
                String i = tokens[1];
                Boolean value = isInt(i);
                if(value == true){
                int b =  Integer.parseInt(i);
                keeper.removeAnimal(b);
                }//end of else if statement
                else {
                    System.out.println("Value must be an int");
                }//end of else statement
            } //end of else if
            /**
            *exits the program           
            */
            else if(zookeeperOption.equals("exit")){
                keeper.exit();
            }//end of else  
            /**
            *invalid input by user           
            */
            else{
                System.out.println("Not a valid option please try again");

            }// end of else

            }// end of while

    }//end of main
     
}//end of class Zookeeper
