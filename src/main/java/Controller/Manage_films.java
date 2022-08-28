/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Film;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import toolpackage.Tools;
/**
 *
 * @author HP
 */
public class Manage_films implements Action<Film>{

    @Override
    public Film add_item() {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Film name:");
        String film_name = s.nextLine();
        
        LocalDate date_of_release= Tools.set_date();
        
        int duration = this.set_duration();
           
        System.out.println("genre:");
        String genre = s.nextLine();
        
        System.out.println("director:");
        String dicrector = s.nextLine();
        
        Film film  = new Film(film_name, date_of_release, duration, genre, dicrector);
        
        return film;
    }

    @Override
    public boolean remove_item(ArrayList<Film> film_array) {
        
        int idx = this.search_idx_item(film_array);
        if (idx >= 0){
            String film_name = film_array.get(idx).get_name();
            film_array.remove(idx);
            System.out.println("Congratulation!, we just successfully removed " + film_name + " from our database.");
            return true;
            }
        
        else{
           return false;
        }
    }

    @Override
    public boolean edit_item(ArrayList<Film> film_array) {
        
        Scanner s = new Scanner(System.in);
        int idx = this.search_idx_item(film_array);
        if (idx >= 0){
            boolean out = false;
            do{
                System.out.println("To change an atrribute click the number associated with the attribute");
                this.show_item_info(film_array.get(idx));
                System.out.println("7. Enter 7 to cancel: ");
                
                int choice = s.nextInt();
                s = new Scanner(System.in);
                switch (choice){
                    case 1:
                        System.out.println("Please, type a new id:");
                        String new_id = s.nextLine();
                        film_array.get(idx).set_id(new_id);
                        break;
                        
                    case 2:
                        System.out.println("Type a new name:");
                        
                        String new_name = s.nextLine();
                        film_array.get(idx).set_name(new_name);
                        break;
                        
                    case 3:
                        LocalDate new_date;
                        new_date = Tools.set_date();
                        film_array.get(idx).set_date_of_release(new_date);
                        break;
                        
                    case 4:                       
                        int new_duration = this.set_duration();
                        film_array.get(idx).set_duration(new_duration);
                        break;
                        
                    case 5:
                        System.out.println("Type a new genre:");
                        String new_genre = s.nextLine();
                        film_array.get(idx).set_genre(new_genre);
                        break;
                        
                    case 6:
                        System.out.println("Type a new director:");
                        String new_director = s.nextLine();
                        film_array.get(idx).set_director(new_director);
                        break;
                        
                    case 7:
                        out = true;
                }
            
            }while(!out);
            
            return true;
        }
              
        else{
            return false;
        }
    }

    @Override
    public boolean show_item_info(ArrayList<Film> film_array) {
        
        int idx = this.search_idx_item(film_array);
        if (idx >= 0){
            Film film = film_array.get(idx);
            if (film instanceof Film){
                System.out.println("1. id: " + film.get_id());
                System.out.println("2. name: " + film.get_name());
                System.out.println("3. date of release: " + film.get_date_of_release());
                System.out.println("4. duration: " + film.get_duration());
                System.out.println("5. genre: " + film.get_genre());
                System.out.println("6. director: " + film.get_director());
                System.out.println();
            }
            return true;
        }
        
        else{
            return false;
        }
    }
    
    public void show_item_info(Film film) {
      
        System.out.println("1. id: " + film.get_id());
        System.out.println("2. name: " + film.get_name());
        System.out.println("3. date of release: " + film.get_date_of_release());
        System.out.println("4. duration: " + film.get_duration());
        System.out.println("5. genre: " + film.get_genre());
        System.out.println("6. director: " + film.get_director());
        System.out.println();
    }

    @Override
    public int search_idx_item(ArrayList<Film> film_array) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("type the name of the film");
        String name = s.nextLine();
        
        int idx = -1;
        for (Film film : film_array){
            ++idx;
            if (name.equals(film.get_name())){
                return idx;
            }       
        }
        System.out.println("Oops!, This name doesn't belong to any film inside the database.");
        return -1;
    }

    @Override
    public void show_all_items(ArrayList<Film> film_array) {
        
        if (!film_array.isEmpty()){
            int c = 0;
            for (Film film : film_array){
                c++;
                System.out.println(Integer.toString(c) + ". " + film.get_name());
            }
        }
        else{
            System.out.println("We already ran out of films");
        }
    }  
  
    public int set_duration(){
        
        Scanner s = new Scanner(System.in);
        int duration;
        while(true){
            System.out.println("Type duration in minute, please.");
            duration = s.nextInt();
            if (0 < duration && duration < 240){
                break;
            }
            else{
                System.out.println("Duration must be greater than 0 and less than 240 minutes.");
            }
        }
        return duration;
    }

    @Override
    public Film search_item(ArrayList<Film> film_array) {
        
        while(true){
            int idx = this.search_idx_item(film_array);
            if (idx >= 0){
                return film_array.get(idx);
            }           
        }      
    }
}
