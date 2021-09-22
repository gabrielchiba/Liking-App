package com.example.likingapp.models;

//import se.emilsjolander.sprinkles.Model;
//import se.emilsjolander.sprinkles.annotations.AutoIncrement;
//import se.emilsjolander.sprinkles.annotations.Column;
//import se.emilsjolander.sprinkles.annotations.Key;
//import se.emilsjolander.sprinkles.annotations.Table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "person")
public class Person {

    @Id(autoincrement = true)
    public long id;

    @Property(nameInDb = "user_id")
    public long user_id;

    @Property(nameInDb = "name")
    public String name;

    @Property(nameInDb = "last_name")
    public String lastName;

    @Property(nameInDb = "birthday")
    public String birthday;

    @Property(nameInDb = "phone")
    public String phone;

    @Property(nameInDb = "cpf")
    public String cpf;

    @Property(nameInDb = "email")
    public String email;

    @Generated(hash = 1928401715)
    public Person(long id, long user_id, String name, String lastName,
            String birthday, String phone, String cpf, String email) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phone = phone;
        this.cpf = cpf;
        this.email = email;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
