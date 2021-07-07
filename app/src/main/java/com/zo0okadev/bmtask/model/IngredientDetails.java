package com.zo0okadev.bmtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class IngredientDetails {
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("yield")
    @Expose
    private double yield;
    private String foodName;
    @SerializedName("calories")
    @Expose
    private int calories;
    @SerializedName("totalWeight")
    @Expose
    private double totalWeight;
    @SerializedName("dietLabels")
    @Expose
    private List<String> dietLabels = null;
    @SerializedName("healthLabels")
    @Expose
    private List<String> healthLabels = null;
    @SerializedName("cautions")
    @Expose
    private List<String> cautions = null;
    @SerializedName("totalNutrients")
    @Expose
    private TotalNutrients totalNutrients;
    @SerializedName("totalDaily")
    @Expose
    private TotalDaily totalDaily;
    @SerializedName("totalNutrientsKCal")
    @Expose
    private TotalNutrientsKCal totalNutrientsKCal;

    public static double getTotalVitamins(IngredientDetails details) {
        double totalVitC = 0, totalVitB6 = 0, totalVitB12 = 0, totalVitD = 0;
        double vitaminCSupply = 0, vitaminB6Supply = 0, vitaminB12Supply = 0, vitaminDSupply = 0;

        if (details.totalDaily.getVitc() != null) {
            vitaminCSupply = details.getTotalNutrients().getVitc().getQuantity();
            double vitaminCDaily = details.getTotalDaily().getVitc().getQuantity();
            totalVitC = vitaminCSupply / vitaminCDaily;
        }

        if (details.totalDaily.getVitb6a() != null) {
            vitaminB6Supply = details.getTotalNutrients().getVitb6a().getQuantity();
            double vitaminB6Daily = details.getTotalDaily().getVitb6a().getQuantity();
            totalVitB6 = vitaminB6Supply / vitaminB6Daily;
        }

        if (details.totalDaily.getVitb12() != null) {
            vitaminB12Supply = details.getTotalNutrients().getVitb12().getQuantity();
            double vitaminB12Daily = details.getTotalDaily().getVitb12().getQuantity();
            totalVitB12 = vitaminB12Supply / vitaminB12Daily;
        }

        if (details.totalDaily.getVitd() != null) {
            vitaminDSupply = details.getTotalNutrients().getVitd().getQuantity();
            double vitaminDDaily = details.getTotalDaily().getVitd().getQuantity();
            totalVitD = vitaminDSupply / vitaminDDaily;
        }

        double totalVitaminsNeed = totalVitC + totalVitB6 + totalVitB12 + totalVitD;
        double totalVitaminsSupplied = vitaminCSupply + vitaminB6Supply + vitaminB12Supply + vitaminDSupply;

        return !Double.isNaN((totalVitaminsSupplied / totalVitaminsNeed)) ? Math.round(((totalVitaminsSupplied / totalVitaminsNeed) * 100) / 100) : 0;
    }

    public static double getTotalCarbs(IngredientDetails details) {
        double totalCarbs = 0, totalSugar = 0, totalFiber = 0;
        double carbsSupplied = 0, sugarSupplied = 0, fiberSupply = 0;

        if (details.getTotalDaily().getChocdf() != null) {
            carbsSupplied = details.getTotalNutrients().getChocdf().getQuantity();
            double carbsDaily = details.getTotalDaily().getChocdf().getQuantity();
            totalCarbs = carbsSupplied / carbsDaily;
        }

        if (details.getTotalDaily().getSugar() != null) {
            sugarSupplied = details.getTotalNutrients().getSugar().getQuantity();
            double sugarDaily = details.getTotalDaily().getSugar().getQuantity();
            totalSugar = sugarSupplied / sugarDaily;
        }

        if (details.totalDaily.getFiber() != null) {
            fiberSupply = details.getTotalNutrients().getFiber().getQuantity();
            double fiberDaily = details.getTotalDaily().getFiber().getQuantity();
            totalFiber = fiberSupply / fiberDaily;
        }

        double totalCarbsNeed = totalCarbs + totalSugar + totalFiber;
        double totalCarbsSupplied = carbsSupplied + sugarSupplied + fiberSupply;

        return !Double.isNaN((totalCarbsSupplied / totalCarbsNeed)) ? Math.round(((totalCarbsSupplied / totalCarbsNeed) * 100) / 100) : 0;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public List<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public List<String> getCautions() {
        return cautions;
    }

    public void setCautions(List<String> cautions) {
        this.cautions = cautions;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public TotalNutrientsKCal getTotalNutrientsKCal() {
        return totalNutrientsKCal;
    }

    public void setTotalNutrientsKCal(TotalNutrientsKCal totalNutrientsKCal) {
        this.totalNutrientsKCal = totalNutrientsKCal;
    }

}
