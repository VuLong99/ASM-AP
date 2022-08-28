/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolpackage;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;
/**
 *
 * @author HP
 */
public class Tools {
    static Random randNum = new Random();
    
    public static String generate_id(String type_id){
        String full_id = type_id + "-";
        StringJoiner g_id = new StringJoiner("");
        
        for (int i = 0; i < 3; i++){ 
            g_id.add("" + "abcdefghijklmnopqrstuvwxyz".toCharArray()[randNum.nextInt("abcdefghijklmnopqrstuvwxyz".toCharArray().length)]);
        }
        
        Random random = new Random();  
        for (int i = 0; i < 3; i++){
            int x = random.nextInt(10);   
            g_id.add(Integer.toString(x));
        }
        
        full_id += g_id;
       
        return full_id;
    }
    
    public static int[] str_to_arrint(String str_time){
        String[] hour_minute = str_time.split(":");
        
        int[] hour_minute_int = {0,1};
        for (int i = 0; i < hour_minute.length; ++i){
            hour_minute_int[i] =  Integer.parseInt(hour_minute[i]);
        }
        
        return hour_minute_int;
    }
    
    public static String int_to_arrstr(int[] int_time){
        String hour_minute = "";
        
        for (int i = 0; i < int_time.length; ++i){
            if (int_time[i] < 10){
                String unit = "0" + Integer.toString(int_time[i]);
                hour_minute += unit ;
            }
            else{
            hour_minute = hour_minute + Integer.toString(int_time[i]);
            }
            
            if(i==0){
                hour_minute += ":";
            }
        }
        
        return hour_minute;
    }
    
    public static String calculate_endtime(int run_time, String str_hour_minute){
        int[] hour_minute = str_to_arrint(str_hour_minute);      
        
        for (int i = run_time; i > 0; --i){
            hour_minute[1]++;
            if (hour_minute[1] == 60){
                hour_minute[1] = 0;
                hour_minute[0]++;
                if (hour_minute[0] == 24){
                    hour_minute[0] = 0;
                }
            }   
        }
        
        String endtime = int_to_arrstr(hour_minute);
        return endtime;
    }
    
    public static String format_timedata(String in_time){
        int[] hour_time_arr = str_to_arrint(in_time);
        String hour_time_str = int_to_arrstr(hour_time_arr);
        
        return hour_time_str;
    }
    
    public static String format_datedata(String str_date){
        String[] str_split = str_date.split("-");
        String repaired_str_date = "";
        for (int i = 0; i < 3; ++i){
            String str_num = str_split[i];
            int num = Integer.parseInt(str_num);
            if (num < 10){
                str_num = "0" + Integer.toString(num);
                str_split[i] = str_num;
            }
        }
        repaired_str_date = String.join("-", str_split);
        
        return repaired_str_date;
    }
    
    public static LocalDate set_date(){
        
        Scanner s = new Scanner(System.in);
        LocalDate date;
        while(true){
            try{
                System.out.println("Date of release:");
                System.out.println("Type day:");
                String day = s.nextLine();
                System.out.println("Type month:");
                String month = s.nextLine();
                System.out.println("Type year:");
                String year = s.nextLine();
                String str_date_of_release = year + "-" + month + "-" + day;               
                date = LocalDate.parse(Tools.format_datedata(str_date_of_release));
            }
            catch(Exception e){
                System.out.println("SOS!!!, the typed date format is goddam wrong, or there is no such a date in Gregorian calendar.");
                System.out.println();
                continue;
            }
            break;
        }
        return date;
    }
}
