package com.zo0okadev.bmtask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zo0okaDev (https://github.com/zo0oka)
 * On 06 Jul, 2021.
 * Have a nice day!
 */
public class TotalNutrients {
    @SerializedName("ENERC_KCAL")
    @Expose
    private Nutrient enercKcal;
    @SerializedName("FAT")
    @Expose
    private Nutrient fat;
    @SerializedName("FASAT")
    @Expose
    private Nutrient fasat;
    @SerializedName("FAMS")
    @Expose
    private Nutrient fams;
    @SerializedName("FAPU")
    @Expose
    private Nutrient fapu;
    @SerializedName("CHOCDF")
    @Expose
    private Nutrient chocdf;
    @SerializedName("PROCNT")
    @Expose
    private Nutrient procnt;
    @SerializedName("CHOLE")
    @Expose
    private Nutrient chole;
    @SerializedName("NA")
    @Expose
    private Nutrient na;
    @SerializedName("CA")
    @Expose
    private Nutrient ca;
    @SerializedName("MG")
    @Expose
    private Nutrient mg;
    @SerializedName("K")
    @Expose
    private Nutrient k;
    @SerializedName("FE")
    @Expose
    private Nutrient fe;
    @SerializedName("ZN")
    @Expose
    private Nutrient zn;
    @SerializedName("P")
    @Expose
    private Nutrient p;
    @SerializedName("VITC")
    @Expose
    private Nutrient vitc;
    @SerializedName("THIA")
    @Expose
    private Nutrient thia;
    @SerializedName("RIBF")
    @Expose
    private Nutrient ribf;
    @SerializedName("NIA")
    @Expose
    private Nutrient nia;
    @SerializedName("VITB6A")
    @Expose
    private Nutrient vitb6a;
    @SerializedName("FOLDFE")
    @Expose
    private Nutrient foldfe;
    @SerializedName("FOLFD")
    @Expose
    private Nutrient folfd;
    @SerializedName("FIBTG")
    @Expose
    private Nutrient fiber;
    @SerializedName("SUGAR")
    @Expose
    private Nutrient sugar;
    @SerializedName("FOLAC")
    @Expose
    private Nutrient folac;
    @SerializedName("VITB12")
    @Expose
    private Nutrient vitb12;
    @SerializedName("VITD")
    @Expose
    private Nutrient vitd;
    @SerializedName("WATER")
    @Expose
    private Nutrient water;

    public Nutrient getFiber() {
        return fiber;
    }

    public void setFiber(Nutrient fiber) {
        this.fiber = fiber;
    }

    public Nutrient getSugar() {
        return sugar;
    }

    public void setSugar(Nutrient sugar) {
        this.sugar = sugar;
    }

    public Nutrient getEnercKcal() {
        return enercKcal;
    }

    public void setEnercKcal(Nutrient enercKcal) {
        this.enercKcal = enercKcal;
    }

    public Nutrient getFat() {
        return fat;
    }

    public void setFat(Nutrient fat) {
        this.fat = fat;
    }

    public Nutrient getFasat() {
        return fasat;
    }

    public void setFasat(Nutrient fasat) {
        this.fasat = fasat;
    }

    public Nutrient getFams() {
        return fams;
    }

    public void setFams(Nutrient fams) {
        this.fams = fams;
    }

    public Nutrient getFapu() {
        return fapu;
    }

    public void setFapu(Nutrient fapu) {
        this.fapu = fapu;
    }

    public Nutrient getChocdf() {
        return chocdf;
    }

    public void setChocdf(Nutrient chocdf) {
        this.chocdf = chocdf;
    }

    public Nutrient getProcnt() {
        return procnt;
    }

    public void setProcnt(Nutrient procnt) {
        this.procnt = procnt;
    }

    public Nutrient getChole() {
        return chole;
    }

    public void setChole(Nutrient chole) {
        this.chole = chole;
    }

    public Nutrient getNa() {
        return na;
    }

    public void setNa(Nutrient na) {
        this.na = na;
    }

    public Nutrient getCa() {
        return ca;
    }

    public void setCa(Nutrient ca) {
        this.ca = ca;
    }

    public Nutrient getMg() {
        return mg;
    }

    public void setMg(Nutrient mg) {
        this.mg = mg;
    }

    public Nutrient getK() {
        return k;
    }

    public void setK(Nutrient k) {
        this.k = k;
    }

    public Nutrient getFe() {
        return fe;
    }

    public void setFe(Nutrient fe) {
        this.fe = fe;
    }

    public Nutrient getZn() {
        return zn;
    }

    public void setZn(Nutrient zn) {
        this.zn = zn;
    }

    public Nutrient getP() {
        return p;
    }

    public void setP(Nutrient p) {
        this.p = p;
    }

    public Nutrient getVitc() {
        return vitc;
    }

    public void setVitc(Nutrient vitc) {
        this.vitc = vitc;
    }

    public Nutrient getThia() {
        return thia;
    }

    public void setThia(Nutrient thia) {
        this.thia = thia;
    }

    public Nutrient getRibf() {
        return ribf;
    }

    public void setRibf(Nutrient ribf) {
        this.ribf = ribf;
    }

    public Nutrient getNia() {
        return nia;
    }

    public void setNia(Nutrient nia) {
        this.nia = nia;
    }

    public Nutrient getVitb6a() {
        return vitb6a;
    }

    public void setVitb6a(Nutrient vitb6a) {
        this.vitb6a = vitb6a;
    }

    public Nutrient getFoldfe() {
        return foldfe;
    }

    public void setFoldfe(Nutrient foldfe) {
        this.foldfe = foldfe;
    }

    public Nutrient getFolfd() {
        return folfd;
    }

    public void setFolfd(Nutrient folfd) {
        this.folfd = folfd;
    }

    public Nutrient getFolac() {
        return folac;
    }

    public void setFolac(Nutrient folac) {
        this.folac = folac;
    }

    public Nutrient getVitb12() {
        return vitb12;
    }

    public void setVitb12(Nutrient vitb12) {
        this.vitb12 = vitb12;
    }

    public Nutrient getVitd() {
        return vitd;
    }

    public void setVitd(Nutrient vitd) {
        this.vitd = vitd;
    }

    public Nutrient getWater() {
        return water;
    }

    public void setWater(Nutrient water) {
        this.water = water;
    }
}
