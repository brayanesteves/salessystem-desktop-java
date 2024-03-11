package com.halconbit.salessystem.desktop.maven.javav17.controllers;

import com.halconbit.salessystem.desktop.maven.javav17.dao.NaturalPersonDAO;
import com.halconbit.salessystem.desktop.maven.javav17.entities.NaturalPerson;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NaturalPersonController {
    
    private NaturalPersonDAO naturalPersonDAO;
    private NaturalPerson naturalPerson;
    private DefaultTableModel defaultTableModel;

    public NaturalPersonController() {
        this.naturalPersonDAO = new NaturalPersonDAO();
        this.naturalPerson = new NaturalPerson();
    }
    
    public DefaultTableModel list() {
        String[] titles = {"Rfrnc", "Rfrnc_Ncnlty", "Rfrnc_Cntry", "IdntfctnDcmnt", "Nms", "Srnms", "RfrntlPhnNmbr", "TxAddrss", "Cndtn", "Rmvd", "Lckd", "DtAdmss", "ChckTm"};
        this.defaultTableModel = new DefaultTableModel(null, titles);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String[] records = new String[titles.length];
        List<NaturalPerson> list = this.naturalPersonDAO.list();
        for(NaturalPerson item : list) {
            records[0] = Integer.toString(item.getRfrnc());
            records[1] = Integer.toString(item.getRfrnc_Ncnlty());
            records[2] = Integer.toString(item.getRfrnc_Cntry());
            records[3] = item.getIdntfctnDcmnt();
            records[4] = item.getNms();
            records[5] = item.getSrnms();
            records[6] = item.getRfrntlPhnNmbr();
            records[7] = item.getTxAddrss();            
            records[8] = Integer.toString(item.getCndtn());
            records[9] = Integer.toString(item.getRmvd());
            records[10] = Integer.toString(item.getLckd());
            records[11] = dateFormat.format(item.getDtAdmss());
            records[12] = item.getChckTm().toString();
            this.defaultTableModel.addRow(records);
        }
        return this.defaultTableModel;
    }
    
    public String create(Integer Rfrnc_Ncnlty,
    Integer Rfrnc_Cntry,
    String IdntfctnDcmnt,
    String Nms,
    String Srnms,
    String RfrntlPhnNmbr,
    String TxAddrss, Integer Cndtn, Integer Rmvd, Integer Lckd, Date DtAdmss, Time ChckTm) {
        
    }
    
}
