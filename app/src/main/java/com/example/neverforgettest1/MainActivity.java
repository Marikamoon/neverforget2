package com.example.neverforgettest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.room.Room;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.*;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;



public class MainActivity extends AppCompatActivity {

    private EditText bName ;
    String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DATA INPUT FROM USER///////////////////////////////////////



        //DATABASE BUILDER///////////////////////////////////////////
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        User jasmine1 = new User("jasmine1");
        //CLICK LISTENER--MONTH/////////////////////////////////////
            Button monthEdit = (Button) findViewById(R.id.MonthDayEdit);
            monthEdit.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    collection.setValues(0,11,monthArray);
                        DialogFragment newFragment = new dialog();

                        newFragment.show(getSupportFragmentManager(), "game");
                }
            }));
        //CLICK LISTENER--DAY/////////////////////////////////////
        Button dayEdit = (Button) findViewById(R.id.dayEdit);
        dayEdit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collection.setValues(0,31);
                DialogFragment newFragment = new dialog();
                newFragment.show(getSupportFragmentManager(), "day");
            }
        }));
        //CLICK LISTENER--YEAR/////////////////////////////////////
        Button yearEdit = (Button) findViewById(R.id.YearEdit);
        yearEdit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new dialog();
                newFragment.show(getSupportFragmentManager(), "game");
            }
        }));
        //CLICK LISTENER--TIMEZONE///////////////////////////////////
        Button timeZoneEdit = (Button) findViewById(R.id.TimeZoneText);
        timeZoneEdit.setOnClickListener((new View.OnClickListener(){
            public void onClick(View v) {
                Intent timeZoneIntent = new Intent(MainActivity.this, TimePicker.class);
                startActivity(timeZoneIntent);

            }
        }));


        //CLICKER///////////////////////////////////////////////////
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        //INSERT TO DATABASE////////////////////////////////////////
            // Completable.fromCallable(() ->
        db.userDao().insertAll(jasmine1)
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onComplete() {Toast myToast = Toast.makeText(getApplicationContext(),  "successs", Toast.LENGTH_SHORT);
                        myToast.show();}
                    @Override
                    public void onError(Throwable e) {}
                });
        /*/GET DATA FROM DATABASE/////////////////////////////////////
                db.userDao().getAll()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<User>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Toast myToast = Toast.makeText(getApplicationContext(),  "fail", Toast.LENGTH_SHORT);
                                myToast.show();
                            }

                            @Override
                            public void onSuccess(List<User> users) {
                                Toast myToast = Toast.makeText(getApplicationContext(),  "test2", Toast.LENGTH_SHORT);
                                myToast.show();
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast myToast = Toast.makeText(getApplicationContext(),  "failed", Toast.LENGTH_SHORT);
                                myToast.show();

                            }
                        });*/



            }
        });








        //DATABASE//////////////////////////////////////////////////





    }


}