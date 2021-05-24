package com.example.talim.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Adapter.ObunaAdapter;
import com.example.talim.Adapter.YoqtirganlarAdapter;
import com.example.talim.Database.FanlarDB;
import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ObunalarActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<FanlarEntity> mList;
    ObunaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_obunalar);

        mRecyclerView = findViewById(R.id.recyclerview_obuna);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FanlarDB db = FanlarDB.getInstance(this);
//        FanlarEntity entity = (FanlarEntity) db.fanlarDao().getAllObuna();
//        mList.add(entity);

        mAdapter = new ObunaAdapter(mList, this);
        mRecyclerView.setAdapter(mAdapter);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.obunalar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.obunalar: {

                        return true;

                    }
                    case R.id.university: {
                        startActivity(new Intent(getApplicationContext(), OliygohlarActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    }
                    case R.id.yangilar: {
                        startActivity(new Intent(getApplicationContext(), ReklamaActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
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

    }
}