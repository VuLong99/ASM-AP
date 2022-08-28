/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import toolpackage.Tools;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author HP
 */
public class Ticket {
    private String id;
    private LocalDate date_of_purchase;
    private LocalTime time_of_purchase;
    private String seat_name;
    private String payment;
    private Premiere premiere;
    
    public Ticket(Premiere in_premiere, String in_seat_name){
        this.id = Tools.generate_id("T");
        this.payment = "65.000 VND";
        this.date_of_purchase = LocalDate.now();
        this.time_of_purchase = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.premiere = in_premiere;
        this.seat_name = in_seat_name;
    }
    
    public String get_id(){
        return this.id;
    }
    
    public int get_film_duration(){
        return this.premiere.get_film_duration();
    }
    
    public String get_film_name(){
        return this.premiere.get_film_name();
    }
    
    public String get_room_name(){
        return this.premiere.get_room_name();
    }
    
    public String get_seat_name(){
        return this.seat_name;
    }
    
    public String get_payment(){
        return this.payment;
    }
    
    public LocalDate get_purchase_date(){
        return this.date_of_purchase;
    }
    
    public LocalTime get_purchase_time(){
        return this.time_of_purchase;
    }
    
    public LocalTime get_start_time(){
        return LocalTime.parse(this.premiere.get_start_time());
    }
    
    public LocalTime get_end_time(){
        return LocalTime.parse(this.premiere.get_endtime());
    }
    
    public LocalDate get_release_date(){
        return this.premiere.get_date();
    }
    
}
