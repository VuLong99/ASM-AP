/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package film_report;

import entities.Film;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Film_data implements Subject{
    private ArrayList<Observer> observer_array;
    private Film film;
    
    public Film_data(){
        observer_array = new ArrayList<Observer>();
    }

    @Override
    public void register_observer(Observer observer) {
        observer_array.add(observer);
    }

    @Override
    public void remove_observer(Observer observer) {
        
        int i = observer_array.indexOf(observer);
        if ( i >= 0){
            observer_array.remove(i);
        }
        else{
            System.out.println("SOS!! no observer cares anymore.");
        }
    }

    @Override
    public void notify_observers() {
        
        for (Observer observer : observer_array){
            observer.update(this.film.get_name());
        }
    }
    
    public void new_film_arrives(Film film){
        this.film = film;
        notify_observers();
    }
}
