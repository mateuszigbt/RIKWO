package com.example.restauracja.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.restauracja.Activity.Adapter.KategoriaAdapter;
import com.example.restauracja.Activity.Adapter.PopularAdapter;
import com.example.restauracja.Activity.Domena.Kategoria;
import com.example.restauracja.Activity.Domena.PopularDomain;
import com.example.restauracja.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategroyList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewCategory()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategroyList= findViewById(R.id.recyclerView1);
        recyclerViewCategroyList.setLayoutManager(linearLayoutManager);

        ArrayList<Kategoria> kategoriaArrayList = new ArrayList<>();
        kategoriaArrayList.add(new Kategoria("Pizza", "pizza"));
        kategoriaArrayList.add(new Kategoria("Burger", "burger"));
        kategoriaArrayList.add(new Kategoria("Hotdog", "hotdog"));
        kategoriaArrayList.add(new Kategoria("Napoj", "napoj"));
        kategoriaArrayList.add(new Kategoria("Paczek", "paczek"));

        adapter=new KategoriaAdapter(kategoriaArrayList);
        recyclerViewCategroyList.setAdapter(adapter);
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PopularDomain> foodList = new ArrayList<>();
        foodList.add(new PopularDomain("Peperoni pizza", "pizza1.png", "plastry peperoni, ser, swierze oregano, czerwona papryka, pomidorowy sos", 50.29));
        foodList.add(new PopularDomain("Cheese Burger", "burger.png", "mieso, ser gouda, burger sos, pomidory, papryka", 25.22));
        foodList.add(new PopularDomain("Wegetarianska pizza", "pizza2.png", "ser mozzarella, oregano, salata, papryka zolta, pomidorowy sos, rukola", 40.62));

        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}