package com.example.snikdha.database;

public class ObjectForEmployee {
    String Name;
    String Phone;
    String Age;

    public ObjectForEmployee(String name, String phone, String age) {
        Name = name;
        Phone = phone;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
