package com.example.talim.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "fanlar_table")
public class FanlarEntity {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    @ColumnInfo(name = "fan_nomi")
    private String fan_nomi;

    @ColumnInfo(name = "uqituvchi_ismi")
    private String uqituvchi_ismi;

    @ColumnInfo(name = "imageUrl")
    private Integer imageUrl;

    @ColumnInfo(name = "is_checked")
    private int is_checked=0 ;

    @ColumnInfo(name = "obuna")
    private int obuna;

    public int getObuna() {
        return obuna;
    }

    public void setObuna(int obuna) {
        this.obuna = obuna;
    }

    public int getIs_checked() {
        return is_checked;
    }

    public void setIs_checked(int is_checked) {
        this.is_checked = is_checked;
    }



    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getID() {
        return ID;
    }

    public String getFan_nomi() {
        return fan_nomi;
    }

    public String getUqituvchi_ismi() {
        return uqituvchi_ismi;
    }


    public FanlarEntity(String fan_nomi, String uqituvchi_ismi, Integer imageUrl) {
        this.imageUrl = imageUrl;
        this.fan_nomi = fan_nomi;
        this.uqituvchi_ismi = uqituvchi_ismi;
    }


}
