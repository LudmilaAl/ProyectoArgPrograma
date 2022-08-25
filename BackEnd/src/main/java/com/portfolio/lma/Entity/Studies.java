/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lma.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String degreeS;
    private String dateS;
    private String institutionS;

    public Studies() {
    }

    public Studies(String degreeS, String dateS, String institutionS) {
        this.degreeS = degreeS;
        this.dateS = dateS;
        this.institutionS = institutionS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
