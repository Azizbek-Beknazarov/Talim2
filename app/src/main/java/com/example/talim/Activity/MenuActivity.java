package com.example.talim.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.talim.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menyu);
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
                        startActivity(new Intent(getApplicationContext(), ReklamaActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    }

                    case R.id.menyu: {
//                        finish();
                        return true;
                    }
                }
                return true;
            }
        });
    }

    public void profile_click(View view) {
        startActivity(new Intent(getApplicationContext(),Profil_activity.class));

    }

    public void favorite_click(View view) {
        startActivity(new Intent(getApplicationContext(),YoqtirganlarActivity.class));

    }

    public void kurilgan_click(View view) {
        startActivity(new Intent(getApplicationContext(),KurilganlarActivity.class));

    }
}