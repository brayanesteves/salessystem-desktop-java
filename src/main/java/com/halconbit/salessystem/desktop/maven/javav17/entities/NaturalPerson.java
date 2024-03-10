package com.halconbit.salessystem.desktop.maven.javav17.entities;

import java.sql.Time;
import java.util.Date;

public class NaturalPerson {
    
    private int Rfrnc;
    private int Rfrnc_Ncnlty;
    private int Rfrnc_Cntry;
    private String IdntfctnDcmnt;
    private String Nms;
    private String Srnms;
    private String RfrntlPhnNmbr;
    private String TxAddrss;
    private int Cndtn;
    private int Rmvd;
    private int Lckd;
    private Date DtAdmss;
    private Time ChckTm;

    public NaturalPerson() {
    }

    public NaturalPerson(int Rfrnc, int Rfrnc_Ncnlty, int Rfrnc_Cntry, String IdntfctnDcmnt, String Nms, String Srnms, String RfrntlPhnNmbr, String TxAddrss, int Cndtn, int Rmvd, int Lckd, Date DtAdmss, Time ChckTm) {
        this.Rfrnc = Rfrnc;
        this.Rfrnc_Ncnlty = Rfrnc_Ncnlty;
        this.Rfrnc_Cntry = Rfrnc_Cntry;
        this.IdntfctnDcmnt = IdntfctnDcmnt;
        this.Nms = Nms;
        this.Srnms = Srnms;
        this.RfrntlPhnNmbr = RfrntlPhnNmbr;
        this.TxAddrss = TxAddrss;
        this.Cndtn = Cndtn;
        this.Rmvd = Rmvd;
        this.Lckd = Lckd;
        this.DtAdmss = DtAdmss;
        this.ChckTm = ChckTm;
    }
    
    

    public int getRfrnc() {
        return Rfrnc;
    }

    public void setRfrnc(int Rfrnc) {
        this.Rfrnc = Rfrnc;
    }

    public int getRfrnc_Ncnlty() {
        return Rfrnc_Ncnlty;
    }

    public void setRfrnc_Ncnlty(int Rfrnc_Ncnlty) {
        this.Rfrnc_Ncnlty = Rfrnc_Ncnlty;
    }

    public int getRfrnc_Cntry() {
        return Rfrnc_Cntry;
    }

    public void setRfrnc_Cntry(int Rfrnc_Cntry) {
        this.Rfrnc_Cntry = Rfrnc_Cntry;
    }

    public String getIdntfctnDcmnt() {
        return IdntfctnDcmnt;
    }

    public void setIdntfctnDcmnt(String IdntfctnDcmnt) {
        this.IdntfctnDcmnt = IdntfctnDcmnt;
    }

    public String getNms() {
        return Nms;
    }

    public void setNms(String Nms) {
        this.Nms = Nms;
    }

    public String getSrnms() {
        return Srnms;
    }

    public void setSrnms(String Srnms) {
        this.Srnms = Srnms;
    }

    public String getRfrntlPhnNmbr() {
        return RfrntlPhnNmbr;
    }

    public void setRfrntlPhnNmbr(String RfrntlPhnNmbr) {
        this.RfrntlPhnNmbr = RfrntlPhnNmbr;
    }

    public String getTxAddrss() {
        return TxAddrss;
    }

    public void setTxAddrss(String TxAddrss) {
        this.TxAddrss = TxAddrss;
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

    public Date getDtAdmss() {
        return DtAdmss;
    }

    public void setDtAdmss(Date DtAdmss) {
        this.DtAdmss = DtAdmss;
    }

    public Time getChckTm() {
        return ChckTm;
    }

    public void setChckTm(Time ChckTm) {
        this.ChckTm = ChckTm;
    }
    
    
}
