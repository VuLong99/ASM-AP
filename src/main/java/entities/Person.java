package entities;


import toolpackage.Tools;

abstract class Person {
    protected String name;
    protected String phone_number;
    protected String email;
    protected String date_of_birth;
    protected String region;
    
    public Person(String Name, String p_number, String Email, 
            String Date_of_birth, String Region){
        
        name = Name;
        phone_number = p_number;
        email = Email;
        date_of_birth = Date_of_birth;
        region = Region;        
    }

    public String get_id(){
        return name;
    }
    public String get_name(){
        return this.name;
    }
    
    public String get_email(){
        return this.email;
    }
    
    public String get_phone_number(){
        return this.phone_number;
    }
    
    public String get_date_of_birth(){
        return this.date_of_birth;
    }
    
    public String get_region(){
        return this.region;
    }
    
}
