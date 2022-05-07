package com.example.restauracja.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.restauracja.Activity.Domena.PopularDomain;
import com.example.restauracja.Activity.Helper.ManagementCart;
import com.example.restauracja.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private PopularDomain object;
    int numberOrder = 1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart= new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        String picUrl ="";

        titleTxt.setText(object.getTitle());
        String wypisz = object.getTitle();
        switch (wypisz){
            case "Peperoni pizza":{
                picUrl="pizza1";
                int drawableResourceId = this.getResources().getIdentifier(picUrl, "drawable", this.getPackageName());
                Glide.with(this)
                        .load(drawableResourceId)
                        .into(picFood);
                break;
            }

            case "Cheese Burger":{
                picUrl="burger2";
                int drawableResourceId = this.getResources().getIdentifier(picUrl, "drawable", this.getPackageName());
                Glide.with(this)
                        .load(drawableResourceId)
                        .into(picFood);
                break;
            }

            case "Wegetarianska pizza":{
                picUrl="pizza2";
                int drawableResourceId = this.getResources().getIdentifier(picUrl, "drawable", this.getPackageName());
                Glide.with(this)
                        .load(drawableResourceId)
                        .into(picFood);
                break;
            }
        }
        feeTxt.setText("PLN " + object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picfood);
    }
}