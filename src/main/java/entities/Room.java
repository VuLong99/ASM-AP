/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import toolpackage.Tools;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Room {
    private String id;
    private String name;
    private int num_seat;
    private int num_seat_row;
    private int num_seat_column;
    List<String> seat_list = new ArrayList<>();
    
    public Room(String input_name, int in_num_seat_row, int in_num_seat_column){
        id = Tools.generate_id("R");
        name = input_name;
        this.num_seat_row = in_num_seat_row;
        this.num_seat_column = in_num_seat_column;        
        num_seat = in_num_seat_row * in_num_seat_column;
        this.seat_list = this.add_seat();
    }
    
    public String get_id(){
        return this.id;
    }
    
    public void set_id(String new_id){
        this.id = new_id;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public void set_name(String new_name){
        this.name = new_name;
    }
    
    public int get_num_seat(){
        return this.num_seat;
    }
    
    public void set_num_seat(String num_seat){
        this.num_seat = Integer.parseInt(num_seat);
    }
    
    public void set_num_seat(int num_seat){
        this.num_seat = num_seat;
    }
    
    public int get_num_seat_row(){
        return this.num_seat_row;
    }
    
    public int get_num_seat_column(){
        return this.num_seat_column;
    }    
    
    public List get_seat_list(){
        return this.seat_list;
    }
    
    private List add_seat(){
        String cha = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        String seat_name;
        List<String> seat_list = new ArrayList<>();
        
        for (int i = 0; i < this.num_seat_row; ++i){
            char char_row = cha.charAt(i);
            
            for (int col = 0; col < this.num_seat_column; ++col){
                seat_name = char_row + Integer.toString(col);              
                seat_list.add(seat_name);
            }
        }
        return seat_list;
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

    public String get_num_row_seats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String get_num_column_seats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void set_num_row_seats(String new_num_row_seats) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
