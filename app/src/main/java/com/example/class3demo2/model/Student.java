package com.example.class3demo2.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey
    @NonNull
    public String id="";
    public String name="";
    public String birthday="";
    public String time="";
    public String avatarUrl="";
    public Boolean cb=false;

    public Student(){
    }
    public Student( String id,String name, String birthday, String time, String avatarUrl, Boolean cb) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
        this.time = time;
        this.avatarUrl = avatarUrl;
        this.cb = cb;

    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getTime() {
        return time;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Boolean getCb() {
        return cb;
    }
}
