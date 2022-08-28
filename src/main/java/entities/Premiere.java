/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import toolpackage.Tools;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class Premiere {
    private String id;
    private Film film;
    private LocalDate date;
    private String start_time;
    private String endtime;
    private int num_seat_row;
    private int num_seat_column;
    private int num_seat;
    private Room room;
    private List<String> seat_list = new ArrayList<>();
    
    public Premiere(Film in_film, Room in_room, LocalDate in_date, String in_time){
        this.id = Tools.generate_id("P");
        this.film = in_film;
        this.date = in_date; //2022-07-07
        this.start_time = Tools.format_timedata(in_time);
        this.endtime = Tools.calculate_endtime(this.film.get_duration(), this.start_time);
        this.room = in_room;
        this.seat_list = this.room.get_seat_list();
        this.num_seat_row = this.room.get_num_seat_row();
        this.num_seat_column = this.room.get_num_seat_column();
        this.num_seat = this.room.get_num_seat();
    }
    
    public String get_id(){
        return this.id;
    }
    
    public void set_id(String new_id){
        this.id = new_id;
    }
    
    public void set_film(Film new_film){
        this.film = new_film;
        this.endtime = Tools.calculate_endtime(this.film.get_duration(), this.start_time);
    }
    
    public void set_room(Room new_room){
        this.room = new_room;
    }
    
    public int get_film_duration(){
        return this.film.get_duration();
    }
    
    public String get_film_name(){
        return this.film.get_name();
    }
    
    public LocalDate get_date(){
        return this.date;
    }
    
    public void set_date(LocalDate new_date){
        this.date = new_date;
    }
    
    public String get_start_time(){
        return this.start_time;
    }
    
    public void set_start_time(String new_start_time){
        this.start_time = new_start_time;
        this.endtime = Tools.calculate_endtime(this.film.get_duration(), this.start_time);
    }
    
    public String get_endtime(){  
        return this.endtime;  
    }
    
    public String get_room_name(){
        return this.room.get_name();
    }
    
    public String get_room_id(){
        return this.room.get_id();
    }
    
    public boolean remove_seat(String seat_name){
        int seat_index;
        try{
            seat_index = this.seat_list.indexOf(seat_name);
            this.seat_list.set(seat_index, " ");
            return true;
        }
        catch (Exception e) {
            System.out.println("There is no such a seat in this room, try again");
            return false;
        }
        
    }
    
    public void show_seats(){
        int i = 0;
        for (String seat_name : seat_list){
            i++;
            System.out.print(seat_name + " ");
            if (i == this.num_seat_column){
                i = 0;
                System.out.println();
            }
        }
    }
    
    public int get_num_seat(){
        return this.num_seat;
    }
}
