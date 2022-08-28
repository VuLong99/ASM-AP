/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import Controller.Manage_films;
import Controller.Manage_premieres;
import film_report.Display_film_feed;
import film_report.Film_data;
import toolpackage.Tools;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class User extends Person {
    private String id;
    private ArrayList<Ticket> ticket_array;
    private Display_film_feed film_feed;
    
    public User(String Name, String p_number, String Email, 
            String Date_of_birth, String Region){
        
        super(Name, p_number, Email, Date_of_birth, Region);
        this.id = Tools.generate_id("U");
        this.ticket_array = new ArrayList<>();
        
    }
       
    public void book_ticket(ArrayList<Film> film_array, Manage_films film_manager, 
            Manage_premieres premiere_manager, ArrayList<Premiere> premiere_array){
        
        Scanner s = new Scanner(System.in);
        film_manager.show_all_items(film_array);
        Premiere premiere = premiere_manager.search_premiere_by_film_name(premiere_array);
        System.out.println("Type the name of the seat to select the seat: ");
        premiere.show_seats();
        String seat_name;
        while (true){
            seat_name = s.nextLine().toUpperCase();
            boolean found = premiere.remove_seat(seat_name);
            if (found){
                break;
            }
        }
        
        Ticket ticket = new Ticket(premiere, seat_name);
        this.ticket_array.add(ticket);
    }
    
    public void show_all_tickets(){
        System.out.println("Your tickets");
        System.out.println("-------------------------------");
        for (Ticket ticket : ticket_array){
            System.out.println("Film name: " + ticket.get_film_name());
            System.out.println("Start time and End time: " + ticket.get_start_time() + " ~ " + ticket.get_end_time());
            System.out.println("Date: " + ticket.get_release_date());
            System.out.println("Seat name: " + ticket.get_seat_name());
            System.out.println("Room name: " + ticket.get_room_name());
            System.out.println("Payment: " + ticket.get_payment());
            System.out.println("Time of purchase: " + ticket.get_purchase_time());
            System.out.println("Data of purchase: " + ticket.get_purchase_date());
            System.out.println("-------------------------------");
        }
    }
    
    public void register_film_feed(Film_data film_reporter){
        this.film_feed = new Display_film_feed(film_reporter);
    }
    
    public void unregister_film_feed(Film_data film_reporter){
        film_reporter.remove_observer(this.film_feed);
        this.film_feed = null;
    }

}


