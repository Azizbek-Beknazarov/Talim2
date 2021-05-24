package com.example.talim.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.talim.Adapter.YoqtirganlarAdapter;
import com.example.talim.Database.FanlarDB;
import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;

import java.util.ArrayList;
import java.util.List;

public class YoqtirganlarActivity extends AppCompatActivity {
    List<FanlarEntity> mList;
    Context mContext;
    RecyclerView mRecyclerView;
    YoqtirganlarAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_yoqtirganlar);

        mRecyclerView = findViewById(R.id.recyclerview_yoq);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FanlarDB db = FanlarDB.getInstance(this);
        List<FanlarEntity> list = new ArrayList<>();
//        list.addAll(db.fanlarDao().getFavorities());

        mAdapter = new YoqtirganlarAdapter(list, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}