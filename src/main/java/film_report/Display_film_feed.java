/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package film_report;

import entities.Film;

/**
 *
 * @author HP
 */
public class Display_film_feed implements Observer, Display_element{
    
    private String film_name;
    private Subject film_data;
    
    public Display_film_feed(Subject in_film_data){
        this.film_data = in_film_data;
        this.film_data.register_observer(this);
    }

    @Override
    public void update(String film_name) {
        this.film_name = film_name;
        display();
    }

    @Override
    public void display() {
        System.out.println("Attention!! " + this.film_name +  " just arrived!!");
        
    }

    
    
}
