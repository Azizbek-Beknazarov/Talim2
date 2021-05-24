package com.example.talim.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Adapter.Reklama_Adapter;
import com.example.talim.Model.ReklamaData;
import com.example.talim.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ReklamaActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Reklama_Adapter adapter;
    List<ReklamaData> reklamaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_reklama);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.yangilar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.obunalar: {
                        startActivity(new Intent(getApplicationContext(), ObunalarActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    }
                    case R.id.university: {
                        startActivity(new Intent(getApplicationContext(), OliygohlarActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    }
                    case R.id.yangilar: {

                        return true;
                    }

                    case R.id.menyu: {
                        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    }
                }
                return true;
            }
        });

        reklamaData = new ArrayList<>();
        reklamaData.add(new ReklamaData("Matematika", "Shaxzod", R.drawable.math));
        reklamaData.add(new ReklamaData("Fizika", "Murod", R.drawable.fizika));
        reklamaData.add(new ReklamaData("Kimyo", "Javohir", R.drawable.kimyo));
        reklamaData.add(new ReklamaData("Biologiya", "Malika", R.drawable.biologiya));
        reklamaData.add(new ReklamaData("Astronomiya", "Abror", R.drawable.astronomiya));
        reklamaData.add(new ReklamaData("Geografiya", "Ozoda", R.drawable.geo));
        reklamaData.add(new ReklamaData("Tarix", "Otabek", R.drawable.terix));
        reklamaData.add(new ReklamaData("O‘zbek tili va adabiyoti", "Mahliyo", R.drawable.ona));
//        reklamaData.add(new ReklamaData("Ingliz tili", "Nilufar", R.drawable.b226));
//        reklamaData.add(new ReklamaData("Nemis tili", "Nargiza", R.drawable.b227));
//        reklamaData.add(new ReklamaData("Informatika", "Alisher", R.drawable.b239));
//        reklamaData.add(new ReklamaData("Matematika", "Shaxzod", R.drawable.b198));
//        reklamaData.add(new ReklamaData("Fizika", "Murod", R.drawable.b201));
//        reklamaData.add(new ReklamaData("Kimyo", "Javohir", R.drawable.b202));
//        reklamaData.add(new ReklamaData("Biologiya", "Malika", R.drawable.b205));
//        reklamaData.add(new ReklamaData("Astronomiya", "Abror", R.drawable.b215));
//        reklamaData.add(new ReklamaData("Geografiya", "Ozoda", R.drawable.b218));
//        reklamaData.add(new ReklamaData("Tarix", "Otabek", R.drawable.b219));
//        reklamaData.add(new ReklamaData("O‘zbek tili va adabiyoti", "Mahliyo", R.drawable.b223));
//        reklamaData.add(new ReklamaData("Ingliz tili", "Nilufar", R.drawable.b226));
//        reklamaData.add(new ReklamaData("Nemis tili", "Nargiza", R.drawable.b227));
//        reklamaData.add(new ReklamaData("Informatika", "Alisher", R.drawable.b239));

        setReklamaRecycler(reklamaData);

    }

    private void setReklamaRecycler(List<ReklamaData> reklamaRecycler) {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new Reklama_Adapter(getApplicationContext(), reklamaRecycler);
        mRecyclerView.setAdapter(adapter);
    }
}