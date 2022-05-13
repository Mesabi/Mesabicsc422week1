/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422week1petproject;

/**
 *
 * @author mesabi
 */
public class Pet {
    private int petID;
    private int petAge;
    private String petName;

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }
    public int getPetID() {
        return petID;
    }

    public String getPetName() {
        return petName;
    }
    
    public Pet(){}
    
    public Pet(int petID, String petName, int petAge){
        this.petID = petID; 
        this.petName = petName;
        this.petAge = petAge;
    }
}
