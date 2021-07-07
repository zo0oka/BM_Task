package com.zo0okadev.bmtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class Nutrient {
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuantity() {
        return (Math.round((quantity * 100) / 100));
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
