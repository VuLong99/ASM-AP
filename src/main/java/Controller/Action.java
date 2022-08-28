/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author HP
 * @param <T>
 */
public interface Action<T> {
    public T add_item();
    
    public boolean remove_item(ArrayList<T> item_array);
    
    public boolean edit_item(ArrayList<T> item_array);
    
    public boolean show_item_info(ArrayList<T> item_array);
    
    public void show_item_info(T item);
    
    public void show_all_items(ArrayList<T> item_array);
    
    public int search_idx_item(ArrayList<T> item_array);
    
    public T search_item(ArrayList<T> item_array);
      
}
