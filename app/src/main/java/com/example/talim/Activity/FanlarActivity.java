package com.example.talim.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;
import com.example.talim.Adapter.Fanlar_Adapter;

import java.util.ArrayList;
import java.util.List;

public class FanlarActivity extends AppCompatActivity{
    RecyclerView mRecyclerView;
    Fanlar_Adapter adapter;
    List<FanlarEntity> mFanlarData;
    EditText mSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_fanlar);

        setupUI();

        mFanlarData = new ArrayList<>();
        mFanlarData.add(new FanlarEntity("Ona tili","Anvar",R.drawable.ona));
        mFanlarData.add(new FanlarEntity("Matematika", "Shaxzod", R.drawable.math));
        mFanlarData.add(new FanlarEntity("Fizika", "Murod", R.drawable.fizika));
        mFanlarData.add(new FanlarEntity("Kimyo", "Javohir", R.drawable.kimyo));
        mFanlarData.add(new FanlarEntity("Biologiya", "Malika", R.drawable.biologiya));
        mFanlarData.add(new FanlarEntity("Astronomiya", "Abror", R.drawable.astronomiya));
        mFanlarData.add(new FanlarEntity("Geografiya", "Ozoda", R.drawable.geo));
        mFanlarData.add(new FanlarEntity("Tarix", "Otabek", R.drawable.terix));

        setFanlarRecycler(mFanlarData);

        mSearch.addTextChangedListener(new TextWatcher() {
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
        List<FanlarEntity> filteredList = new ArrayList<>();
        for (FanlarEntity item : mFanlarData) {
            if (item.getFan_nomi().toLowerCase().contains(s.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }


    private void setupUI() {
        mSearch = findViewById(R.id.search_et_f);
    }

    private void setFanlarRecycler(List<FanlarEntity> fanlarData) {
        mRecyclerView = findViewById(R.id.recyclerview_fan);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new Fanlar_Adapter(getApplicationContext(), fanlarData);
        mRecyclerView.setAdapter(adapter);
    }
    }