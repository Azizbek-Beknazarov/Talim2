package com.example.talim.Database.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.talim.Model.Foydalanuvchilar;

@Dao
public interface FoydalanuvchilarDAO {

    @Query("SELECT * FROM Foydalanuvchilar where email= :mail and password= :password")
    Foydalanuvchilar getUser(String mail, String password);

    @Insert
    void insert(Foydalanuvchilar user);


}
