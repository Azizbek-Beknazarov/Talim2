package com.example.talim.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.talim.Model.FanlarEntity;

import java.util.List;

@Dao
public interface FanlarDao {


    @Query("SELECT * FROM fanlar_table")
    List<FanlarEntity> getAll();

    @Query("SELECT * FROM fanlar_table WHERE ID=:id ")
    List<FanlarEntity> getFavorities(int id);

    @Query("UPDATE fanlar_table SET is_checked =:check WHERE ID=:sID")
    void updatefav(int sID, int check);

    @Query("UPDATE fanlar_table SET obuna =:obuna WHERE ID=:sID")
    void updateObuna(int sID, int obuna);

    @Query("SELECT *FROM fanlar_table WHERE is_checked=1")
    List<FanlarEntity> getAllFAV();

    @Query("SELECT *FROM fanlar_table WHERE obuna=1")
    List<FanlarEntity> getAllObuna();

    @Insert
    void insertFanlar(FanlarEntity fanlarEntity);

    @Delete
    void deleteFanlar(FanlarEntity fanlarEntity);


}
