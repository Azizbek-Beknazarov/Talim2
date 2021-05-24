package com.example.talim.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Adapter.Oliygoh_Adapter;
import com.example.talim.Model.OliygohlarData;
import com.example.talim.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class OliygohlarActivity extends AppCompatActivity {
    EditText search;
    RecyclerView mRecyclerView;
    Oliygoh_Adapter adapter;
    List<OliygohlarData> oliygohlarData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_oliygohlar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.university);
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

        oliygohlarData = new ArrayList<>();
        oliygohlarData.add(new OliygohlarData("O’zbekiston milliy universiteti"));
        oliygohlarData.add(new OliygohlarData("Toshkent davlat texnika universiteti"));
        oliygohlarData.add(new OliygohlarData("Toshkent davlat iqtisodiyot universiteti"));
        oliygohlarData.add(new OliygohlarData("O’zbekiston davlat jahon tillari universiteti"));
        oliygohlarData.add(new OliygohlarData("Toshkent davlat sharqshunoslik instituti"));
        oliygohlarData.add(new OliygohlarData("Samarqand davlat universiteti"));
        oliygohlarData.add(new OliygohlarData("Toshkent Islom Universiteti"));
        oliygohlarData.add(new OliygohlarData("Jahon iqtisodiyoti va diplomatiya universiteti"));
        oliygohlarData.add(new OliygohlarData("Toshkent davlat yuridik universiteti"));
        oliygohlarData.add(new OliygohlarData("Toshkent Halqaro Westminster universitet"));

        setOliygohRecycler(oliygohlarData);
        search = findViewById(R.id.search_et);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String s) {
        List<OliygohlarData> filteredList = new ArrayList<>();
        for (OliygohlarData item : oliygohlarData) {
            if (item.getNomi().toLowerCase().contains(s.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    private void setOliygohRecycler(List<OliygohlarData> oliygohRecycler) {
        mRecyclerView = findViewById(R.id.recyclerviewo);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new Oliygoh_Adapter(getApplicationContext(), oliygohRecycler);
        mRecyclerView.setAdapter(adapter);
    }
}