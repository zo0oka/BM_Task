package com.zo0okadev.bmtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class TotalNutrientsKCal {
    @SerializedName("ENERC_KCAL")
    @Expose
    private TotalNutrientCalories enercKcal;
    @SerializedName("PROCNT_KCAL")
    @Expose
    private TotalNutrientCalories procntKcal;
    @SerializedName("FAT_KCAL")
    @Expose
    private TotalNutrientCalories fatKcal;
    @SerializedName("CHOCDF_KCAL")
    @Expose
    private TotalNutrientCalories chocdfKcal;

    public TotalNutrientCalories getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(TotalNutrientCalories enercKcal) {
        this.enercKcal = enercKcal;
    }

    public TotalNutrientCalories getProcntKcal() {
        return procntKcal;
    }

    public void setProcntKcal(TotalNutrientCalories procntKcal) {
        this.procntKcal = procntKcal;
    }

    public TotalNutrientCalories getFatKcal() {
        return fatKcal;
    }

    public void setFatKcal(TotalNutrientCalories fatKcal) {
        this.fatKcal = fatKcal;
    }

    public TotalNutrientCalories getChocdfKcal() {
        return chocdfKcal;
    }

    public void setChocdfKcal(TotalNutrientCalories chocdfKcal) {
        this.chocdfKcal = chocdfKcal;
    }

}
