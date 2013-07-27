package com.dynamicsignup;


public class User {
    
    //private variables
    String _id;
    String _pass;
    String _country;
    String _state;
    String _city;
    String _gender;
    String _email;
    String _name;
    String _phone_number;
    int sp1,sp2,sp3,sp4;
     
    // Empty constructor
    public User(){
         
    }
    // constructor
    public User(String id, String name, String _phone_number ,String _pass , String _gender , String _email , 
    		String _country , String _city , String _state , int sp1,int sp2,int sp3,int sp4){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this._pass=_pass;
        this._gender=_gender;
        this._email=_email;
        this._country=_country;
        this._city=_city;
        this._state=_state;
        this.sp1=sp1;
        this.sp2=sp2;
        this.sp3=sp3;
        this.sp4=sp4;
    }
    
    public int getsp4(){
        return this.sp4;
    }
     
    // setting name
    public void setsp4(int sp4){
        this.sp4 = sp4;
    }
    public int getsp1(){
        return this.sp1;
    }
     
    // setting name
    public void setsp1(int sp1){
        this.sp1 = sp1;
    }
    public int getsp2(){
        return this.sp2;
    }
     
    // setting name
    public void setsp2(int sp2){
        this.sp2 = sp2;
    }public int getsp3(){
        return this.sp3;
    }
     
    // setting name
    public void setsp3(int sp3){
        this.sp3 = sp3;
    }
    
    
    public User(String id,String name ,String phone){
    	this._id = id;
        this._name = name;
        this._phone_number = phone;
    }
    
 // getting name
    public String getGender(){
        return this._gender;
    }
     
    // setting name
    public void setGender(String gender){
        this._gender = gender;
    }
    
    public String getPass(){
        return this._pass;
    }
    
 // getting name
    public String getEmail(){
        return this._email;
    }
     
    // setting name
    public void setEmail(String email){
        this._email = email;
    }
    
 // getting name
    public String getCountry(){
        return this._country;
    }
     
    // setting name
    public void setCountry(String country){
        this._country = country;
    }
    
    
 // getting name
    public String getCity(){
        return this._city;
    }
     
    // setting name
    public void setCity(String city){
        this._city = city;
    }
    
 // getting name
    public String getState(){
        return this._state;
    }
     
    // setting name
    public void setState(String state){
        this._state = state;
    }
    
    
    // getting ID
    public String getID(){
        return this._id;
    }
     
    // setting id
    public void setID(String id){
        this._id = id;
    }
     
    // getting name
    public String getName(){
        return this._name;
    }
     
    // setting name
    public void setName(String name){
        this._name = name;
    }
     
    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }
     
    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
 
}