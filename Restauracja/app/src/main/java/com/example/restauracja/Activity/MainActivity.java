package com.example.restauracja.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.restauracja.Activity.Domena.Kategoria;
import com.example.restauracja.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategroyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void recyclerViewCategory()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategroyList=findViewById(R.id.recyclerView3);
        recyclerViewCategroyList.setLayoutManager(linearLayoutManager);

        ArrayList<Kategoria> kategoriaArrayList = new ArrayList<>();
        kategoriaArrayList.add(new Kategoria("Pizza", "kat_1"));
        kategoriaArrayList.add(new Kategoria("Burger", "kat_2"));
        kategoriaArrayList.add(new Kategoria("Hotdog", "kat_3"));
        kategoriaArrayList.add(new Kategoria("Napoj", "kat_4"));
        kategoriaArrayList.add(new Kategoria("Paczek", "kat_5"));
    }
}