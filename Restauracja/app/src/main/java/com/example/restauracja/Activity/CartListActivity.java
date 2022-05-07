package com.example.restauracja.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.restauracja.Activity.Adapter.CartListAdapter;
import com.example.restauracja.Activity.Helper.ManagementCart;
import com.example.restauracja.Activity.Interface.ChangeNumberItemsListener;
import com.example.restauracja.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;

    TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart= new ManagementCart(this);
        initView();
        initList();
        CalculatorCart();
        bottomNavigation();
    }

    private void bottomNavigation(){
        Button btn = (Button) findViewById(R.id.cartBtn);
        //@SuppressLint("WrongViewCast") LinearLayout homeBtn= findViewById(R.id.homeBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this, CartListActivity.class));
            }
        });

        //homeBtn.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(new Intent(CartListActivity.this, MainActivity.class));
        //    }
        //});

        }



    private void initView()
    {
        recyclerViewList= findViewById(R.id.cartView);
        totalFeeTxt= findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView3);

    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculatorCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty())
        {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }
        else
        {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }

    private void CalculatorCart(){
        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round((managementCart.getTotalFee()*percentTax) * 100)/100;
        double total = Math.round((managementCart.getTotalFee() + tax) * 100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee()*100)/100;
        totalFeeTxt.setText("PLN" + itemTotal);
        taxTxt.setText("PLN" + delivery);
        totalTxt.setText("PLN"+ total);
    }

}