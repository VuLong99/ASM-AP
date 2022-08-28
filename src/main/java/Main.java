/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
import Controller.Manage_films;
import Controller.Manage_premieres;
import Controller.Manage_rooms;
import entities.Admin;
import entities.Film;
import entities.Premiere;
import entities.Room;
import entities.User;

import film_report.Film_data;
import java.time.LocalDate;
/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
      ArrayList<Film> film_array = new ArrayList<>();
      ArrayList<Room> room_array = new ArrayList<>();
      ArrayList<User> user_array = new ArrayList<>();
      ArrayList<Admin> admin_array = new ArrayList<>();
      ArrayList<Premiere> premiere_array = new ArrayList<>();
      
      Manage_rooms room_manager = new Manage_rooms();
      Manage_films film_manager = new Manage_films();
      Manage_premieres premiere_manager = new Manage_premieres(film_array, film_manager, 
           room_array, room_manager);
      
      User user1 = new User("Heisenberg", "110133215", "bhaf1101", "20-02-2001", "Ha Noi");          
      Film ew_film = new Film("Arcane", LocalDate.parse("2022-02-03"), 90, "Fiction", "Nguyen Thi Hieu");
      film_array.add(ew_film);
      Room ew_room = new Room("1", 12, 12);
      room_array.add(ew_room);
      Premiere ew_premiere = new Premiere(ew_film, ew_room, LocalDate.parse("2022-12-12"), "12:12");
      premiere_array.add(ew_premiere);    
      Film e_film = new Film("Soraka Pentakill", LocalDate.parse("2022-02-03"), 130, "Horror", "Bui Duy Linh");
      film_array.add(e_film);
      Room e_room = new Room("2", 13, 9);
      room_array.add(e_room);
      Premiere e_premiere = new Premiere(e_film, e_room, LocalDate.parse("2022-10-12"), "12:12");
      premiere_array.add(e_premiere);      
      
      do{         
        System.out.println("----------------Theater Management----------------");
        System.out.println("1. Manage Films");
        System.out.println("2. Manage Rooms");
        System.out.println("3. Manage Premieres"); 
        System.out.println("4. Book tickets");
        System.out.println("7. Log out of the world");
                
        boolean out = false;
        int choice = s.nextInt();
        
        switch (choice){
           case 1 -> {
               do {
                   System.out.println("--------Manage Films--------");
                   System.out.println("1. Add a film");
                   System.out.println("2. Edit a film");
                   System.out.println("3. Remove a film");
                   System.out.println("4. Show a film's infomation");
                   System.out.println("5. Show all films' name");
                   System.out.println("7. Return to main menu");
                   
                   choice = s.nextInt();
                   
                   switch (choice){
                       case 1 -> {
                           System.out.println("  ----Add a film----");                        
                           Film new_film = film_manager.add_item();
                           film_array.add(new_film);
                           
                       }
                       
                       case 2 -> {
                           System.out.println("  ----Edit a film----");
                           film_manager.edit_item(film_array);
                       }
                       
                       case 3 -> {
                           System.out.println("  ----Remove a film----");
                           film_manager.remove_item(film_array);
                       }
                       
                       case 4 -> {
                           System.out.println("  ----Show a film's infomation----");
                           film_manager.show_item_info(film_array);
                       }
                       
                       case 5 -> {
                           System.out.println("  ----Show all films' name----");
                           film_manager.show_all_items(film_array);
                       }
                       
                       case 7 -> out = true;
                   }
                   
               }while(!out);
              }

           case 2 -> {
               do{
                   System.out.println("--------Manage Rooms--------");
                   System.out.println("1. Add a new room");
                   System.out.println("2. Edit a room");
                   System.out.println("3. Remove a room");
                   System.out.println("4. Show a room's information");
                   System.out.println("5. Show all rooms");
                   System.out.println("7. Return to main menu");
                   
                   
                   choice = s.nextInt();
                   switch(choice){
                       
                       case 1:
                           System.out.println(" ----Add a new room----");
                           Room new_room = room_manager.add_item();
                           room_array.add(new_room);
                           break;
                           
                       case 2:
                           System.out.println("  ----Edit a room's information----");
                           room_manager.edit_item(room_array);
                           break;
                           
                       case 3:
                           System.out.println("  ----Remove a room----");
                           room_manager.remove_item(room_array);
                           break;
                           
                       case 4:
                           System.out.println("  ----Show a room's information");
                           room_manager.show_item_info(room_array);
                           break;
                           
                       case 5:
                           System.out.println("  ----Show all rooms----");
                           room_manager.show_all_items(room_array);
                           break;
                           
                       case 7:
                           out = true;
                           break;
                   }
                   
               }while(!out);
              }

           case 3 -> {
               do{
                   System.out.println("-----------Manage Premieres-----------");
                   System.out.println("1. Add a new premiere");
                   System.out.println("2. Edit a premiere");
                   System.out.println("3. Remove a premiere");
                   System.out.println("4. Show a premiere's information");
                   System.out.println("5. Show all premieres");
                   System.out.println("7. Return to main menu");
                          
                   choice = s.nextInt();
                   String Kassadin = s.nextLine();
                   switch(choice){
                       case 1 -> {
                           System.out.println(" ----Add a new premiere----");
                           Premiere new_premiere = premiere_manager.add_item();
                           premiere_array.add(new_premiere);
                       }
                       
                       case 2 -> {
                           System.out.println("  ----Edit premiere's information----");
                           premiere_manager.edit_item(premiere_array);
                       }
                       
                       case 3 -> {
                           System.out.println("  ----Remove a premiere----");
                           premiere_manager.remove_item(premiere_array);
                       }
                       
                       case 4 -> {
                           System.out.println("  ----Show a premirere's information");
                           premiere_manager.show_item_info(premiere_array);
                       }
                       
                       case 5 -> {
                           System.out.println("  ----Show all premieres----");
                           premiere_manager.show_all_items(premiere_array);
                       }
                       
                       case 7 -> out = true;
                   }
                   
               }while(!out);
              }
           
           case 4 ->{
               do{
                    System.out.println("-------Let's book a ticket---------");
                    System.out.println("1. Book a ticket");
                    System.out.println("2. Show all purchased tickets");
                    System.out.println("7. Return to the main menu");
                    choice = s.nextInt();

                    switch(choice){
                        case 1 ->{
                            user1.book_ticket(film_array, film_manager, premiere_manager, premiere_array);
                        }

                        case 2 ->{
                            user1.show_all_tickets();
                        }

                        case 7 -> out = true;
                   
                    }
                        
                }while(!out);
           }
           
           case 6 ->{        
               Film_data film_reporter = new Film_data();
               User user2 = new User("Kassadin", "110133215", "bhaf1101", "20-02-2001", "Void");               
               Film film = new Film("Interstella", LocalDate.parse("2022-02-03"), 130, "fiction", "Nguyen Thi Hieu");
               
               user1.register_film_feed(film_reporter);
               user2.register_film_feed(film_reporter);
               film_reporter.new_film_arrives(film);
               
               System.out.println("---------------------------------");          
               
               Film film2 = new Film("Yasuo and fiends", LocalDate.parse("2022-02-03"), 130, "fiction", "Riot");             
               user2.unregister_film_feed(film_reporter);        
               film_reporter.new_film_arrives(film2);
           }
               
           case 7 -> {
               System.out.println("See you again!!");
               System.exit(0);  
           }
        }
     
      }while(true);
    /*
      
    User user1 = new User("Heisenberg", "110133215", "bhaf1101", "20-02-2001", "Ha Noi");
    Admin admin1 = new Admin("Jesse", "110133211", "bhaf1109", "20-03-2001", "Ha Noi");
    user1.show_type_object();
    admin1.show_type_object();
    System.out.println(user1.get_id());
    System.out.println(user1.get_name());
    System.out.println(user1.get_phone_number());
    System.out.println(user1.get_region());
*/
    }
        
  
    
}
