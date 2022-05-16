/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422week1petproject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mesabi
 */
public class PetDirectory {

    
    
    public ArrayList<Pet> allPets;
    
    public int allPetCount = 0;
    
    public int getAllPetCount(){
        return allPetCount;
    }
    
    public PetDirectory() {
        allPets = new ArrayList<Pet>();
    }
    
    public void updatePetCount(){
        allPetCount = allPets.size();
    }
    
    public void addPet(Pet newPet){
        allPets.add(newPet);
        updatePetCount();
       
    }
    public void removePet(Pet newPet){
        allPets.remove(newPet);
        updatePetCount();

       
    }
    
    public boolean PetExists(String searchPet)
    {//searches to see if a pet exists.
        for(Pet search : allPets)
        {
            if(search.getPetName().equals(searchPet))
            {
                return true;
            }
        }
        return false;
    } 
    
    
    
    public boolean PetExistsAge(int searchPet)
    {//searches to see if a pet exists.
        for(Pet search : allPets)
        {
            if(search.getPetAge() == searchPet)
            {
                return true;
            }
        }
        return false;
    }     
    
    public Pet getPetByID(int fetch){
        return allPets.get(fetch);
    }
    
    public boolean multipleSameName(String searchPet){
        int petsByName = 0;
        for(Pet search : allPets)
        {
            if(search.getPetName().equals(searchPet))
            {
                petsByName ++;
            }
        }
        if(petsByName > 1){
            return true;
        }else{
            return false;
        }
            
    }
    public boolean multipleSameAge(int searchPet){
        int petsByName = 0;
        for(Pet search : allPets)
        {
            if(search.getPetAge() == searchPet)
            {
                petsByName ++;
            }
        }
        if(petsByName > 1){
            return true;
        }else{
            return false;
        }
            
    }
    
    public ArrayList<Pet> getPetMultName(String searchPet){
        ArrayList<Pet> exit = new ArrayList<Pet>();
        for(Pet search : allPets)
        {
            if(search.getPetName().equals(searchPet))
            {
                exit.add(search);
            }
        }
        return exit;     
    }
     public ArrayList<Pet> getPetMultInt(int searchPet){
        ArrayList<Pet> exit = new ArrayList<Pet>();
        for(Pet search : allPets)
        {
            if(search.getPetAge() == searchPet)
            {
                exit.add(search);
            }
        }
        return exit;     
    }   
    
    
    public Pet getPet(String searchPet)
    {//returns a pet
        for(Pet search : allPets)
        {
            if(search.getPetName().equals(searchPet))
            {
                return search;
            }
        }
        return new Pet(-1,"Not Found",0);
    } 
    
    
    
    
    
    
}
