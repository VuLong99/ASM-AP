/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Room;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Manage_rooms implements Action<Room> {
    
    
    @Override
    public Room add_item() {
        Scanner s = new Scanner(System.in);
        System.out.println("Room name: ");
        String name = s.nextLine();
        int num_row_seats;
        int num_column_seats;
        
        while(true){
            System.out.println("The number of rows:");
            num_row_seats = s.nextInt();
            if (num_row_seats < 26){
                break;
            }       
            else{
                System.out.println(" The number of rows must be less than 26.");
            }
        };
        
        while(true){
            System.out.println("The number of columns:");
            num_column_seats = s.nextInt();
            if (num_column_seats < 21){
                break;
            }
            else{
                System.out.println(" The number of columns must be less than 21.");
            }
        }
        Room room = new Room(name, num_row_seats, num_column_seats);
        
        return room;
    }

    @Override
    public boolean remove_item(ArrayList<Room> room_array) {
        
        int idx = this.search_idx_item(room_array);
        if (idx >= 0){
            String room_name = room_array.get(idx).get_name();
            room_array.remove(idx);
            System.out.println("Congratulation!, we just successfully removed room" + room_name + " from our database.");
            return true;
        }
        return false;
    }

    @Override
    public boolean edit_item(ArrayList<Room> room_array) {
        Scanner s = new Scanner(System.in);
        int idx = this.search_idx_item(room_array);
        if (idx >= 0){
            boolean out = false;
            
            do{
                System.out.println("To change an atrribute click the number associated with the attribute");
                System.out.println("1. id: " + room_array.get(idx).get_id());
                System.out.println("2. name: " + room_array.get(idx).get_name());
                System.out.println("7. Enter 7 to cancel: ");
                
                int choice = s.nextInt();
                String La_La_la = s.nextLine();
                
                switch(choice){
                    case 1 -> {
                        System.out.println("Type a new id:");
                        String new_id = s.nextLine();
                        room_array.get(idx).set_id(new_id);
                    }
                        
                    case 2 -> {
                        System.out.println("Type a new name: ");
                        String new_name = s.nextLine();
                        room_array.get(idx).set_name(new_name);
                    }
                  
                    case 7 -> out = true;
                }
            }while(!out);
            
            return true;
        }
        return false;
    }

    @Override
    public boolean show_item_info(ArrayList<Room> room_array) {
        
        int idx = this.search_idx_item(room_array);
        if (idx >= 0){
            Room room = room_array.get(idx);
            System.out.println("1. id: " + room.get_id());
            System.out.println("2. name: " + room.get_name());
            System.out.println("3. the number of seats " + room.get_num_seat());
            System.out.println();
            return true;
        }
        
        return false;
    }
    
    @Override
    public void show_item_info(Room room) {
        System.out.println("1. id: " + room.get_id());
        System.out.println("2. name: " + room.get_name());
        System.out.println("3. the number of seats " + room.get_num_seat());
    }

    @Override
    public void show_all_items(ArrayList<Room> room_array) {
        
        int c = 0;
        if (!room_array.isEmpty()){
            for (Room room : room_array){
                c++;
                System.out.println(Integer.toString(c) + ". " + room.get_name());    
            }
        }
        else{
            System.out.println("Je, We already ran out of rooms.");
        }
    }

    @Override
    public int search_idx_item(ArrayList<Room> room_array) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Type the name of the room:");
        String name = s.nextLine();
        int idx = -1;
        for (Room room : room_array){
            idx++;
            if (name.equals(room.get_name())){
                return idx;
            }
        }
        System.out.println("Oops!, This name doesn't belong to any room inside our big database.");
        return -1;
    }

    @Override
    public Room search_item(ArrayList<Room> room_array) {
        
        while(true){
            int idx = this.search_idx_item(room_array);
            if (idx >= 0){
                return room_array.get(idx);
            }
        }
    }
    
    

}
