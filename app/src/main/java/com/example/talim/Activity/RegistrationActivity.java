package com.example.talim.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class RegistrationActivity extends AppCompatActivity {
    TextView mKirish;
    EditText mEmail, mIsm, mFamiliya, mParol, mConfParol;
    Button mRegistratsiya;
    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "my_pref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private FoydalanuvchilarDAO mFoydalanuvchilarDAO;
    FoydalanuvchilarDataBase mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_registration);

        setupUI();

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String test = preferences.getString(KEY_EMAIL, null);
        if (test != null) {
            startActivity(new Intent(RegistrationActivity.this, ObunalarActivity.class));
            finish();
        }

       mDataBase=FoydalanuvchilarDataBase.getInstance(this);
        mFoydalanuvchilarDAO=mDataBase.getFoydalanuvchilarDao();

        mRegistratsiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                malumot_tekshirish();
                SharedPreferences.Editor editor = preferences.edit();

                String userName = mIsm.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mParol.getText().toString().trim();
                String passwordConf = mConfParol.getText().toString().trim();

                editor.putString(KEY_NAME, userName);
                editor.putString(KEY_EMAIL, email);
                editor.putString(KEY_PASSWORD, password);
                editor.apply();

                if (password.equals(passwordConf)
                        && !password.isEmpty()
                        && !email.isEmpty()
                        && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Foydalanuvchilar user = new Foydalanuvchilar(userName, email, password);
                    mFoydalanuvchilarDAO.insert(user);
                    Intent moveToLogin = new Intent(RegistrationActivity.this, LogInActivity.class);
                    startActivity(moveToLogin);
                    finish();

                } else {
                    Toast.makeText(RegistrationActivity.this, "Parollar yoki email mos emas!", Toast.LENGTH_SHORT).show();

                }
            }
        });


        mKirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void malumot_tekshirish() {
        if (isEmpty(mIsm)) {
            mIsm.setError("Ism kiritilmagan!");
        }
        if (isEmail(mEmail)) {
            mEmail.setError("Email xato kiritilgan!");
        }

        if (isEmpty(mFamiliya)) {
            mFamiliya.setError("Familiya kiritilmagan!");
        }
        if (isEmpty(mParol)) {
            mParol.setError("Parol kiritilmagan!");
        }
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void setupUI() {
        mEmail = findViewById(R.id.email);
        mIsm = findViewById(R.id.ism);
        mFamiliya = findViewById(R.id.familiya);
        mParol = findViewById(R.id.parol);
        mConfParol = findViewById(R.id.confparol);
        mRegistratsiya = findViewById(R.id.account);
        mKirish = findViewById(R.id.kirish);
    }

}
