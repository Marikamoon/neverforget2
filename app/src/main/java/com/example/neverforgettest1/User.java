package com.example.neverforgettest1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;


    @ColumnInfo(name = "Name")
    public String bName;
    @ColumnInfo(name = "Birthday")
    public String birthday; //YYYY-MM-DD HH:MM:SS
    @ColumnInfo(name = "Timezone")
    public String timeZone; //"Vancouver/Canada"
    @ColumnInfo(name = "SetAlarm")
    public String setAlarm; //{-56mins,+78mins}//Store in array with mins
    @ColumnInfo(name = "SetNotification")
    public String setNotification; //Same As setNotification
    @ColumnInfo(name = "SetAlarmSound")
    public String setAlarmSound; //"neon"
    @ColumnInfo(name = "Snooze")
    public int snooze; //Min
    @ColumnInfo(name = "Lebel")
    public String label; //{family,friend,enemy}
    @ColumnInfo(name = "Note")
    public String note ;

    public User(String bName) {
        this.bName = bName;

    }

}