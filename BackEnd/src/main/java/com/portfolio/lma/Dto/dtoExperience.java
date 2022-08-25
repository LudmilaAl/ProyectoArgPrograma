package com.portfolio.lma.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperience {
    @NotBlank
    private String nameExp;
    @NotBlank
    private String descriptionExp;
    @NotBlank
    private String dateExp;

    public dtoExperience() {
    }

    public dtoExperience(String nameExp, String descriptionExp, String dateExp) {
        this.nameExp = nameExp;
        this.descriptionExp = descriptionExp;
        this.dateExp = dateExp;
    }

    public String getNameExp() {
        return nameExp;
    }

    public void setNameExp(String nameExp) {
        this.nameExp = nameExp;
    }

    public String getDescriptionExp() {
        return descriptionExp;
    }

    public void setDescriptionExp(String descriptionExp) {
        this.descriptionExp = descriptionExp;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }
    

    
    
    
}
