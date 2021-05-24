package com.example.talim.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.talim.Database.Dao.FanlarDao;
import com.example.talim.Model.FanlarEntity;

@Database(entities = FanlarEntity.class, exportSchema = false, version = 2)
public abstract class FanlarDB extends RoomDatabase {
    private static final String DB_NAME = "fanlarDB";
    private static FanlarDB instance;

    public static synchronized FanlarDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), FanlarDB.class, DB_NAME)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract FanlarDao fanlarDao();
}
