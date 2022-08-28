/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import toolpackage.Tools;
/**
 *
 * @author HP
 */
public class Admin extends Person {
    private String id;
    
    public Admin(String Name, String p_number, String Email, 
            String Date_of_birth, String Region){
        super(Name, p_number, Email, Date_of_birth, Region);
       
        id = Tools.generate_id("A");
        
    }
               
    public String get_id(){
        return this.id;
    }   
    
}
  
