package com.halconbit.salessystem.desktop.maven.javav17.entities;

import java.sql.Time;
import java.util.Date;

public class Person {
    
    private int Rfrnc;
    private int Rfrnc_Prsn;
    private int Rfrnc_TypPrsn;
    private int Cndtn;
    private int Rmvd;
    private int Lckd;
    private Date DtAdmssn;
    private Time ChckTm;

    public Person() {
    }

    public Person(int Rfrnc, int Rfrnc_Prsn, int Rfrnc_TypPrsn, int Cndtn, int Rmvd, int Lckd, Date DtAdmssn, Time ChckTm) {
        this.Rfrnc = Rfrnc;
        this.Rfrnc_Prsn = Rfrnc_Prsn;
        this.Rfrnc_TypPrsn = Rfrnc_TypPrsn;
        this.Cndtn = Cndtn;
        this.Rmvd = Rmvd;
        this.Lckd = Lckd;
        this.DtAdmssn = DtAdmssn;
        this.ChckTm = ChckTm;
    }
    
    

    public int getRfrnc() {
        return Rfrnc;
    }

    public void setRfrnc(int Rfrnc) {
        this.Rfrnc = Rfrnc;
    }

    public int getRfrnc_Prsn() {
        return Rfrnc_Prsn;
    }

    public void setRfrnc_Prsn(int Rfrnc_Prsn) {
        this.Rfrnc_Prsn = Rfrnc_Prsn;
    }

    public int getRfrnc_TypPrsn() {
        return Rfrnc_TypPrsn;
    }

    public void setRfrnc_TypPrsn(int Rfrnc_TypPrsn) {
        this.Rfrnc_TypPrsn = Rfrnc_TypPrsn;
    }

    public int getCndtn() {
        return Cndtn;
    }

    public void setCndtn(int Cndtn) {
        this.Cndtn = Cndtn;
    }

    public int getRmvd() {
        return Rmvd;
    }

    public void setRmvd(int Rmvd) {
        this.Rmvd = Rmvd;
    }

    public int getLckd() {
        return Lckd;
    }

    public void setLckd(int Lckd) {
        this.Lckd = Lckd;
    }

    public Date getDtAdmssn() {
        return DtAdmssn;
    }

    public void setDtAdmssn(Date DtAdmssn) {
        this.DtAdmssn = DtAdmssn;
    }

    public Time getChckTm() {
        return ChckTm;
    }

    public void setChckTm(Time ChckTm) {
        this.ChckTm = ChckTm;
    }
    
    
}
