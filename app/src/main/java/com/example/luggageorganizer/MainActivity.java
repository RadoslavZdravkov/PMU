package com.example.luggageorganizer;

import static com.example.luggageorganizer.Constants.AppConstants.BASIC_NEEDS_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.CLOTHING_CAMEL_CASE;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luggageorganizer.Adapter.Adapter;
import com.example.luggageorganizer.Constants.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerView);

        addAllTitles();
        addAllImages();

        adapter = new Adapter(this, titles, images, MainActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if(mBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Tap back in order to exit", Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    private void addAllTitles(){
        titles = new ArrayList<>();
        titles.add(BASIC_NEEDS_CAMEL_CASE);
        titles.add(AppConstants.CLOTHING_CAMEL_CASE);
        titles.add(AppConstants.PERSONAL_CARE_CAMEL_CASE);
        titles.add(AppConstants.BABY_NEEDS_CAMEL_CASE);
        titles.add(AppConstants.HEALTH_CAMEL_CASE);
        titles.add(AppConstants.TECHNOLOGY_CAMEL_CASE);
        titles.add(AppConstants.FOOD_CAMEL_CASE);
        titles.add(AppConstants.BEACH_SUPPLIES_CAMEL_CASE);
        titles.add(AppConstants.CAR_SUPPLIES_CAMEL_CASE);
        titles.add(AppConstants.NEEDS_CAMEL_CASE);
        titles.add(AppConstants.MY_LIST_CAMEL_CASE);
        titles.add(AppConstants.MY_SELECTIONS);
    }

    private void addAllImages(){
        images = new ArrayList<>();
        images.add(R.drawable.p1);
        images.add(R.drawable.p2);
        images.add(R.drawable.p3);
        images.add(R.drawable.p4);
        images.add(R.drawable.p5);
        images.add(R.drawable.p6);
        images.add(R.drawable.p7);
        images.add(R.drawable.p8);
        images.add(R.drawable.p9);
        images.add(R.drawable.p10);
        images.add(R.drawable.p11);
        images.add(R.drawable.p12);
    }
}