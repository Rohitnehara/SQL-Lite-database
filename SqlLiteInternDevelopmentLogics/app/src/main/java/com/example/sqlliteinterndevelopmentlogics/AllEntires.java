package com.example.sqlliteinterndevelopmentlogics;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlliteinterndevelopmentlogics.adaptor.myadapter;
import com.example.sqlliteinterndevelopmentlogics.model.details;

import java.util.ArrayList;

public class AllEntires extends AppCompatActivity
{

    RecyclerView recyclerView;
    ArrayList<details> dataholder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_entries);
        recyclerView=(RecyclerView)findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new HelpSqlLite(this).getAllData();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            details obj=new details(cursor.getString(1),cursor.getString(2));
            dataholder.add(obj);
        }

        myadapter adapter=new myadapter(dataholder);
        recyclerView.setAdapter(adapter);

    }
}