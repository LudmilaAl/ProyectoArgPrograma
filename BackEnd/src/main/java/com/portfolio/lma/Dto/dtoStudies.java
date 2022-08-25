
package com.portfolio.lma.Dto;

import javax.validation.constraints.NotBlank;


public class dtoStudies {
    @NotBlank
    private String degreeS;
    @NotBlank
    private String dateS;
    @NotBlank
    private String institutionS;

    public dtoStudies() {
    }

    public dtoStudies(String degreeS, String dateS, String institutionS) {
        this.degreeS = degreeS;
        this.dateS = dateS;
        this.institutionS = institutionS;
    }

    public String getDegreeS() {
        return degreeS;
    }

    public void setDegreeS(String degreeS) {
        this.degreeS = degreeS;
    }

    public String getDateS() {
        return dateS;
    }

    public void setDateS(String dateS) {
        this.dateS = dateS;
    }

    public String getInstitutionS() {
        return institutionS;
    }

    public void setInstitutionS(String institutionS) {
        this.institutionS = institutionS;
    }
    
    
    
    
    
}
