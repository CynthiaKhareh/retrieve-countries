package com.example.countrycodes;

import com.google.gson.annotations.SerializedName;

class Country {


    @SerializedName("name")
    private String name;
    @SerializedName("alpha2Code")
    private String alpha2Code;
    @SerializedName("flag")
    private String flag;

    @SerializedName("population")
    private String population;

    public Country(String name, String alpha2Code, String flag, String population) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.flag = flag;
        this.population = population;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
