/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package film_report;

/**
 *
 * @author HP
 */
public interface Subject {
    
    public void register_observer(Observer observer);
    
    public void remove_observer(Observer observer);
    
    public void notify_observers();
}
