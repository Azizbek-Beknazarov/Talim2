package com.example.talim.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.talim.Model.Foydalanuvchilar;
import com.example.talim.Database.Dao.FoydalanuvchilarDAO;
import com.example.talim.Database.FoydalanuvchilarDataBase;
import com.example.talim.R;

public class LogInActivity extends AppCompatActivity {
    TextView mParolniUnitdingizmi;
    EditText mEmail, mParol;
    Button mKirish;

    FoydalanuvchilarDAO mFoydalanuvchilarDAO;
    FoydalanuvchilarDataBase mFoydalanuvchilarDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_log_in);

        setupUI();

        mFoydalanuvchilarDataBase=FoydalanuvchilarDataBase.getInstance(this);
        mFoydalanuvchilarDAO=mFoydalanuvchilarDataBase.getFoydalanuvchilarDao();
        setupListeners();

    }

    private void setupUI() {
        mEmail = findViewById(R.id.email);
        mParol = findViewById(R.id.parol);
        mKirish = findViewById(R.id.account);
        mParolniUnitdingizmi = findViewById(R.id.parol_unitish);
    }

    private void setupListeners() {
        mKirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();


            }
        });
        mParolniUnitdingizmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, PasswordRecover.class);
                startActivity(intent);
            }
        });

    }

    public void checkUsername() {
        boolean isValid = true;
        if (isEmpty(mEmail)) {
            mEmail.setError("Kirish uchun email kiritishingiz kerak!");
            isValid = false;
        } else {
            if (!isEmail(mEmail)) {
                mEmail.setError("Email xato kiritilgan!");
                isValid = false;
            }
        }

        if (isEmpty(mParol)) {
            mParol.setError("Kirish uchun parol kiritishingiz kerak!");
            isValid = false;
        } else {
            if (mParol.getText().toString().length() < 4) {
                mParol.setError("Parol uzunligi 4 belgidan kam bo‘lmasligi kerak!");
                isValid = false;
            }
        }


        if (isValid) {
            String usernameValue = mEmail.getText().toString();
            String passwordValue = mParol.getText().toString();

            Foydalanuvchilar foydalanuvchilar = mFoydalanuvchilarDAO.getUser(usernameValue, passwordValue);

            if (foydalanuvchilar != null) {

                Intent i = new Intent(LogInActivity.this, OliygohlarActivity.class);
                startActivity(i);
                this.finish();

            } else {
                Toast t = Toast.makeText(this, "Email yoki parol xato!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}