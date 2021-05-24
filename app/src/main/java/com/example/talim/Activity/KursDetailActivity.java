package com.example.talim.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.talim.Database.FanlarDB;

import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;

public class KursDetailActivity extends AppCompatActivity {
    TextView mFannomi, mUqituvchiIsmi, mIzoh, mPeople, mXabar;
    ImageView mYoqtir, mImageD;
    Context mContext;
    Button mSinov, mObuna;
    int obuna =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_kurs_detail);

        FanlarDB db = FanlarDB.getInstance(KursDetailActivity.this);

        setUI();

        String fan = getIntent().getStringExtra("fan");
        String ismi = getIntent().getStringExtra("uqituvchi");
        int image = getIntent().getIntExtra("image_d", 0);

        mFannomi.setText(fan);
        mUqituvchiIsmi.setText(ismi);
        mImageD.setImageResource(image);

        final FanlarEntity entity = new FanlarEntity(fan, ismi, image);

        int check = entity.getIs_checked();
        if (check == 1) {
            Log.d("@@@", "check red");

            mYoqtir.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
        } else if (check==0){
            Log.d("@@@", "check shadow");

            mYoqtir.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
        }
        mYoqtir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sId = entity.getID();
                if (check == 0) {
                    Log.d("@@@", "check inserted");
                    entity.setIs_checked(1);
                    db.fanlarDao().updatefav(sId, 1);
                    db.fanlarDao().insertFanlar(entity);
                    mYoqtir.setBackgroundResource(R.drawable.ic_favorite_red_24dp);

                } else if (check==1){
                    Log.d("@@@", "check deleted");
                    entity.setIs_checked(0);

                    db.fanlarDao().updatefav(sId, 0);
                    db.fanlarDao().insertFanlar(entity);
                    mYoqtir.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);

                }

            }
        });



        mSinov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(KursDetailActivity.this, SinovDars.class);
                intent.putExtra("fan",mFannomi.getText().toString());
                startActivity(intent);
            }
        });

        mObuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sId=entity.getID();
//                entity.setObuna(1);
                db.fanlarDao().updateObuna(sId,1);
                Log.d("@@@", "obuna qilindi");
            }
        });
    }


    private void setUI() {
        mFannomi = findViewById(R.id.fannomi);
        mUqituvchiIsmi = findViewById(R.id.uqituvchiIsmi);
        mIzoh = findViewById(R.id.izoh);
        mPeople = findViewById(R.id.people);
        mXabar = findViewById(R.id.xabar);
        mYoqtir = findViewById(R.id.yoqtir1);
        mImageD = findViewById(R.id.imaga_detail);
        mSinov = findViewById(R.id.bepul);
        mObuna = findViewById(R.id.yozilish);
    }
}