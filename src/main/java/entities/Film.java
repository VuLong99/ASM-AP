/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import toolpackage.Tools;
import java.time.LocalDate;
/**
 *
 * @author HP
 */
public class Film {
    private String id;
    private String name;
    private LocalDate date_of_release;
    private int duration; // in minute : 180 minutes
    private String genre;
    private String director;
   
    public Film(String input_name, LocalDate input_date_of_release, int input_duration, 
             String input_genre, String input_director){
        id = Tools.generate_id("F");
        name = input_name;
        date_of_release = input_date_of_release;
        duration = input_duration;
        genre = input_genre;
        director = input_director;
    }
    
    public String get_id(){
        return this.id;
    }
    
    public void set_id(String new_id){
        this.id = new_id;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public void set_name(String new_name){
        this.name = new_name;
    }
    
    public LocalDate get_date_of_release(){
        return this.date_of_release;
    }
    
    public void set_date_of_release(LocalDate new_date){
        this.date_of_release = new_date;
    }
    
    public int get_duration(){
        return this.duration;
    }
    
    public void set_duration(int new_duration){
        this.duration = new_duration;
    }
    
    public String get_genre(){
        return this.genre;
    }
    
    public void set_genre(String new_genre){
        this.genre = new_genre;
    }
    
    public String get_director(){
        return this.director;
    }
    
    public void set_director(String new_director){
        this.director = new_director;
    }
}
