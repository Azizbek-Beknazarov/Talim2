package com.example.talim.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.talim.Database.Dao.FoydalanuvchilarDAO;
import com.example.talim.Model.Foydalanuvchilar;

@Database(entities = Foydalanuvchilar.class, version = 1, exportSchema = false)
public abstract class FoydalanuvchilarDataBase extends RoomDatabase {
    private static FoydalanuvchilarDataBase instance;
    public abstract FoydalanuvchilarDAO getFoydalanuvchilarDao();

    public static FoydalanuvchilarDataBase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext()
            ,FoydalanuvchilarDataBase.class
            ,"Foydalanuvchilar.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }



}
