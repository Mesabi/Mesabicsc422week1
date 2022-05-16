/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422week1petproject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  

/**
 *
 * @author mesabi
 */
public class mainLogic {
    
    public PetDirectory petLibrary;
    Scanner scanner;  // Create a Scanner object
    public Boolean running;
    
    
    
    public mainLogic(){
        petLibrary = new PetDirectory();
        running = true;
        scanner = new Scanner(System.in);
        Pet bob = new Pet(1, "bob",0);
        Pet tom = new Pet(2, "thomas",0);
        Pet ed = new Pet(3, "eddy",0);
        petLibrary.addPet(ed);
        petLibrary.addPet(tom);
        petLibrary.addPet(bob);
        System.out.println("Welcome to the Pet Database!");


       
    }
    
    public void menuText(){
        System.out.print(
        "Pet Database Program.\n" +
        "What would you like to do?\n" +
        "1) View all pets\n" +
        "2) Add more pets\n" +
        "3) Update an existing pet\n" +
        "4) Remove an existing pet\n" +
        "5) Search pets by name\n" +
        "6) Search pets by age\n" +
        "7) Exit program \n"+
                "Your choice: "
        );        
    }
    
    public void runProgram(){       
        while(running){
            runMenu();         
        }
      
    }
    
    public void runMenu(){
        menuText();
        int select = 0;
        try{
           select = getInt(getInput());
        }catch(Exception e){
           System.out.println("Was Unable to Resolve Input!");
           System.out.println("Please Try Again!");
        }
        switch(select) {
            case 1:
    // code block
                viewPets();
                break;
            case 2:
                addPet();
                break;
            case 3:
               System.out.println("Each Pet was Forged with Purpose and Intention.");
               System.out.println("They will not be modified!");
               int die = 5 / 0;
               break;                
            case 4:
               removePet();
                break;  
            case 5:
               handleNameSearch();
                break;
            case 6:
               handleIntSearch();
                break;
            case 7:
                running = false;
                break;                
            case 8:
               System.out.println("Functionality Not Added!");
                break;                  
            default:
                System.out.println("Input not Recognized! Please Try Again!");
              
    // code block
}
    }
    public void removePet(){
        
        Boolean petComplete = false;
        viewPets();
        int search = -2;
         while(!petComplete){
             try{
                System.out.println("Please Input a Pet ID to remove, or type -1 to exit!");     
                search = getInt(getInput());
                petComplete = true;
                break;
            }catch(Exception e){
               System.out.println("Error, please retry, or type -1 to exit");               
            }
            if(search == -1){
                return;
            }else{
                for(Pet iterate : petLibrary.allPets){
                    if(iterate.getPetID() == search){
                        Pet temp = petLibrary.getPetByID(search);
                        petLibrary.allPets.remove(temp);
                        System.out.println("Pet was Removed");  
                    }
                }

                   
            
            }
         }
    }
    
    
    
    
    
    
    public void addPet(){
        Boolean petComplete = false;
        String name;
        int age = 0;
        int id = 0; 
        while(!petComplete){
            //print
            System.out.println("Please Input a Pet Name!");
            name = getInput();
            //
            try{
                System.out.println("Please Input a Pet Age!");
                age = getInt(getInput());
            }catch(Exception e){
                System.out.println("Please Input a valid Integer!");
                
            }
            id = petLibrary.getAllPetCount() + 1;
            try{
                Pet temp = new Pet(id, name, age);
                petLibrary.addPet(temp);
                System.out.println("Enter Another Pet by pressing enter, or Exit by entering 'e' ");
                
            
            }catch(Exception e){
                System.out.println("Was Not Able to create a new Pet!");
                System.out.println("Press any key to retry, or Exit by entering 'e' ");

            }
            String e = getInput();
            if(e.equals("e")){
                    petComplete = true;
                    break;
                }
            
        }
        
        
    }
    
    
    public void viewPets(){
        header();
        System.out.println("| ID |   NAME   |   AGE| ");
        header();
        for(int i = 0;i < petLibrary.allPetCount; i++){
            printPetLine(petLibrary.allPets.get(i));
        }
        header();
   
    }
    public void viewSomePets(ArrayList<Pet> pets){
        header();
        System.out.println("| ID |   NAME   |   AGE| ");
        header();
        for(int i = 0;i < pets.size(); i++){
            printPetLine(pets.get(i));
        }
        header();
    } 
    
    
    
    public void header(){
        System.out.println("+----------------------+ ");
    }
    
    public void printPetLine(Pet petIn){
        //yes, I could use printf. This was easier. 
        System.out.println("|"+
                oneOrTwoSpaces(petIn.getPetID())+
                petIn.getPetID()+
                "| "+
                petIn.getPetName()+
                someLengthOfSpaces(petIn.getPetName())+
                "|"+
                oneOrTwoSpaces(petIn.getPetAge())+
                petIn.getPetAge()+
                "|"       
        );
        
        
    }
    private String oneOrTwoSpaces(int in){
        if(in < 10){
            return "  ";
        }else if(in < 100){
            return " ";
        }else{
            return "";
        }      
    }
    public String someLengthOfSpaces(String in){
        //returns some arbitrary amount of spaces. 
        String[] array = new String[12-in.length()];
        for(int i = 0; i < array.length;i ++){
            array[i]= " ";
        }
        return String.join("", array);
    }
    
    
    public int evaluateLength(String in){
        return in.length();
    }

    public String getInput(){
        //shortens all input to < 10 char.
        //God forbid that the Scanner class not be a heaping pile of ----
         String rawString = scanner.nextLine(); 
         //System.out.println(rawString);
         if(rawString.length() > 10){           
             return rawString.substring(0, Math.min(rawString.length(), 10));
         }else{
             return rawString;
         }
    }
    
    public int getInt(String in){
        //returns an int from a string. Make sure it can do this before using. 
        return Integer.parseInt(in); 
    }
    
    public void handleNameSearch(){
        System.out.println("Input Pet Name!");
        String search = getInput();
               
        
        if(petLibrary.PetExists(search)){
           viewSomePets(petLibrary.getPetMultName(search));  
        }else{
            header();
            System.out.println("No Pet Returned");
            header();           
        }
        }
    
     public void handleIntSearch(){
        System.out.println("Input Pet Age!");
        Boolean intIn = false;
        int search = -1;
        while(intIn){
            try{
        System.out.println(">>");
                
                search = getInt(getInput());
                intIn = true;
                break;
            }catch(Exception e){
                System.out.println("Input an Integer!");
            }          
        }                       
        if(petLibrary.PetExistsAge(search)){
           viewSomePets(petLibrary.getPetMultInt(search));  
        }else{
            header();
            System.out.println("No Pet Returned");
            header();           
        }
        }       
       
    
    
    
    

    
    
    
    
    
    
    
    
    
}
