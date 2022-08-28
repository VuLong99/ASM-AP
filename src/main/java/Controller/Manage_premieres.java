/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Film;
import entities.Premiere;
import entities.Room;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import toolpackage.Tools;

/**
 *
 * @author HP
 */
public class Manage_premieres implements Action<Premiere> {
    
    Scanner s = new Scanner(System.in);
    private ArrayList<Film> film_array;
    private Manage_films film_manager;
    private ArrayList<Room> room_array;
    private Manage_rooms room_manager;
    
    public Manage_premieres(ArrayList<Film> in_film_array, Manage_films in_film_manager, 
            ArrayList<Room> in_room_array, Manage_rooms in_room_manager){
        this.film_array = in_film_array; 
        this.film_manager = in_film_manager;
        this.room_array = in_room_array;
        this.room_manager = in_room_manager;
    }
    
    @Override
    public Premiere add_item() {
        System.out.println("Type a film's name to choose a film for this premiere: ");
        film_manager.show_all_items(film_array);
        Film film = film_manager.search_item(film_array);
        
        System.out.println("Type a room's name to choose a room for this premiere");
        room_manager.show_all_items(room_array);
        Room room = room_manager.search_item(room_array);
        
        LocalDate release_date = Tools.set_date();
        
        String start_time = this.input_start_time();
        
        Premiere premiere = new Premiere(film, room, release_date, start_time);
        
        return premiere;
    }
    
    
    @Override
    public boolean remove_item(ArrayList<Premiere> premiere_array) {
        
        int idx = this.search_idx_item(premiere_array);
        if (idx >= 0){
            premiere_array.remove(idx);
            System.out.println("Congratulation!, we just successfully delete this premiere from our database.");
            return true;
        }
        return false;
    }
    
    @Override
    public boolean edit_item(ArrayList<Premiere> premiere_array){
        
        int idx = this.search_idx_item(premiere_array);
        if (idx >= 0){
            boolean out = false;
                    
            do{
                System.out.println("To change an atrribute click the number associated with the attribute");
                this.show_item_info(premiere_array.get(idx));
                System.out.println("7. Enter 7 to cancel: ");
                
                int choice = s.nextInt();               
                String Nasus = s.nextLine();
                
                switch(choice){
                    case 1:
                        System.out.println("Type a film's name to choose a film for this premiere: ");
                        film_manager.show_all_items(film_array);
                        Film film = film_manager.search_item(film_array);
                        premiere_array.get(idx).set_film(film);
                        break;
                    
                    case 2:
                        System.out.println("Type a room's name to choose a room for this premiere");
                        room_manager.show_all_items(room_array);
                        Room room = room_manager.search_item(room_array);
                        premiere_array.get(idx).set_room(room);
                        break;
                        
                    case 3:
                        LocalDate new_release_date = Tools.set_date();
                        premiere_array.get(idx).set_date(new_release_date);
                        break;
                        
                    case 4:
                        String new_start_time = this.input_start_time();
                        premiere_array.get(idx).set_start_time(new_start_time);
                        break;
                        
                    case 7:
                        out = true;
                        break;
                }                          
            }while(!out);
            
            return true;
        }
        return false;
    }

    @Override
    public boolean show_item_info(ArrayList<Premiere> premiere_array) {
        
        int idx = this.search_idx_item(premiere_array);
        if (idx >= 0){
            Premiere premiere = premiere_array.get(idx);
            System.out.println("  -----Premiere's information-----");
            System.out.println("Film name: " + premiere.get_film_name());
            System.out.println("Room name: " + premiere.get_room_name());
            System.out.println("Release date: " + premiere.get_date());
            System.out.println("Start time: " + premiere.get_start_time());
            System.out.println("End time: " + premiere.get_endtime());
            System.out.println("The number of seats: " + Integer.toString(premiere.get_num_seat()));
            
            return true;
        }
        return false;
    }

    @Override
    public void show_item_info(Premiere premiere) {
        System.out.println("  -----Premiere's information-----");
        System.out.println("1. Film name: " + premiere.get_film_name());
        System.out.println("2. Room name: " + premiere.get_room_name());
        System.out.println("3. Release date: " + premiere.get_date());
        System.out.println("4. Start time: " + premiere.get_start_time());
        System.out.println("5. End time: " + premiere.get_endtime());
        System.out.println("6. The number of seats: " + Integer.toString(premiere.get_num_seat()));
        System.out.println();
    }

    @Override
    public void show_all_items(ArrayList<Premiere> premiere_array) {
        
        int c = 0;
        for (Premiere premiere : premiere_array){
            
            c++;
            System.out.print(Integer.toString(c) + ".");
            show_item_info(premiere);        
        }
    }

    @Override
    public int search_idx_item(ArrayList<Premiere> premiere_array) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Type the premiere's film's name: ");
        
        String film_name = s.nextLine();
                       
        System.out.println("Type the premiere's room's name: ");
        String room_name = s.nextLine();
        
        String start_time = this.input_start_time();
        
        int idx = -1;
        for (Premiere premiere : premiere_array){
            ++idx;
            if (film_name.equals(premiere.get_film_name()) 
                && room_name.equals(premiere.get_room_name())
                && start_time.equals(premiere.get_start_time())){
              
                return idx;
            }
        }
        System.out.println("Oops!, These collective attributes don't belong to any premiere inside our big database.");

        return -1;
    }

    @Override
    public Premiere search_item(ArrayList<Premiere> premiere_array) {
        
        while(true){
            int idx = this.search_idx_item(premiere_array);
            if (idx >= 0){
                return premiere_array.get(idx);
            }
        }
    }
    
    public String input_start_time(){
        
        System.out.println("Type the premiere's start time:");
        int hour;
        while(true){
            System.out.println("Type hour: ");
            hour = s.nextInt();
            if (0 <= hour && hour < 24){
                break;
            }
        }
        
        int minute;
        while(true){
            System.out.println("Type minute: ");
            minute = s.nextInt();
            if (0 <= minute && minute < 60){
                break;
            }
        }
        
        String start_time = Integer.toString(hour) + ":" + Integer.toString(minute);
        
        return start_time;
    }
    
    
    public Premiere search_premiere_by_film_name(ArrayList<Premiere> premiere_array){
        
        Scanner s = new Scanner(System.in);
        ArrayList<Premiere> selected_premieres = new ArrayList<>();
        while (true){
            System.out.println("Type the name of the film: ");
            String film_name = s.nextLine();
            int c = -1;
            for (Premiere premiere : premiere_array){
                if (film_name.equals(premiere.get_film_name())){
                    c++;
                    selected_premieres.add(premiere);
                    System.out.println(Integer.toString(c) + ". " + premiere.get_date() + ", " + premiere.get_start_time() + " ~ " + premiere.get_endtime());
                }
            }
            if (selected_premieres.isEmpty()){
                System.out.println("The film's is not correct.");
            }
            else{
                break;
            }
        }
        System.out.println("Type the index associated with the premiere to choose: ");
        int idx = s.nextInt();        
        return selected_premieres.get(idx);
    }
    
}
