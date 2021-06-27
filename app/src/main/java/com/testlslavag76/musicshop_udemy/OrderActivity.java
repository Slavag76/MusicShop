package com.testlslavag76.musicshop_udemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView numbersList;
    private NumbersRecycleViewAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = receivedOrderIntent.getStringExtra("goodsName");
        int quantity = receivedOrderIntent.getIntExtra("quantity", 0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice", 0);

        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText(userName + "\n" + goodsName + "\n" + quantity + "\n" + orderPrice);

        //*********Реализуем RecycleView в открывающейся новой активити
        numbersList = findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numbersList.setLayoutManager(layoutManager);
        numbersList.setHasFixedSize(true);

        //**********Создаем адаптер и передаем ему список из 100 элементов*******
        numbersAdapter = new NumbersRecycleViewAdapter(100);
        numbersList.setAdapter(numbersAdapter);

    }
}